package zad1;

/*
Plik tekstowy ‘tablica.txt’ ma postać:
8 3 2 1 4 3 2
Pobierz liczby z pliku tekstowego do tablicy i wypisz na ekranie sumę elementów tej tablicy.
 */


import java.io.FileReader;
import java.util.Scanner;

public class Zad1 {

    static int countLines(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            int counter = 0;
            while (sc.hasNextLine()) {
                ++counter;
                sc.nextLine();
            }
            return counter;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static int[] getNumbers(String line) {
        if (line == null || !line.matches("(\\d+\\D)*\\d+")) {
            throw new IllegalArgumentException("Line is not correct");
        }
        String[] numbersStr = line.split("\\D");
        int[] numbers = new int[numbersStr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }
        return numbers;
    }

    static int[][] readData3(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            int[][] numbers = new int[countLines(filename)][];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = getNumbers(sc.nextLine());
            }
            return numbers;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static int sum(int... numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array is null");
        }
        int sum = 0;
        for (int value : numbers) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {

        String filename3 = "tablica.txt";
        int[][] numbers = readData3(filename3);
        int result = sum(numbers);
    }


}









