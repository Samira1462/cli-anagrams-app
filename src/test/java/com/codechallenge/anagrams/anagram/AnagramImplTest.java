package com.codechallenge.anagrams.anagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AnagramImplTest {
    private Anagram anagramUnderTest;

    @BeforeEach
    void setUp() {
        anagramUnderTest = new AnagramImpl();
    }

    @ParameterizedTest
    @CsvSource({
            "listen, silent",
            "Astronomer, Moon starer"
    })
    @DisplayName("is anagrams successful")
    void isAnagram(String firstInputTest, String secondInputTest) {
        assertTrue(anagramUnderTest.isAnagram(firstInputTest, secondInputTest));
    }

    @ParameterizedTest
    @CsvSource({
            "hello, world",
            "not, anagram"
    })
    @DisplayName("is anagrams successful")
    void isNotAnagram(String firstInputTest, String secondInputTest) {
        assertFalse(anagramUnderTest.isAnagram(firstInputTest, secondInputTest));
    }

    @ParameterizedTest
    @CsvSource({
            "listen, eilnst",
            "Samira, aaimrs"
    })
    @DisplayName("sort text successful")
    void sortText(String input, String expected) {
        assertEquals(expected, anagramUnderTest.sortText(input));
    }
}