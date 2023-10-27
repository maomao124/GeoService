package mao.geoservice.service.impl;

import com.alibaba.fastjson.JSONArray;
import mao.geoservice.service.GeoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean pointIsInPolygon(String point, String pointList)
    {
        List list = (List) JSONArray.parse(pointList);
        List<Point2D.Double> pts = new ArrayList<>();
        for (Object o : list)
        {
            Point2D.Double d = new Point2D.Double();
            List p = (List) o;
            d.x = Double.parseDouble(p.get(0).toString());
            d.y = Double.parseDouble(p.get(1).toString());
            pts.add(d);
        }
        Point2D.Double p = new Point2D.Double();
        String[] split = point.split(",");
        p.x = Double.parseDouble(split[0]);
        p.y = Double.parseDouble(split[1]);
        return this.pointIsInPolygon(p, pts);
    }

    @Override
    public double getOverWay(Point2D.Double point, List<Point2D.Double> pointList)
    {
        return 0;
    }

    @Override
    public double getOverWay(String point, String pointList)
    {
        return 0;
    }
}
