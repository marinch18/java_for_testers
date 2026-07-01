package ru.stqa.geometry;

import ru.stqa.geometry.fugures.Rectangle;
import ru.stqa.geometry.fugures.Square;
import ru.stqa.geometry.fugures.Triangle;

public class geometry {
    public static void main(String[] args)
    {
        Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(7.0, 9.0);

        Triangle.printTrianglePerimeter(new Triangle(6.0, 3.0, 4.0));
        Triangle.printTriangleArea(new Triangle(5.0, 7.0, 4.0));
    }


}

   /* static - она должна вызываться в классе, все данные передаются через параметры,
    а если его нет значит эта функция должна вызываться в объекте и данные она должна брать из объекта,
    в котором она была вызвана*/