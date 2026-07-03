package ru.stqa.geometry.fugures;

import java.util.Objects;

public record Rectangle
        (
                double a,
                double b
        ) {

    public Rectangle {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Прямоугольник не может иметь 1 отрицательную сторону");
        }
    }

    public static void printRectangleArea(double a, double b) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", a, b, rectangleArea(a, b));
        System.out.println(text);
    }

    private static double rectangleArea(double a, double b) {
        return a * b;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return (Double.compare(rectangle.a, this.a) == 0 && Double.compare(rectangle.b, this.b) == 0)
                || Double.compare(rectangle.a, this.b) == 0 && Double.compare(rectangle.b, this.a) == 0;
    }

    @Override
    public int hashCode() {
        return 1; // Objects.hash(a, b) - с оптимизацией
    }
}
