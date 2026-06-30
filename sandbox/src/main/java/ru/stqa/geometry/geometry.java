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

        Triangle.printTrianglePerimeter(5.0,3.0, 4.0);
        Triangle.printTriangleArea(5.0,3.0, 4.0);
    }


}
