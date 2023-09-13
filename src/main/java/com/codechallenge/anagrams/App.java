package com.codechallenge.anagrams;


import com.codechallenge.anagrams.anagram.Anagram;
import com.codechallenge.anagrams.anagram.AnagramImpl;
import com.codechallenge.anagrams.service.AnagramService;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        Anagram anagram = new AnagramImpl();
        AnagramService anagramService = new AnagramService(anagram);
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("1. Check if two texts are anagrams and add to the list.");
                System.out.println("2. Find anagrams of a text in the existing list.");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter the first text: ");
                        String firstInput = scanner.nextLine();
                        System.out.print("Enter the second text: ");
                        String secondInput = scanner.nextLine();
                        anagramService.add(firstInput, secondInput);
                    }
                    case 2 -> {
                        System.out.print("Enter a text to find anagrams: ");
                        String searchText = scanner.nextLine();
                        Set<String> anagrams = anagramService.findAnagrams(searchText);
                        if (anagrams.isEmpty()) {
                            System.out.println("No anagrams found in the list." + anagrams);
                        } else {
                            System.out.println("Anagrams found in the list: " + anagrams);
                        }
                    }
                    case 3 -> {
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please choose again.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}

