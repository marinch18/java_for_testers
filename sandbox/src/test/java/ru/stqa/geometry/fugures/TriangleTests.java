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

}
