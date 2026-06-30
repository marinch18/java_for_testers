package ru.stqa.geometry.fugures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void CanCalculateArea() {
        Assertions.assertEquals(6.0, Triangle.TriangleArea(5.0, 3.0, 4.0));
    }

    @Test
    void CanCalculatePerimeter() {
        Assertions.assertEquals(12.0, Triangle.TrianglePerimeter(5.0, 3.0, 4.0));
    }
}
