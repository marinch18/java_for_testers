package ru.stqa.geometry.fugures;

public class Square {
    public static void printSquareArea(double side) {
        System.out.println(String.format("Площадь квадрата со стороной %f = %f", side, squeareArea(side)));
    }

    private static double squeareArea(double a) {
        return a * a;
    }
}
