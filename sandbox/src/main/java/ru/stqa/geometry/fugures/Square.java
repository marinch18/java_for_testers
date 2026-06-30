package ru.stqa.geometry.fugures;


public class Square {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public static void printSquareArea(Square s) {
        String text = String.format("Площадь квадрата со стороной %f = %f", s.side, s.Area());
        System.out.println(text);
    }

    public double Area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return 4 * this.side;
    }
}

//    public static double Area(double a) {
//        return a * a;
//    }

    /* static - она должна вызываться в классе, все данные передаются через параметры,
    а если его нет значит эта функция должна вызываться в объекте и данные она должна брать из объекта,
    в котором она была вызвана*/

//    public static double perimeter(double a) {
//        return 4 * a;
//    }


