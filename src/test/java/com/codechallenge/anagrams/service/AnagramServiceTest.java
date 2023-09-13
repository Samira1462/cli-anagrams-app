package com.codechallenge.anagrams.service;

import com.codechallenge.anagrams.anagram.Anagram;
import com.codechallenge.anagrams.anagram.AnagramImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AnagramServiceTest {

    private AnagramService anagramServiceUnderTest;
    private Anagram anagram;

    @BeforeEach
    void setUp() {
        anagram = new AnagramImpl();
        anagramServiceUnderTest = new AnagramService(anagram);
    }

    @ParameterizedTest
    @CsvSource({
            "Samira, Ramisa",
            "listen, silent",
            "astronomer, moon starer",
    })
    @DisplayName("add anagrams successfully and return value")
    void addSuccess(String firstInputTest, String secondInputTest) {
        anagramServiceUnderTest.add(firstInputTest, secondInputTest);
        assertTrue(anagramServiceUnderTest.findAnagrams(firstInputTest).contains(secondInputTest));
        assertEquals(1, anagramServiceUnderTest.findAnagrams(firstInputTest).size());
        assertTrue(anagramServiceUnderTest.findAnagrams(secondInputTest).contains(firstInputTest));
        assertEquals(1, anagramServiceUnderTest.findAnagrams(secondInputTest).size());
    }

    @ParameterizedTest
    @CsvSource({
            "Samira, isa",
            "lisien, silent",
            " , "
    })
    @DisplayName("add anagrams successful and return empty")
    void addWhenIsNotAnagram(String firstInputTest, String secondInputTest) {
        anagramServiceUnderTest.add(firstInputTest, secondInputTest);
        assertFalse(anagramServiceUnderTest.findAnagrams(firstInputTest).contains(secondInputTest));
        Set<String> anagrams = anagramServiceUnderTest.findAnagrams(firstInputTest);
        assertEquals(anagrams.size(), 0);
    }

    @ParameterizedTest
    @CsvSource({
            "Samira, Ramisa, true, false, false",
            "listen, silent, true, false, false",
            "astronomer, moon starer, true, false, true"
    })
    @DisplayName("find anagrams successfully and return set of words")
    void findAnagramsSuccess(String firstInputTest, String secondInputTest,
                             boolean containsSecondInput, boolean containsFirstInput, boolean containsThirdInput) {
        anagramServiceUnderTest.add(firstInputTest, secondInputTest);

        Set<String> anagrams = anagramServiceUnderTest.findAnagrams(firstInputTest);

        assertEquals(containsSecondInput, anagrams.contains(secondInputTest));
        assertEquals(containsFirstInput, anagrams.contains(firstInputTest));
        assertEquals(containsThirdInput, anagrams.contains("moon starer"));
    }
}