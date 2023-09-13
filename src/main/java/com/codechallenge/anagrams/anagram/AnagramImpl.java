package com.codechallenge.anagrams.anagram;

import com.codechallenge.anagrams.util.StringUtils;

import java.util.Arrays;

public class AnagramImpl implements Anagram {
    @Override
    public boolean isAnagram(String firstInput, String secondInput) {
        if(StringUtils.isBlank(firstInput) || StringUtils.isBlank(secondInput)) {
            return false;
        }

        String firstSortedInput = sortText(firstInput);
        String secondSortedInput = sortText(secondInput);

        return firstSortedInput.equals(secondSortedInput);
    }

    @Override
    public String sortText(String text) {
        if(StringUtils.isBlank(text)) {
            return "";
        }
        char[] charArray = text.replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
