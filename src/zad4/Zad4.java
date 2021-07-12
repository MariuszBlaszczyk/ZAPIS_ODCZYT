package zad4;

/*
Plik tekstowy ‘napisy.txt’ ma postać:
napis1
napis2
napis3
napis4
…
Każdy napis jest dowolny i wpiszesz go podczas tworzenia pliku tekstowego.
Trzy kropki symbolizują, że możesz utworzyć plik o dowolnej liczbie napisów.
Pobierz dane z pliku tekstowego i zlicz, ile jest w nim słów, które są:
a) palindromami,
b) anagramami słowa podanego wcześniej przez użytkownika,
c) słowami o parzystej liczbie samogłosek
 */

import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Zad4 {

    static int countLines(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            int counter = 0;
            while (sc.hasNextLine()) {
                counter++;
                sc.nextLine();
            }
            return counter;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static String[][] readData(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner scan = new Scanner(reader)) {
            String[][] array = new String[countLines(filename)][];
            for (int i = 0; i < array.length; i++) {
                array[i] = scan.nextLine().split("\\s");
            }
            return array;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }


    static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text is null or empty");
        }
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        StringBuilder plain = new StringBuilder(clean);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(clean);
    }

    static int palindromCount(String[][] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isPalindrome(array[i][j])) {
                    counter++;
                }
            }
        }
        return counter;
    }

    static String getWordFromUser() {
        Scanner scan = new Scanner(System.in);
        String userWord = null;
        try {
            System.out.println("Give the word:");
            userWord = scan.nextLine();
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
        return userWord;
    }


    static boolean isAnagram(String string1, String string2) {
        if (string1 == null || string1.isEmpty()) {
            throw new IllegalArgumentException("String1 is null or empty");
        }
        if (string2 == null || string2.isEmpty()) {
            throw new IllegalArgumentException("String2 is null or empty");
        }
        char[] chars1 = string1.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (Character.isUpperCase(chars1[i])) {
                chars1[i] = Character.toLowerCase(chars1[i]);
            }
        }
        char[] chars2 = string2.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            if (Character.isUpperCase(chars2[i])) {
                chars2[i] = Character.toLowerCase(chars2[i]);
            }
        }
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    static int anagramCount(String[][] array, String userText) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isAnagram(array[i][j], userText))
                    counter++;
            }
        }
        return counter;
    }

    static boolean evenNumberOfVowels(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text is null or empty");
        }
        int vovelCount = 0;
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vovelCount++;
            }
        }
        if (vovelCount % 2 == 0) {
            return true;
        }
        return false;
    }

    static int wordsWithAnEvenNumberOfVowelsCount(String[][] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (evenNumberOfVowels(array[i][j])) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        String filename = "src/zad4/napisy.txt";
        String[][] arrays = readData(filename);
        System.out.println(Arrays.deepToString(arrays));
        String userWord = getWordFromUser();
        System.out.println("Palindrom counter: " + palindromCount(arrays));
        System.out.println("Anagram counter: " + anagramCount(arrays, userWord));
        System.out.println("words with an even number of vowels: " + wordsWithAnEvenNumberOfVowelsCount(arrays));


    }
}
