package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 *
 */
public class TASK3 {
    static Random random = new Random();

    public static void main(String[] args) {
        generateAndCountSeparateItems();
    }

    public static ArrayList<String> generateAndCountSeparateItems() {
        int sizeList = random.nextInt(100);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < sizeList; i++) {
            String item = generateRandomString();
            list.add(item);
        }

        System.out.println("----- List of items -----");
        for (String a : list) {
            System.out.println(a);
        }

        // Calculating and printing the number of distinct items
        int itensDistintos = countSeparateItems(list);
        System.out.println("\nNumber of different items in the list: " + itensDistintos);

        return list;
    }

    static String generateRandomString() {
        int size = random.nextInt(10) + 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            char c = (char) (random.nextInt(26) + 'a');  //Lowercase Randoms - ASCII
            sb.append(c);
        }
        return sb.toString();
    }

    static int countSeparateItems(ArrayList<String> list) {

        if (list == null) {
            return 0;
        }

        HashSet<String> differentItems = new HashSet<>();

        for (String item : list) {
            if (!differentItems.contains(item)) {
                differentItems.add(item);
            }
        }
        return differentItems.size();
    }
}