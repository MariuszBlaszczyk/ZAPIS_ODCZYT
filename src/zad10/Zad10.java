package zad10;

/*
Wygeneruj 100 liczb losowych z przedziału <20, 45> i zapisz je do pliku tekstowego ‘liczby.txt’
w postaci liczba1;liczba2;liczba3;… .
Następnie pobierz zawartość pliku ‘liczby.txt’ i oblicz odchylenie standardowe pobranych liczb.
 */


import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Zad10 {

    static final int ARRAY_SIZE = 100;
    static final int MIN = 20;
    static final int MAX = 45;

    static int generateNumbers(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min is bigger than max!");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename); PrintWriter printWriter = new PrintWriter(writer)) {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                printWriter.print(generateNumbers(MIN, MAX) + ";");
                if (i < ARRAY_SIZE - 1) {
                    printWriter.println();
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static String readData(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            return sc.nextLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    static double average(int... numbers) {
        double sum = 0;
        for (int value : numbers) {
            sum += value;
        }
        return sum / numbers.length;
    }

    static double standardDeviation(int... numbers) {
        double avg = average(numbers);
        double sum = 0;
        for (double value : numbers) {
            sum += Math.pow(value - avg, 2);
        }
        return Math.sqrt(sum / numbers.length);
    }

    static double result(String line) {
        if (line == null) /*|| !line.matches("(\\d+\\D)*\\d+"))*/ {
            throw new IllegalArgumentException("Line is not correct");
        }
        double standardDeviation = 0;
        String[] array = line.split(";");
        int[] numbers = new int[array.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }
        return standardDeviation(numbers);
    }

    public static void main(String[] args) {

        saveToFile("src/zad10/liczby.txt");
        String filename = "src/zad10/liczby.txt";

        double result = result((readData(filename)));
        System.out.println("Standard deviation is: " + result);


    }
}
