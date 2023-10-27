package mao.geoservice.service.impl;

import com.alibaba.fastjson.JSONArray;
import mao.geoservice.service.GeoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.trim;

/**
 * Project name(项目名称)：GeoService
 * Package(包名): mao.geoservice.service.impl
 * Class(类名): GeoServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/10/27
 * Time(创建时间)： 9:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Service
public class GeoServiceImpl implements GeoService
{
    private static final double pi = Math.PI;

    private static final double r = 6371000;

    private static final double c = (pi * r) / 180D;

    private static final Logger log = LoggerFactory.getLogger(GeoServiceImpl.class);

    @Override
    public boolean pointIsInPolygon(Point2D.Double point, List<Point2D.Double> pointList)
    {
        int N = pointList.size();
        boolean boundOrVertex = true;
        //交叉点数量
        int intersectCount = 0;
        //浮点类型计算时候与0比较时候的容差
        double precision = 2e-10;
        //临近顶点
        Point2D.Double p1, p2;
        //当前点
        Point2D.Double p = point;

        p1 = pointList.get(0);
        for (int i = 1; i <= N; ++i)
        {
            if (p.equals(p1))
            {
                return boundOrVertex;
            }

            p2 = pointList.get(i % N);
            if (p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x))
            {
                p1 = p2;
                continue;
            }

            //射线穿过算法
            if (p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x))
            {
                if (p.y <= Math.max(p1.y, p2.y))
                {
                    if (p1.x == p2.x && p.y >= Math.min(p1.y, p2.y))
                    {
                        return boundOrVertex;
                    }

                    if (p1.y == p2.y)
                    {
                        if (p1.y == p.y)
                        {
                            return boundOrVertex;
                        }
                        else
                        {
                            ++intersectCount;
                        }
                    }
                    else
                    {
                        double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;
                        if (Math.abs(p.y - xinters) < precision)
                        {
                            return boundOrVertex;
                        }

                        if (p.y < xinters)
                        {
                            ++intersectCount;
                        }
                    }
                }
            }
            else
            {
                if (p.x == p2.x && p.y <= p2.y)
                {
                    Point2D.Double p3 = pointList.get((i + 1) % N);
                    if (p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x))
                    {
                        ++intersectCount;
                    }
                    else
                    {
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;
        }
        if (intersectCount % 2 == 0)
        {
            //偶数在多边形外
            return false;
        }
        else
        {
            //奇数在多边形内
            return true;
        }
    }

    /**
     * 解析点和围栏字符串
     *
     * @param pointString     点字符串
     * @param pointListString 点列表字符串
     * @param point           点
     * @param pointList       点列表
     */
    private void stringToPoint2DDouble(String pointString, String pointListString,
                                       Point2D.Double point, List<Point2D.Double> pointList)
    {
        List list = (List) JSONArray.parse(pointListString);
        for (Object o : list)
        {
            Point2D.Double d = new Point2D.Double();
            List p = (List) o;
            d.x = Double.parseDouble(p.get(0).toString());
            d.y = Double.parseDouble(p.get(1).toString());
            pointList.add(d);
        }
        String[] split = pointString.split(",");
        point.x = Double.parseDouble(split[0]);
        point.y = Double.parseDouble(split[1]);
    }

    @Override
    public boolean pointIsInPolygon(String point, String pointList)
    {
        Point2D.Double p = new Point2D.Double();
        List<Point2D.Double> pts = new ArrayList<>();
        stringToPoint2DDouble(point, pointList, p, pts);
        return this.pointIsInPolygon(p, pts);
    }


    /**
     * 计算点c与线段ab的关系数据，采用向量点积的方法
     *
     * @param a 线段起点坐标数组 x,y
     * @param b 线段终点坐标数组 x,y
     * @param c 点坐标数组
     * @return double[投影比例, 最短距离, 最近交点x坐标, 最近交点y坐标]
     */
    public double[] vector(double[] a, double[] b, double[] c)
    {
        double[] AB = vectorSub(a, b); //向量AB
        double[] AC = vectorSub(a, c); //向量AC
        double r = AB[0] * AC[0] + AB[1] * AC[1]; //AB与AC的点乘
        r = r / distance(a, b, false); //AC在AB上的投影比上AB。调用Dist()
        double[] data = new double[4];
        data[0] = r;
        if (r == 0)
        {
            data[1] = 0;
            data[2] = a[0];
            data[3] = a[1];
        }
        else if (r == 1)
        {
            data[1] = 0;
            data[2] = b[0];
            data[3] = b[1];
        }
        else if (r < 0)
        {
            //点C在A点外
            data[1] = getDistance(a, c, true); //调用dist(),开方
            data[2] = a[0];
            data[3] = a[1];
        }
        else if (r > 1)
        {
            //点C在B点外
            data[1] = getDistance(b, c, true);
            data[2] = b[0];
            data[3] = b[1];
        }
        else
        {
            //若C的投影在AB之间
            double[] d = AB;
            d[0] *= r;
            d[1] *= r; //得到AC在AB上的投影向量。
            d[0] += a[0]; //点D的绝对坐标
            d[1] += a[1];
            data[1] = getDistance(d, c, true);
            data[2] = d[0];
            data[3] = d[1];
        }
        return data;
    }

    /**
     * 向量减法
     *
     * @param a 向量A
     * @param b 向量B
     * @return 向量AB
     */
    public double[] vectorSub(double[] a, double[] b)
    {
        double[] c = new double[2];
        c[0] = b[0] - a[0];
        c[1] = b[1] - a[1];
        return c;
    }

    /**
     * 向量加法
     *
     * @param a 向量A
     * @param b 向量B
     * @return 向量AB
     */
    public double[] vectorAdd(double[] a, double[] b)
    {
        double[] c = new double[2];
        c[0] = b[0] + a[0];
        c[1] = b[1] + a[1];
        return c;
    }

    /**
     * 计算两点距离，根据sqr判断是否需要开方
     *
     * @param a   A点坐标
     * @param b   B点坐标
     * @param sqr 是否开方
     * @return AB距离或距离的平方
     */
    private double distance(double[] a, double[] b, boolean sqr)
    {
        double x = a[0] - b[0];
        double y = a[1] - b[1];
        if (sqr)
        {
            return StrictMath.sqrt(x * x + y * y);
        }
        else
        {
            return x * x + y * y;
        }
    }

    /**
     * 计算两点之间的距离
     *
     * @param a A点坐标
     * @param b B点坐标
     * @return 返回距离，单位米
     */
    public double getDistance(double[] a, double[] b, boolean sqr)
    {
        double x =
                (b[0] - a[0])
                        * (c * Math.cos((((b[1] + a[1]) / 2D) * pi) / 180D));
        double y = (b[1] - a[1]) * c; //纬度差*纬度每度多少米
        if (sqr)
        {
            return Math.sqrt(x * x + y * y);
        }
        else
        {
            return x * x + y * y;
        }
    }

    /**
     * 字符串转Double类型
     *
     * @param doubleString 字符串
     * @return {@link Double} Double类型
     */
    private Double toDouble(Object doubleString)
    {
        if (doubleString == null)
        {
            return 0D;
        }
        try
        {
            return Double.parseDouble(trim(doubleString.toString())) < 0 ?
                    0 : Double.parseDouble(trim(doubleString.toString()));
        }
        catch (Exception e)
        {
            return 0D;
        }
    }

    /**
     * 格式化双精度浮点数，保留2位小数
     *
     * @param d double
     * @return {@link String} 保留2位小数的字符串类型的数字
     */
    private static String formatDouble(double d)
    {
        return String.format("%.2f", d);
    }

    @Override
    public double getOverWay(Point2D.Double point, List<Point2D.Double> pointList)
    {
        List<Double> distanceList = new ArrayList<>();
        double[] lonLat = new double[2];
        lonLat[0] = point.x;
        lonLat[1] = point.y;
        for (int i = 0; i < pointList.size() - 1; i++)
        {
            double[] piont_1 = new double[2];
            double[] piont_2 = new double[2];
            piont_1[0] = pointList.get(i).getX();
            piont_1[1] = pointList.get(i).getY();
            piont_2[0] = pointList.get(i + 1).getX();
            piont_2[1] = pointList.get(i + 1).getY();
            double[] distance = vector(piont_1, piont_2, lonLat);
            distanceList.add(distance[1]);
        }
        //取最小值
        return toDouble(formatDouble(distanceList.stream().min(Double::compareTo).get()));
    }

    @Override
    public double getOverWay(String point, String pointList)
    {
        Point2D.Double p = new Point2D.Double();
        List<Point2D.Double> pts = new ArrayList<>();
        stringToPoint2DDouble(point, pointList, p, pts);
        return getOverWay(p, pts);
    }
}
