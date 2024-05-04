package com.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 *
 */


public class TASK2 {
    public static void main(String[] args) {
        listedWeek();
    }

    public static List<String> listedWeek(){

        List<String> list = new ArrayList<>();
        list.add("Rice");
        list.add("Bread");
        list.add("Coffe");
        list.add("Sugar");
        list.add("Beans");
        list.add("Apples");
        list.add("Eggs");
        list.add("Potatoes");
        list.add("Sugar");
        list.add("Carrots");

        System.out.println("\n----- Market shopping list for the week ----- ");
        showList(list);

        int halfList = (list.size() / 2);
        if (list.size() % 2 == 0) {
            halfList--;
        }

        list.remove(halfList);

        System.out.println("\n----- List after removing the middle element -----");
        showList(list);

        return list;
    }

    private static void showList(List<String> list) {

        for (int i = 0; i < list.size(); i++) {

            //Prints the current element of the list
            System.out.print(list.get(i));

            // Print the previous element (if any)
            System.out.print(" (before: " + (i > 0 ? list.get(i - 1) : "") + ")");

            // Prints the previous element (if any)
            System.out.print(" (after: " + (i < list.size() - 1 ? list.get(i + 1) : "") + ")");

            // Skip a line
            System.out.println();
        }
    }

}