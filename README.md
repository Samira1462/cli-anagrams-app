# Anagram Checker and Anagram Finder

This Java program provides two features:

1. Checks if two texts are anagrams of each other.
2. Finds all the anagrams for a given string based on the anagram check from feature #1.

## Features

### Feature #1: Anagram Checker

This feature checks if two input texts are anagrams of each other based on the definition described in the English Wikipedia page for anagrams.

### Feature #2: Anagram Finder

This feature finds all the anagrams for a given string by invoking the Anagram Checker (feature #1) with various inputs. Given hypothetical invocations of the feature #1 function `f1(A, B)`, `f1(A, C)`, `f1(A, D)`:

- `f2(A)` should return `[B, D]`
- `f2(B)` should return `[A, D]`
- `f2(C)` should return an empty list, as there are no anagrams for C.

## Usage

To run the program, follow these steps:

1. Clone the repository to your local machine:
   ```shell
   git clone https://github.com/Samira1462/cli-anagrams-app.git
   
2. Navigate to the project directory

## Requirements
Java 17

## Run and execute
1. clean and package and execute the JAR file by running
```shell
 mvn clean package
 
 java -jar target/cli-anagrams-app-1.0-SNAPSHOT.jar
