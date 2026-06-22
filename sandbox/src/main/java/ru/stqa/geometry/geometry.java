package ru.stqa.geometry;

import ru.stqa.geometry.fugures.Rectangle;
import ru.stqa.geometry.fugures.Square;

public class geometry {
    public static void main(String[] args)
    {
        Square.printSquareArea(7.0);
        Square.printSquareArea(5.0);
        Square.printSquareArea(3.0);

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(7.0, 9.0);
    }


}
