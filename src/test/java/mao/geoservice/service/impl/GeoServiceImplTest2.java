package mao.geoservice.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Project name(项目名称)：GeoService
 * Package(包名): mao.geoservice.service.impl
 * Class(类名): GeoServiceImplTest2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/10/27
 * Time(创建时间)： 10:09
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@SpringBootTest
public class GeoServiceImplTest2
{
    @Autowired
    private GeoServiceImpl geoServiceImpl;

    static String areaPoint;

    @BeforeAll
    static void beforeAll()
    {
        areaPoint = "[[113.436109,22.759242],[113.433706,22.756947],[113.435336,22.753465]," +
                "[113.439371,22.752594],[113.448125,22.754256],[113.460142,22.756947]," +
                "[113.468811,22.756433],[113.48014,22.749982],[113.491298,22.738187],[113.496276,22.731459]," +
                "[113.501855,22.722592],[113.506404,22.714595],[113.508464,22.709212],[113.510524,22.698602]," +
                "[113.520867,22.70652],[113.540049,22.693613],[113.535758,22.677775],[113.547388,22.666489]," +
                "[113.559963,22.655994],[113.578674,22.636904],[113.597985,22.621852],[113.613006,22.610364]," +
                "[113.631975,22.618524],[113.62734,22.63532],[113.618241,22.632428],[113.606912,22.623357]," +
                "[113.596827,22.633181],[113.609401,22.646014],[113.594038,22.662489],[113.580476,22.676745]," +
                "[113.560391,22.693059],[113.547517,22.70351],[113.54065,22.69971],[113.528291,22.708578]," +
                "[113.509752,22.723146],[113.499451,22.738187],[113.484603,22.753306],[113.474218,22.7613]," +
                "[113.46512,22.764941],[113.456022,22.761379],[113.44701,22.758688],[113.440701,22.758174]," +
                "[113.438297,22.758886],[113.437568,22.75853],[113.436882,22.75944]]";
    }

    @Test
    void pointIsInPolygonTest1()
    {
        String s = "113.594406,22.661596";
        System.out.println(geoServiceImpl.pointIsInPolygon(s, areaPoint));
    }

    @Test
    void pointIsInPolygonTest2()
    {
        String s = "113.604126,22.651992";
        System.out.println(geoServiceImpl.pointIsInPolygon(s, areaPoint));
    }

    @Test
    void pointIsInPolygonTest3()
    {
        String s = "113.590587,22.645695";
        System.out.println(geoServiceImpl.pointIsInPolygon(s, areaPoint));
    }

    @Test
    void pointIsInPolygonTest4()
    {
        String s = "113.615088,22.624923";
        System.out.println(geoServiceImpl.pointIsInPolygon(s, areaPoint));
    }

    @Test
    void pointIsInPolygonTest5()
    {
        String s = "113.596961,22.633157";
        System.out.println(geoServiceImpl.pointIsInPolygon(s, areaPoint));
    }

    @Test
    void pointIsInPolygonTest6()
    {
        String s = "113.596677,22.633133";
        System.out.println(geoServiceImpl.pointIsInPolygon(s, areaPoint));
    }

    @Test
    void pointIsInPolygonTest7()
    {
        String s = "113.591936,22.62682";
        System.out.println(geoServiceImpl.pointIsInPolygon(s, areaPoint));
    }

    @Test
    void pointIsInPolygonTest8()
    {
        String s = "113.438773,22.75298";
        System.out.println(geoServiceImpl.pointIsInPolygon(s, areaPoint));
    }

    @Test
    void pointIsInPolygonTest9()
    {
        String s = "113.430748,22.750011";
        System.out.println(geoServiceImpl.pointIsInPolygon(s, areaPoint));
    }

    /**
     * 9秒
     */
    @Test
    void pointIsInPolygonTest10()
    {
        String s = "113.430748,22.750011";
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
        {
            geoServiceImpl.pointIsInPolygon(s, areaPoint);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

    /**
     * 59秒
     *
     * @throws InterruptedException 中断异常
     */
    @Test
    void pointIsInPolygonTest11() throws InterruptedException
    {
        String s = "113.430748,22.750011";
        int thead = 64;
        CountDownLatch countDownLatch = new CountDownLatch(thead);
        long l = System.currentTimeMillis();
        for (int i = 0; i < thead; i++)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0; i < 1000000; i++)
                    {
                        geoServiceImpl.pointIsInPolygon(s, areaPoint);
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

    /**
     * 115毫秒
     */
    @Test
    void pointIsInPolygonTest12()
    {
        String s = "113.430748,22.750011";
        Point2D.Double p = new Point2D.Double();
        List<Point2D.Double> pts = new ArrayList<>();
        geoServiceImpl.stringToPoint2DDouble(s, areaPoint, p, pts);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
        {
            geoServiceImpl.pointIsInPolygon(p, pts);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

    /**
     * 523毫秒
     * @throws InterruptedException 异常
     */
    @Test
    void pointIsInPolygonTest13() throws InterruptedException
    {
        String s = "113.430748,22.750011";
        int thead = 64;
        Point2D.Double p = new Point2D.Double();
        List<Point2D.Double> pts = new ArrayList<>();
        geoServiceImpl.stringToPoint2DDouble(s, areaPoint, p, pts);
        CountDownLatch countDownLatch = new CountDownLatch(thead);
        long l = System.currentTimeMillis();
        for (int i = 0; i < thead; i++)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0; i < 1000000; i++)
                    {
                        geoServiceImpl.pointIsInPolygon(p, pts);
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
