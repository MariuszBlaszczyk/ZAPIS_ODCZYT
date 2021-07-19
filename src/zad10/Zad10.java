package zad10;

/*
Wygeneruj 100 liczb losowych z przedziału <20, 45> i zapisz je do pliku tekstowego ‘liczby.txt’
w postaci liczba1;liczba2;liczba3;… .
Następnie pobierz zawartość pliku ‘liczby.txt’ i oblicz odchylenie standardowe pobranych liczb.
 */

import java.util.Random;

public class Zad10 {

    static int generateNumbers(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min is bigger than max!");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static void saveToFile

    public static void main(String[] args) {

        int min = 20;
        int max = 45;
    }
}
