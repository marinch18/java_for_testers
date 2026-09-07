package ru.stqa.geometry;

import ru.stqa.geometry.fugures.Square;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {
    public static void main(String[] args)
    {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100.0));
        var squares = Stream.generate(randomSquare).limit(5);

        Consumer<Square> print = square -> {
            Square.printSquareArea(square);
            Square.printPerimeter(square);
        };
        squares.peek(Square::printSquareArea).forEach(Square::printPerimeter);
    }
}