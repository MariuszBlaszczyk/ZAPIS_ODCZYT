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

    static String[] readData(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            String[] newText = new String[countLines(filename)];
            for (int i = 0; i < newText.length; i++) {
                newText[i] = sc.nextLine().trim();
            }
            return newText;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    static int countNumbersInArray(String[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        int counterNumbers = 0;
        for (int i = 0; i < array.length; i++) {
            if (isNumeric(array[i])) {
                counterNumbers++;
            }
        }
        return counterNumbers;
    }


//    static double calculateAverage(String[] array) {
//        if (array == null || array.length == 0) {
//            throw new IllegalArgumentException("Array is null or empty");
//        }
//        int sum = 0;
//
//    }

    public static void main(String[] args) {

        String filename = "src/zad6/osoby.txt";
        String[] ne = readData(filename);
        System.out.println(Arrays.toString(ne));
        int ccc = countNumbersInArray(ne);
        System.out.println(ccc);

    }
}
