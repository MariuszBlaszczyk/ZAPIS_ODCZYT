package zad5;

/*
Plik tekstowy ‘napisy.txt’ posiada strukturę jak poniżej:
napis1; napis2; napis3
napis4; napis5; napis6
napis7; napis8; napis9
Każdy napis jest dowolny i wpiszesz go podczas tworzenia pliku tekstowego.
Trzy kropki symbolizują, że możesz utworzyć plik o dowolnej liczbie wierszy.
Pobierz napisy z pliku tekstowego i oblicz, ile jest w pliku wierszy, które zawierają w sobie
co najmniej dwa napisy składające się z samych dużych liter.
 */

import java.beans.Expression;
import java.io.FileReader;
import java.util.Scanner;

public class Zad5 {

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
        if (line == null || !line.matches("([A-Za-z]+[^A-Za-z])*[A-Za-z]+")) {
            throw new IllegalArgumentException("Line is not correct");
        }
        return line.split("[^A-Za-z]");
    }

    static String[][] readData(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            String array[][] = new String[countLines(filename)][];
            for (int i = 0; i < array.length; i++) {
                array[i] = getWords(sc.nextLine();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage())
        }
    }
}
