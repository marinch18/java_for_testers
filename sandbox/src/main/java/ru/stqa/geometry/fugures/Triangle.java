package ru.stqa.geometry.fugures;

public record Triangle(double a, double b, double c) {

    public Triangle {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Сторона треугольника не может быть отрицательной");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Нарушено неравенство треугольника");
        }
    }

    public static void printTrianglePerimeter(Triangle t) {
        var text = String.format(
                "Периметр треугольника со сторонами %f и %f и %f = %f",
                t.a, t.b, t.c, t.perimeter());
        System.out.println(text);
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public static void printTriangleArea(Triangle t) {
        var text = String.format("Площадь треугольника со сторонами %f и %f и %f = %f",
                t.a, t.b, t.c, t.area());
        System.out.println(text);
    }

    public double area() {
        double P = this.perimeter() / 2;
        return Math.sqrt(P * (P - this.a) * (P - this.b) * (P - this.c));
    }
}