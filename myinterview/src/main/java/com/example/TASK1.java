package com.example;

import java.util.Scanner;

/**
 * 
 *
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * 
 * 
 * 
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        checkPalindrome();
    }

    public static void checkPalindrome() {

        try {

            System.out.println("\nEnter a word, phrase, number or other sequence of characters that is read backwards " +
                    "and forwards in the same way.");

            System.out.print("A minimum of two letters, two numbers or a sequence of characters is accepted. \n" +
                    "\nEntries such as: ..¨()-, @%# ,!!! or $#$ will not be accepted. \nAccepted entries: A man, a plan," +
                    "a canal, Panama! ,arara, 121 or racecar.\nYour entry: ");

            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("\nEnter at least two letters, numbers, or phrases. Please!");
                return;
            }

            System.out.println("\n ----- Result ----- ");

            if (validPalindrome(input)) {
                System.out.println("The string is a palindrome.\n");
            } else {
                System.out.println("The entry is not a palindrome.\nRemember that palindromes can be read from the " +
                        "left or the right, or vice versa. Example: Racecar or 121.\n");
            }
        } finally {
            scanner.close();
        }
    }

    public static boolean isValidString(String s) {
        return s != null && !s.isEmpty() && s.trim().length() > 1;
    }

    public static boolean validPalindrome(String s) {

        //validate user input
        if (!isValidString(s)) {
            return false;
        }

        //formatted user input
        String formatted = s.replaceAll("[\\s\\p{Punct}\"'¨]+", "").toLowerCase();

        StringBuilder builder = new StringBuilder(formatted);

        //invert user input
        String reversed = builder.reverse().toString();

        if (reversed.isEmpty()) {
            return false;
        } else {
            return formatted.equals(reversed);
        }
    }
}
