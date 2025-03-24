package com.example.anagram;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testAnagramOfWordsWithoutIgnoreSymbols() {
        String testInput = "Mykola Android Developer 17";
        String testOutput = "alokyM diordnA repoleveD 17";

        assertEquals(testOutput, ReversWords.anagramOfWords(testInput, ""));
    }

    @Test
    public void testAnagramOfWordsWithIgnoreSymbols() {
        String testInput = "Mykola Android Developer 17";
        String testIgnoreSymbols = "ka";
        String testOutput = "lokyMa diordnA repoleveD 71";

        assertEquals(testOutput, ReversWords.anagramOfWords(testInput, testIgnoreSymbols));
    }

    @Test
    public void testAnagramOfWordsWithoutIgnoreSymbolsAndWords() {
        String testInput = "";
        String testIgnoreSymbols = "";
        String testOutput = "";

        assertEquals(testOutput, ReversWords.anagramOfWords(testInput, testIgnoreSymbols));
    }
}