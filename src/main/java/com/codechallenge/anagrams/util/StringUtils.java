package com.codechallenge.anagrams.util;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String entry) {
        return entry == null || entry.isEmpty();
    }
}
