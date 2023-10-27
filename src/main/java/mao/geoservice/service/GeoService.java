package mao.geoservice.service;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Project name(项目名称)：GeoService
 * Package(包名): mao.geoservice.service
 * Interface(接口名): GeoService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/10/27
 * Time(创建时间)： 9:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface GeoService
{
    /**
     * 判断某个坐标是否在电子围栏内
     *
     * @param point     点坐标
     * @param pointList 围栏坐标列表
     * @return boolean 是否在电子围栏内
     */
    boolean pointIsInPolygon(Point2D.Double point, List<Point2D.Double> pointList);


    /**
     * 点位于多边形中
     *
     * @param point     点坐标，字符串类型，要求格式：'113.594406,22.661596'
     * @param pointList 围栏坐标列表，字符串类型，要求格式：'[[113.436109,22.759242],[113.433706,22.756947],[113.436882,22.75944]]'
     * @return boolean  是否在电子围栏内
     */
    boolean pointIsInPolygon(String point, String pointList);


    double getOverWay(Point2D.Double point, List<Point2D.Double> pointList);

    double getOverWay(String point, String pointList);

}
