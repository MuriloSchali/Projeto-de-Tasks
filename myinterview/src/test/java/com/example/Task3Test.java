package com.example;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class Task3Test {

    @Test
    public void testCountSeparateItems() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("4");
        list.add("5");

        assertEquals(5, TASK3.countSeparateItems(list));
    }

    @Test
    public void testCountSeparateItemsEmptyList() {
        ArrayList<String> list = new ArrayList<>();
        assertEquals(0, TASK3.countSeparateItems(list));
    }

    @Test
    public void testCountSeparateItemsSingleItemList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("car");
        assertEquals(1, TASK3.countSeparateItems(list));
    }

    @Test
    public void testCountSeparateItemsNullList() {
        assertEquals(0, TASK3.countSeparateItems(null));
    }

    @Test
    public void testGenerateRandomStringAndNumbers() {
        String randomString = TASK3.generateRandomString();

        // Check string has length between one and ten
        assertTrue(randomString.length() >= 1 && randomString.length() <= 10);

        // Check if the string contains only lowercase letters
        assertTrue(randomString.matches("[a-z]+"));
    }

    @Test
    public void testGenerateAndCountSeparateItemsNotNullList() {
        ArrayList<String> list = TASK3.generateAndCountSeparateItems();
        assertNotNull(list);
    }

}