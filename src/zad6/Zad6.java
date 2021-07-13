package zad6;

/*
Plik tekstowy o nazwie ‘osoby.txt’ ma postać:
Imie1,Nazwisko1,Pensja1
Imie2,Nazwisko2,Pensja2
…
Imię, nazwisko oraz pensję podajesz dowolnie podczas tworzenia pliku tekstowego.
Trzy kropki symbolizują, że możesz utworzyć plik o dowolnej liczbie wierszy.
Oblicz średnią arytmetyczną pensji wszystkich pracowników. Wypisz na ekranie imię i nazwisko pracownika
o największej pensji.
 */

import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Zad6 {

    static int countLines(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner scanner = new Scanner(reader)) {
            int counter = 0;
            while (scanner.hasNextLine()) {
                counter++;
                scanner.nextLine();
            }
            return counter;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static int[] getNumbers(String line) {
        String[] numbersStr = line.split(",");
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

//    static String[] getWords(String line) {
//        if (line == null) {
//            throw new IllegalArgumentException("Line is not correct");
//        }
//        return line.split(",");
//    }
//
//    static String[][] readData(String filename) {
//        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
//            String[][] array = new String[countLines(filename)][];
//            for (int i = 0; i < array.length; i++) {
//                array[i] = getWords(sc.nextLine());
//            }
//            return array;
//        } catch (Exception e) {
//            throw new IllegalStateException(e.getMessage());
//        }
//    }
//
//    static double average(String[][] array) {
//        int sum = 0;
//        int[] numbers = null;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                numbers[i] = Integer.parseInt(String.valueOf(array[i]));
//                sum += numbers[i];
//            }
//        }
//        return sum / numbers.length * 1.0;
//    }

    public static void main(String[] args) {

        String filename = "src/zad6/osoby.txt";
        int[][] arr = readData3(filename);
        System.out.println(Arrays.deepToString(arr));
//        double avg = average(arr);
//        System.out.println(avg);
    }
}
