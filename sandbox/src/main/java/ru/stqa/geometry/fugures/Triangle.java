package ru.stqa.geometry.fugures;

public class Triangle {
    public static void printTrianglePerimeter(double a, double b, double c) {

        var text = String.format("Периметр треугольника со сторонами %f и %f и %f = %f", a, b, c, TrianglePerimeter(a, b, c));
        System.out.println(text);
    }

    public static double TrianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static void printTriangleArea(double a, double b, double c) {

        var text = String.format("Площадь треугольника со сторонами %f и %f и %f = %f", a, b, c, TriangleArea(a, b, c));
        System.out.println(text);
    }

    public static double TriangleArea(double a, double b, double c) {
        double P = TrianglePerimeter(a,b,c) / 2;
        return Math.sqrt(P * (P - a) * (P - b) * (P - c));
    }
}
