package zad3;

/*
Plik tekstowy ‘dane.txt’ ma postać:
3;8;4;5;3;2
3 4 5 1 2 3
9;8;3;2;3;4
9 8 9 7 8 1
Pobierz z pliku tekstowego kolejne wiersze liczb i wypisz na ekranie numer wiersza,
w którym występuje najwięcej elementów parzystych.
 */

import java.io.FileReader;
import java.util.Scanner;

public class Zad3 {

    static int countLines(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner scan = new Scanner(reader)) {
            int counter = 0;
            while (scan.hasNextLine()) {
                counter++;
                scan.nextLine();
            }
            return counter;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static int[][] readData(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner scan = new Scanner(reader)) {
            int[][] array = new int[countLines(filename)][];
            for (int i = 0; i < array.length; i++) {
                array[i] = getNumbers(scan.nextLine());
            }
            return array;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static int[] getNumbers(String line) {
        if (line == null || !line.matches("(\\d+\\D)*\\d+")) {
            throw new IllegalArgumentException("Line is not correct");
        }
        String[] numbersString = line.split("\\D");
        int[] numbers = new int[numbersString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }
        return numbers;
    }


    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {

        String filename = "src/zad3/dane.txt";
    }
}
