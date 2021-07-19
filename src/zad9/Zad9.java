package zad9;
/*
Plik ‘litera.txt’ ma postać:
napis1-2
napis2-1
…
Dowolnie wybrane napisy i liczby należy wpisywać podczas tworzenia pliku tekstowego.
Liczba po myślniku oznacza numer znaku z napisu przed myślnikiem. Trzy kropki symbolizują,
że plik ma dowolną liczbę wierszy ustalaną podczas tworzenia pliku. Należy pobrać dane z pliku tekstowego
i utworzyć napis wynikowywynikowy, który zawiera w sobie znaki z pobranych napisów z pozycji
określonych przez liczby po myślnikach. Przykładowo, jeżeli plik zawiera dwa wiersze:
ABC-2
EFG-1
Napis wynikowy to CF. Znaki numerujemy od 0.
 */

import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Zad9 {

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

    static String[] getWords(String line) {
        if (line == null) /*|| !line.matches("(czy dodawać matches skoro 14 i 16 linia są puste???)*/ {
            throw new IllegalArgumentException("Line is not correct");
        }
        return line.split("-");
    }

    static String[][] readData(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            String[][] lines = new String[countLines(filename)][];
            for (int i = 0; i < lines.length; i++) {
                lines[i] = getWords(sc.nextLine());
            }
            return lines;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static String captionResults(String[][] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        StringBuilder builder = new StringBuilder();
        int[] numbers = new int[array.length / 2];
        String[] strArray = new String[numbers.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                numbers[i] = Integer.parseInt(array[i][1]);
                char chars[] = array[i][0].toCharArray();
                strArray[i] = 
            }
        }


        String newWord = builder.toString();
        return newWord;
    }

    public static void main(String[] args) {

        String filename = "src/zad9/litera.txt";
        String[][] array = readData(filename);
        System.out.println(Arrays.deepToString(array));

        String result = captionResults(array);
        System.out.println("Caption result :" + result);
    }
}
