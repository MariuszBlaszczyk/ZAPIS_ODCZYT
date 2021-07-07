package zad1;

/*
Plik tekstowy ‘tablica.txt’ ma postać:
8 3 2 1 4 3 2
Pobierz liczby z pliku tekstowego do tablicy i wypisz na ekranie sumę elementów tej tablicy.
 */


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Zad1 {

    static String readData(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            String newText = sc.nextLine();
            return newText;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    static int sum(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text is not correct");
        }
        String[] array = text.split("\\D");
        int sum = 0;
        int[] numbers = new int[array.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        String filename = "tablica.txt";
        int result = sum(readData(filename));
        System.out.println("Result: " + result);
    }

}










