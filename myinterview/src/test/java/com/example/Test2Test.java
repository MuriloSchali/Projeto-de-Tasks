package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Test2Test {

    @Test
    public void testListedWeekNotEquals() {
        List<String> expectedList = new ArrayList<>(List.of("Rice", "Bread", "Coffe", "Sugar", "Beans", "Apples", "Eggs", "Potatoes", "Sugar", "Carrots"));
        List<String> resultList = TASK2.listedWeek();

        assertNotEquals(expectedList, resultList);
    }

    @Test
    public void testListedWeekEquals() {
        List<String> expectedList = List.of("Rice", "Bread", "Coffe", "Sugar", "Apples",
                "Eggs", "Potatoes", "Sugar", "Carrots");

        List<String> resultList = TASK2.listedWeek();

        assertEquals(expectedList, resultList);
    }

    @Test
    public void testMiddleElementRemoved() {
        List<String> resultList = TASK2.listedWeek();
        assertFalse(resultList.contains("Beans"));
    }

    @Test
    public void testListSize() {
        List<String> resultList = TASK2.listedWeek();
        assertEquals(9, resultList.size());
    }

}
