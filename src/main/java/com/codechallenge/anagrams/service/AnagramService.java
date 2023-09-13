package com.codechallenge.anagrams.service;

import com.codechallenge.anagrams.anagram.Anagram;
import com.codechallenge.anagrams.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AnagramService {
    Logger logger = Logger.getLogger(AnagramService.class.getName());
    private final Set<String> anagramStore = new HashSet<>();
    private final Anagram anagram;
    public AnagramService(Anagram anagram) {
        this.anagram = anagram;
    }

    public void add(String firstInput, String secondInput) {
        if (anagram.isAnagram(firstInput, secondInput)) {
            anagramStore.add(firstInput);
            anagramStore.add(secondInput);
            logger.log(Level.INFO, "logging: {0} ","Both texts are anagrams. Added to the list.");
        } else {
            logger.log(Level.INFO, "logging: {0} ","These are not anagrams.");
        }
    }

    public Set<String> findAnagrams(String searchText) {
        String sortedSearchText = anagram.sortText(searchText);
        return anagramStore
                .stream()
                .filter(text -> !text.equalsIgnoreCase(searchText) && anagram.sortText(text).equals(sortedSearchText))
                .collect(Collectors.toSet());
    }
}
