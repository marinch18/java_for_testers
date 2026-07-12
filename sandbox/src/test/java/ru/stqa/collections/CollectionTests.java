package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {

    @Test
    void arrayTests() {
        var array = new String[]{"a", "b", "c"};
        //var array = new String[3]; // 3 пустых элемента
        Assertions.assertEquals(3, array.length);
        Assertions.assertEquals("a", array[0]);

        array[0] = "d";
        Assertions.assertEquals("d", array[0]);

    }


    @Test
    void listTests() {
        //var list = List.of("a", "b", "c"); // не модифицируемый
        var list = new ArrayList<>(List.of("a", "b", "c")); // модифицируемый

//        list.add("a"); // модифицируемый - добавление по 1 элементу
//        list.add("b");
//        list.add("c");
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("a", list.get(0));

        list.set(0, "d");
        Assertions.assertEquals("d", list.get(0));

    }
}
