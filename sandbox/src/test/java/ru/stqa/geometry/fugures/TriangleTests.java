package ru.stqa.geometry.fugures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void CanCalculateArea() {
        Assertions.assertEquals(6.0, new Triangle(5.0, 3.0, 4.0).area());
    }

    @Test
    void CanCalculatePerimeter() {
        Assertions.assertEquals(12.0, new Triangle(5.0, 3.0, 4.0).perimeter());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 3.0, 4.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }

    @Test
    void cannotCreateTriangleWithWrongSides() {
        try {
            new Triangle(15.0, 3.0, 4.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }

    @Test
    void testEqualityTriangle1() {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(5.0, 4.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEqualityTriangle2() {
        var t1 = new Triangle(3.0, 5.0, 4.0);
        var t2 = new Triangle(5.0, 4.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEqualityTriangle3() {
        var t1 = new Triangle(3.0, 5.0, 4.0);
        var t2 = new Triangle(4.0, 5.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality2(){
        var a = 2;
        var b = 3;
        var c = 4;
        var triangle = new Triangle(a, b, c);
        var triangle1 = new Triangle(a, c, b);
        Assertions.assertEquals(triangle, triangle1);
    }

}
