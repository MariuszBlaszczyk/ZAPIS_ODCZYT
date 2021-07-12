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
import java.util.Arrays;
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

    static int columnLargestElementSummaryReturnIndex(int[][] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        int maxSum = Integer.MIN_VALUE;
        int index = 0;
        for (int j = 0; j < numbers[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i][j];
            }
            if (sum > maxSum) {
                maxSum = sum;
                index = j;
            }
        }
        return index;
    }

    static int[] columnLargestElementSummaryReturnColumn(int[][] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        int maxSum = Integer.MIN_VALUE;
        int[] tempArr = new int[numbers.length];
        int[] arr = new int[numbers.length];
        for (int j = 0; j < numbers[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i][j];
                tempArr[i] = numbers[i][j];
            }
            if (sum > maxSum) {
                maxSum = sum;
                arr = Arrays.copyOf(tempArr,tempArr.length);
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        String filename = "src/zad2/tablicaDwa.txt";
        int[][] array = readData(filename);
        System.out.println(Arrays.deepToString(array));
        int idx = columnLargestElementSummaryReturnIndex(array);
        System.out.println("Index: = " + idx);

        int[] col = columnLargestElementSummaryReturnColumn(array);
        System.out.println(Arrays.toString(col));


    }
}
