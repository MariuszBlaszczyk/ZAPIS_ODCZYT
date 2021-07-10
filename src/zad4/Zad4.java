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

    static void readData(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            int palindromeCount = 0;
            int anagramCount = 0;
            int wordsWithEvenVowelCount = 0;
            String userWord = getWordFromUser();
            String[] array = new String[countLines(filename)];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextLine();
                if (isPalindrome(array[i])) {
                    palindromeCount++;
                }
                if (isAnagram(array[i]),userWord){
                    anagramCount++;
                }
                if (evenNumberOfVowels(array[i])) {
                    wordsWithEvenVowelCount++;
                }
            }
            System.out.println("Number of words that are palindromes: " + palindromeCount);
            System.out.println("Number of words that are anagrams: " + anagramCount);
            System.out.println("Number of words with even vowel : " + wordsWithEvenVowelCount);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static String getWordFromUser() {
        Scanner scan = new Scanner(System.in);
        String word = null;
        boolean error = true;
        do {
            try {
                System.out.println("Please pass the word.");
                word = scan.nextLine();
                error = false;
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        } while ((error));
        return word;
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

    static boolean isAnagram(String string1, String string2) {
        if (string1 == null || string1.isEmpty()) {
            throw new IllegalArgumentException("String1 is null or empty");
        }
        if (string2 == null || string2.isEmpty()) {
            throw new IllegalArgumentException("String2 is null or empty");
        }
        char[] a1 = string1.toCharArray();
        char[] a2 = string2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
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

    public static void main(String[] args) {

        String filename = "src/zad4/napisy.txt";
        System.out.println(readData(filename));
    }
}
