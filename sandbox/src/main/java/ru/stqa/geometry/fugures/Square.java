package ru.stqa.geometry.fugures;


public record Square(double side) {

    public Square {
        if (side < 0) {
            throw new IllegalArgumentException("Квадрат с отрицательной стороной не существует");
        }
    }

    public static void printSquareArea(Square s) {
        String text = String.format("Площадь квадрата со стороной %f = %f", s.side, s.Area());
        System.out.println(text);
    }

    public static void printPerimeter(Square s) {
        String text = String.format("Периметр квадрата со стороной %f = %f", s.side, s.Perimeter());
        System.out.println(text);
    }

    public double Perimeter() {
        return 4 * this.side;
    }

    public double Area() {
        return this.side * this.side;
    }
}




