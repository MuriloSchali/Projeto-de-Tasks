package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class Task1Test {

    @Test
    public void testPalindrome() {
        assertTrue(TASK1.validPalindrome("madam"));
        assertTrue(TASK1.validPalindrome("arara"));
        assertTrue(TASK1.validPalindrome("omissíssimo"));
        assertTrue(TASK1.validPalindrome("racecar"));
        assertTrue(TASK1.validPalindrome("A man, a plan, a canal, Panama!"));
        assertTrue(TASK1.validPalindrome("Roma me tem amor"));
        assertTrue(TASK1.validPalindrome("Missa é assim"));
        assertTrue(TASK1.validPalindrome("A mala nada na lama"));
        assertTrue(TASK1.validPalindrome("e y e"));
        assertTrue(TASK1.validPalindrome("omissíssimo"));
        assertTrue(TASK1.validPalindrome("Borrow or rob?"));
    }

    @Test
    public void testNonPalindrome() {
        assertFalse(TASK1.validPalindrome("hello"));
        assertFalse(TASK1.validPalindrome("openai"));
        assertFalse(TASK1.validPalindrome("O tempo está bom hoje."));
        assertFalse(TASK1.validPalindrome("A comida estava deliciosa."));
        assertFalse(TASK1.validPalindrome("The weather is nice today"));
        assertFalse(TASK1.validPalindrome("The food was delicious."));
        assertFalse(TASK1.validPalindrome("123456"));
        assertFalse(TASK1.validPalindrome("789012"));
        assertFalse(TASK1.validPalindrome("Computador"));
        assertFalse(TASK1.validPalindrome("Vitrola"));
        assertFalse(TASK1.validPalindrome("Alpendre"));
        assertFalse(TASK1.validPalindrome("I am fine"));
        assertFalse(TASK1.validPalindrome("A viagem foi cansativa"));
    }

    @Test
    public void testPalindromeWithEmptyString() {
        assertFalse(TASK1.validPalindrome(""));
        assertFalse(TASK1.validPalindrome(" "));
        assertFalse(TASK1.validPalindrome("  "));
        assertFalse(TASK1.validPalindrome("    "));
        assertFalse(TASK1.validPalindrome("      "));
    }

    @Test
    public void testPalindromeWithNullandEmpty() {
        assertFalse(TASK1.validPalindrome(null));
        assertFalse(TASK1.validPalindrome(""));
    }


    @Test
    public void testPalindromeWithPunctuation() {
        assertTrue(TASK1.validPalindrome("Mr. Owl ate my metal worm"));
        assertTrue(TASK1.validPalindrome("Was it a car or a cat I saw?"));
        assertTrue(TASK1.validPalindrome("A grama é amarga."));
        assertTrue(TASK1.validPalindrome("Madam, in Eden I'm Adam."));
        assertTrue(TASK1.validPalindrome("A grama é amarga."));
        assertTrue(TASK1.validPalindrome("Ma has a ham."));
        assertTrue(TASK1.validPalindrome("Ma is a madam, as I am."));
        assertTrue(TASK1.validPalindrome("Retracting, I sign it, Carter."));
        assertTrue(TASK1.validPalindrome("Rise to vote sir."));
    }

    @Test
    public void testPalindromeWithMixedCase() {
        assertTrue(TASK1.validPalindrome("Madam"));
        assertTrue(TASK1.validPalindrome("RaCecAr"));
        assertTrue(TASK1.validPalindrome("MaDam"));
        assertTrue(TASK1.validPalindrome("rAceCAR"));
        assertTrue(TASK1.validPalindrome("ArArA"));
    }

    @Test
    public void testPalindromeWithNumbers() {
        assertTrue(TASK1.validPalindrome("12321"));
        assertTrue(TASK1.validPalindrome("1234567890987654321"));
        assertTrue(TASK1.validPalindrome("45654"));
        assertTrue(TASK1.validPalindrome("1000000001"));
        assertTrue(TASK1.validPalindrome("123454321"));
        assertTrue(TASK1.validPalindrome("123454321"));
        assertTrue(TASK1.validPalindrome("1234567890987654321"));
        assertTrue(TASK1.validPalindrome("867868768"));
        assertTrue(TASK1.validPalindrome("1234554321"));
        assertTrue(TASK1.validPalindrome("1010101"));
        assertTrue(TASK1.validPalindrome("9449"));
    }

    @Test
    public void testInputWithSpecialCharacters() {
        assertFalse(TASK1.validPalindrome("!@#$%^&*()_+"));
        assertFalse(TASK1.validPalindrome("!!$!!"));
        assertFalse(TASK1.validPalindrome("!!!"));
        assertFalse(TASK1.validPalindrome("..¨()-"));
        assertFalse(TASK1.validPalindrome("@%#"));
        assertFalse(TASK1.validPalindrome("$$#"));
        assertFalse(TASK1.validPalindrome("!@#$%^&*()"));
        assertFalse(TASK1.validPalindrome("¨"));
        assertFalse(TASK1.validPalindrome("!@#!@#"));
    }

    @Test
    public void testPalindromeWithLongString() {
        assertTrue(TASK1.validPalindrome("a".repeat(100000)));
        assertTrue(TASK1.validPalindrome("a".repeat(100000) + "b" + "a".repeat(100000)));
    }
}
