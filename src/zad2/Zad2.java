package zad2;

/*
Plik tekstowy ‘tablicaDwa.txt’ ma postać:
3 4
1 2 3 4
5 6 7 8
9 0 1 2
Pierwsza linia w pliku tekstowym to informacje o ilości odpowiednio wierszy i kolumn tablicy dwuwymiarowej.
Kolejne wiersze w pliku to kolejne wiersze tablicy dwuwymiarowej. Pobierz z pliku tekstowego dane
do tablicy dwuwymiarowej i wyznacz kolumnę o największej sumie elementów.
 */


import java.io.FileReader;
import java.util.Scanner;

public class Zad2 {

    static int[][] readData(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int[][] numbers = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    numbers[i][j] = sc.nextInt();
                }
            }
            return numbers;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException(e.getMessage());
        }
    }

    static void columnLargestElementSummary(int[][] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

    }

    public static void main(String[] args) {

        String filename = "src/zad2/tablicaDwa.txt";
    }
}
