package mao.geoservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GeoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class GeoServiceImplTest
{
    @Autowired
    private GeoServiceImpl geoServiceImpl;

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPointIsInPolygon()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        //       at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        //       at java.util.ArrayList.get(ArrayList.java:435)
        //       at mao.geoservice.service.impl.GeoServiceImpl.pointIsInPolygon(GeoServiceImpl.java:55)
        //   In order to prevent pointIsInPolygon(Double, List)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pointIsInPolygon(Double, List).
        //   See https://diff.blue/R013 to resolve this issue.

        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        this.geoServiceImpl.pointIsInPolygon(point, new ArrayList<>());
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon2()
    {
        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(2.0E-10d, 2.0E-10d));
        assertFalse(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon3()
    {
        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 2.0E-10d));
        assertFalse(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon4()
    {
        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(Double.NaN, 2.0E-10d));
        assertFalse(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon5()
    {
        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 2.0E-10d));
        resultDoubleList.add(new Point2D.Double(2.0E-10d, 2.0E-10d));
        assertFalse(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon6()
    {
        Point2D.Double point = new Point2D.Double(-0.5d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(2.0E-10d, 2.0E-10d));
        assertFalse(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPointIsInPolygon7()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.geoservice.service.impl.GeoServiceImpl.pointIsInPolygon(GeoServiceImpl.java:58)
        //   In order to prevent pointIsInPolygon(Double, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pointIsInPolygon(Double, List).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(2.0E-10d, 2.0E-10d));
        this.geoServiceImpl.pointIsInPolygon((Point2D.Double) null, resultDoubleList);
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPointIsInPolygon8()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.geoservice.service.impl.GeoServiceImpl.pointIsInPolygon(GeoServiceImpl.java:64)
        //   In order to prevent pointIsInPolygon(Double, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pointIsInPolygon(Double, List).
        //   See https://diff.blue/R013 to resolve this issue.

        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(null);
        this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList);
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon9()
    {
        Point2D.Double point = new Point2D.Double(10.0d, 2.0E-10d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 2.0E-10d));
        assertTrue(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon10()
    {
        Point2D.Double point = new Point2D.Double(10.0d, -0.5d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 2.0E-10d));
        assertTrue(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon11()
    {
        Point2D.Double point = new Point2D.Double(0.5d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 2.0E-10d));
        resultDoubleList.add(new Point2D.Double(2.0E-10d, 2.0E-10d));
        assertFalse(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon12()
    {
        Point2D.Double point = new Point2D.Double(10.0d, -0.5d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 2.0E-10d));
        resultDoubleList.add(new Point2D.Double(2.0E-10d, 2.0E-10d));
        assertFalse(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPointIsInPolygon13()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.geoservice.service.impl.GeoServiceImpl.pointIsInPolygon(GeoServiceImpl.java:64)
        //   In order to prevent pointIsInPolygon(Double, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pointIsInPolygon(Double, List).
        //   See https://diff.blue/R013 to resolve this issue.

        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 2.0E-10d));
        resultDoubleList.add(null);
        this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList);
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon14()
    {
        Point2D.Double point = new Point2D.Double(10.0d, 2.0E-10d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(Double.NaN, 2.0E-10d));
        resultDoubleList.add(new Point2D.Double(10.0d, 2.0E-10d));
        assertTrue(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon15()
    {
        Point2D.Double point = new Point2D.Double(0.5d, 2.0E-10d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 2.0E-10d));
        resultDoubleList.add(new Point2D.Double(2.0E-10d, 2.0E-10d));
        assertTrue(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(Point2D.Double, java.util.List)}
     */
    @Test
    void testPointIsInPolygon16()
    {
        Point2D.Double point = new Point2D.Double(0.5d, -0.5d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 2.0E-10d));
        resultDoubleList.add(new Point2D.Double(2.0E-10d, 2.0E-10d));
        assertFalse(this.geoServiceImpl.pointIsInPolygon(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPointIsInPolygon17()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: syntax error, pos 1, line 1, column 2Point List
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1510)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1390)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:181)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:191)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:147)
        //       at mao.geoservice.service.impl.GeoServiceImpl.stringToPoint2DDouble(GeoServiceImpl.java:146)
        //       at mao.geoservice.service.impl.GeoServiceImpl.pointIsInPolygon(GeoServiceImpl.java:165)
        //   In order to prevent pointIsInPolygon(String, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pointIsInPolygon(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.pointIsInPolygon("Point", "Point List");
    }

    /**
     * Method under test: {@link GeoServiceImpl#pointIsInPolygon(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPointIsInPolygon18()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.geoservice.service.impl.GeoServiceImpl.stringToPoint2DDouble(GeoServiceImpl.java:147)
        //       at mao.geoservice.service.impl.GeoServiceImpl.pointIsInPolygon(GeoServiceImpl.java:165)
        //   In order to prevent pointIsInPolygon(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pointIsInPolygon(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.pointIsInPolygon("Point", "");
    }

    /**
     * Method under test: {@link GeoServiceImpl#vector(double[], double[], double[])}
     */
    @Test
    void testVector()
    {
        double[] actualVectorResult = this.geoServiceImpl.vector(new double[]{10.0d, 10.0d, 10.0d, 10.0d},
                new double[]{10.0d, 10.0d, 10.0d, 10.0d}, new double[]{10.0d, 10.0d, 10.0d, 10.0d});
        assertEquals(4, actualVectorResult.length);
        assertEquals(Double.NaN, actualVectorResult[0]);
        assertEquals(Double.NaN, actualVectorResult[1]);
        assertEquals(Double.NaN, actualVectorResult[2]);
        assertEquals(Double.NaN, actualVectorResult[3]);
    }

    /**
     * Method under test: {@link GeoServiceImpl#vector(double[], double[], double[])}
     */
    @Test
    void testVector2()
    {
        double[] actualVectorResult = this.geoServiceImpl.vector(new double[]{1.0d, 10.0d, 10.0d, 10.0d},
                new double[]{10.0d, 10.0d, 10.0d, 10.0d}, new double[]{10.0d, 10.0d, 10.0d, 10.0d});
        assertEquals(4, actualVectorResult.length);
        assertEquals(1.0d, actualVectorResult[0]);
        assertEquals(0.0d, actualVectorResult[1]);
        assertEquals(10.0d, actualVectorResult[2]);
        assertEquals(10.0d, actualVectorResult[3]);
    }

    /**
     * Method under test: {@link GeoServiceImpl#vector(double[], double[], double[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVector3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 0
        //       at mao.geoservice.service.impl.GeoServiceImpl.vectorSub(GeoServiceImpl.java:237)
        //       at mao.geoservice.service.impl.GeoServiceImpl.vector(GeoServiceImpl.java:180)
        //   In order to prevent vector(double[], double[], double[])
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   vector(double[], double[], double[]).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.vector(new double[]{}, new double[]{10.0d, 10.0d, 10.0d, 10.0d},
                new double[]{10.0d, 10.0d, 10.0d, 10.0d});
    }

    /**
     * Method under test: {@link GeoServiceImpl#vector(double[], double[], double[])}
     */
    @Test
    void testVector4()
    {
        double[] actualVectorResult = this.geoServiceImpl.vector(new double[]{10.0d, 10.0d, 10.0d, 10.0d},
                new double[]{1.0d, 10.0d, 10.0d, 10.0d}, new double[]{10.0d, 10.0d, 10.0d, 10.0d});
        assertEquals(4, actualVectorResult.length);
        assertEquals(0.0d, actualVectorResult[0]);
        assertEquals(0.0d, actualVectorResult[1]);
        assertEquals(10.0d, actualVectorResult[2]);
        assertEquals(10.0d, actualVectorResult[3]);
    }

    /**
     * Method under test: {@link GeoServiceImpl#vector(double[], double[], double[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVector5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 0
        //       at mao.geoservice.service.impl.GeoServiceImpl.vectorSub(GeoServiceImpl.java:237)
        //       at mao.geoservice.service.impl.GeoServiceImpl.vector(GeoServiceImpl.java:180)
        //   In order to prevent vector(double[], double[], double[])
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   vector(double[], double[], double[]).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.vector(new double[]{10.0d, 10.0d, 10.0d, 10.0d}, new double[]{},
                new double[]{10.0d, 10.0d, 10.0d, 10.0d});
    }

    /**
     * Method under test: {@link GeoServiceImpl#vector(double[], double[], double[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVector6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 0
        //       at mao.geoservice.service.impl.GeoServiceImpl.vectorSub(GeoServiceImpl.java:237)
        //       at mao.geoservice.service.impl.GeoServiceImpl.vector(GeoServiceImpl.java:181)
        //   In order to prevent vector(double[], double[], double[])
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   vector(double[], double[], double[]).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.vector(new double[]{10.0d, 10.0d, 10.0d, 10.0d}, new double[]{10.0d, 10.0d, 10.0d, 10.0d},
                new double[]{});
    }

    /**
     * Method under test: {@link GeoServiceImpl#vector(double[], double[], double[])}
     */
    @Test
    void testVector7()
    {
        double[] actualVectorResult = this.geoServiceImpl.vector(new double[]{1.0d, 10.0d, 10.0d, 10.0d},
                new double[]{0.0d, 10.0d, 10.0d, 10.0d}, new double[]{10.0d, 10.0d, 10.0d, 10.0d});
        assertEquals(4, actualVectorResult.length);
        assertEquals(-9.0d, actualVectorResult[0]);
        assertEquals(985550.6326966666d, actualVectorResult[1]);
        assertEquals(1.0d, actualVectorResult[2]);
        assertEquals(10.0d, actualVectorResult[3]);
    }

    /**
     * Method under test: {@link GeoServiceImpl#vector(double[], double[], double[])}
     */
    @Test
    void testVector8()
    {
        double[] actualVectorResult = this.geoServiceImpl.vector(new double[]{1.0d, 10.0d, 10.0d, 10.0d},
                new double[]{2.0d, 10.0d, 10.0d, 10.0d}, new double[]{10.0d, 10.0d, 10.0d, 10.0d});
        assertEquals(4, actualVectorResult.length);
        assertEquals(9.0d, actualVectorResult[0]);
        assertEquals(876045.0068414814d, actualVectorResult[1]);
        assertEquals(2.0d, actualVectorResult[2]);
        assertEquals(10.0d, actualVectorResult[3]);
    }

    /**
     * Method under test: {@link GeoServiceImpl#vectorSub(double[], double[])}
     */
    @Test
    void testVectorSub()
    {
        double[] actualVectorSubResult = this.geoServiceImpl.vectorSub(new double[]{10.0d, 10.0d, 10.0d, 10.0d},
                new double[]{10.0d, 10.0d, 10.0d, 10.0d});
        assertEquals(2, actualVectorSubResult.length);
        assertEquals(0.0d, actualVectorSubResult[0]);
        assertEquals(0.0d, actualVectorSubResult[1]);
    }

    /**
     * Method under test: {@link GeoServiceImpl#vectorSub(double[], double[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVectorSub2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 0
        //       at mao.geoservice.service.impl.GeoServiceImpl.vectorSub(GeoServiceImpl.java:237)
        //   In order to prevent vectorSub(double[], double[])
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   vectorSub(double[], double[]).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.vectorSub(new double[]{}, new double[]{10.0d, 10.0d, 10.0d, 10.0d});
    }

    /**
     * Method under test: {@link GeoServiceImpl#vectorSub(double[], double[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVectorSub3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 0
        //       at mao.geoservice.service.impl.GeoServiceImpl.vectorSub(GeoServiceImpl.java:237)
        //   In order to prevent vectorSub(double[], double[])
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   vectorSub(double[], double[]).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.vectorSub(new double[]{10.0d, 10.0d, 10.0d, 10.0d}, new double[]{});
    }

    /**
     * Method under test: {@link GeoServiceImpl#vectorAdd(double[], double[])}
     */
    @Test
    void testVectorAdd()
    {
        double[] actualVectorAddResult = this.geoServiceImpl.vectorAdd(new double[]{10.0d, 10.0d, 10.0d, 10.0d},
                new double[]{10.0d, 10.0d, 10.0d, 10.0d});
        assertEquals(2, actualVectorAddResult.length);
        assertEquals(20.0d, actualVectorAddResult[0]);
        assertEquals(20.0d, actualVectorAddResult[1]);
    }

    /**
     * Method under test: {@link GeoServiceImpl#vectorAdd(double[], double[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVectorAdd2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 0
        //       at mao.geoservice.service.impl.GeoServiceImpl.vectorAdd(GeoServiceImpl.java:252)
        //   In order to prevent vectorAdd(double[], double[])
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   vectorAdd(double[], double[]).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.vectorAdd(new double[]{}, new double[]{10.0d, 10.0d, 10.0d, 10.0d});
    }

    /**
     * Method under test: {@link GeoServiceImpl#vectorAdd(double[], double[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVectorAdd3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 0
        //       at mao.geoservice.service.impl.GeoServiceImpl.vectorAdd(GeoServiceImpl.java:252)
        //   In order to prevent vectorAdd(double[], double[])
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   vectorAdd(double[], double[]).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.vectorAdd(new double[]{10.0d, 10.0d, 10.0d, 10.0d}, new double[]{});
    }

    /**
     * Method under test: {@link GeoServiceImpl#getDistance(double[], double[], boolean)}
     */
    @Test
    void testGetDistance()
    {
        assertEquals(0.0d, this.geoServiceImpl.getDistance(new double[]{10.0d, 10.0d, 10.0d, 10.0d},
                new double[]{10.0d, 10.0d, 10.0d, 10.0d}, true));
        assertEquals(0.0d, this.geoServiceImpl.getDistance(new double[]{10.0d, 10.0d, 10.0d, 10.0d},
                new double[]{10.0d, 10.0d, 10.0d, 10.0d}, false));
    }

    /**
     * Method under test: {@link GeoServiceImpl#getDistance(double[], double[], boolean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDistance2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 0
        //       at mao.geoservice.service.impl.GeoServiceImpl.getDistance(GeoServiceImpl.java:288)
        //   In order to prevent getDistance(double[], double[], boolean)
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getDistance(double[], double[], boolean).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.getDistance(new double[]{}, new double[]{10.0d, 10.0d, 10.0d, 10.0d}, true);
    }

    /**
     * Method under test: {@link GeoServiceImpl#getDistance(double[], double[], boolean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDistance3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 0
        //       at mao.geoservice.service.impl.GeoServiceImpl.getDistance(GeoServiceImpl.java:288)
        //   In order to prevent getDistance(double[], double[], boolean)
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getDistance(double[], double[], boolean).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.getDistance(new double[]{10.0d, 10.0d, 10.0d, 10.0d}, new double[]{}, true);
    }

    /**
     * Method under test: {@link GeoServiceImpl#getOverWay(Point2D.Double, java.util.List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOverWay()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:135)
        //       at mao.geoservice.service.impl.GeoServiceImpl.getOverWay(GeoServiceImpl.java:355)
        //   In order to prevent getOverWay(Double, List)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOverWay(Double, List).
        //   See https://diff.blue/R013 to resolve this issue.

        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        this.geoServiceImpl.getOverWay(point, new ArrayList<>());
    }

    /**
     * Method under test: {@link GeoServiceImpl#getOverWay(Point2D.Double, java.util.List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOverWay2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.geoservice.service.impl.GeoServiceImpl.getOverWay(GeoServiceImpl.java:341)
        //   In order to prevent getOverWay(Double, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOverWay(Double, List).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.getOverWay((Point2D.Double) null, new ArrayList<>());
    }

    /**
     * Method under test: {@link GeoServiceImpl#getOverWay(Point2D.Double, java.util.List)}
     */
    @Test
    void testGetOverWay3()
    {
        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 10.0d));
        resultDoubleList.add(new Point2D.Double(10.0d, 10.0d));
        assertEquals(Double.NaN, this.geoServiceImpl.getOverWay(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#getOverWay(Point2D.Double, java.util.List)}
     */
    @Test
    void testGetOverWay4()
    {
        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(1.0d, 10.0d));
        resultDoubleList.add(new Point2D.Double(10.0d, 10.0d));
        assertEquals(0.0d, this.geoServiceImpl.getOverWay(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#getOverWay(Point2D.Double, java.util.List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOverWay5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.geoservice.service.impl.GeoServiceImpl.getOverWay(GeoServiceImpl.java:347)
        //   In order to prevent getOverWay(Double, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOverWay(Double, List).
        //   See https://diff.blue/R013 to resolve this issue.

        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(null);
        resultDoubleList.add(new Point2D.Double(10.0d, 10.0d));
        this.geoServiceImpl.getOverWay(point, resultDoubleList);
    }

    /**
     * Method under test: {@link GeoServiceImpl#getOverWay(Point2D.Double, java.util.List)}
     */
    @Test
    void testGetOverWay6()
    {
        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 10.0d));
        resultDoubleList.add(new Point2D.Double(1.0d, 10.0d));
        assertEquals(0.0d, this.geoServiceImpl.getOverWay(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#getOverWay(Point2D.Double, java.util.List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOverWay7()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.geoservice.service.impl.GeoServiceImpl.getOverWay(GeoServiceImpl.java:349)
        //   In order to prevent getOverWay(Double, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOverWay(Double, List).
        //   See https://diff.blue/R013 to resolve this issue.

        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(10.0d, 10.0d));
        resultDoubleList.add(null);
        this.geoServiceImpl.getOverWay(point, resultDoubleList);
    }

    /**
     * Method under test: {@link GeoServiceImpl#getOverWay(Point2D.Double, java.util.List)}
     */
    @Test
    void testGetOverWay8()
    {
        Point2D.Double point = new Point2D.Double(0.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(1.0d, 10.0d));
        resultDoubleList.add(new Point2D.Double(10.0d, 10.0d));
        assertEquals(109505.63d, this.geoServiceImpl.getOverWay(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#getOverWay(Point2D.Double, java.util.List)}
     */
    @Test
    void testGetOverWay9()
    {
        Point2D.Double point = new Point2D.Double(10.0d, 10.0d);

        ArrayList<Point2D.Double> resultDoubleList = new ArrayList<>();
        resultDoubleList.add(new Point2D.Double(0.5d, 1.0d));
        resultDoubleList.add(new Point2D.Double(1.0d, 10.0d));
        resultDoubleList.add(new Point2D.Double(10.0d, 10.0d));
        assertEquals(0.0d, this.geoServiceImpl.getOverWay(point, resultDoubleList));
    }

    /**
     * Method under test: {@link GeoServiceImpl#getOverWay(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOverWay10()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: syntax error, pos 1, line 1, column 2Point List
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1510)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1390)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:181)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:191)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:147)
        //       at mao.geoservice.service.impl.GeoServiceImpl.stringToPoint2DDouble(GeoServiceImpl.java:146)
        //       at mao.geoservice.service.impl.GeoServiceImpl.getOverWay(GeoServiceImpl.java:363)
        //   In order to prevent getOverWay(String, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOverWay(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.getOverWay("Point", "Point List");
    }

    /**
     * Method under test: {@link GeoServiceImpl#getOverWay(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOverWay11()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.geoservice.service.impl.GeoServiceImpl.stringToPoint2DDouble(GeoServiceImpl.java:147)
        //       at mao.geoservice.service.impl.GeoServiceImpl.getOverWay(GeoServiceImpl.java:363)
        //   In order to prevent getOverWay(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOverWay(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        this.geoServiceImpl.getOverWay("Point", "");
    }
}

