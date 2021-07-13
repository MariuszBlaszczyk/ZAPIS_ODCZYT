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


import java.io.FileReader;
import java.util.Arrays;
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
        if (line == null) {
            throw new IllegalArgumentException("Line is not correct");
        }
        return line.split(";");
    }

    static String[][] readData(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            String array[][] = new String[countLines(filename)][];
            for (int i = 0; i < array.length; i++) {
                array[i] = getWords(sc.nextLine());
            }
            return array;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static int atLeastTwoInscriptionsConsistingOfCapitalLettersOnlyCount(String[][] array) {
        int counter = 0;
        int counterRows = 0;
        String regex = "([^A-Z]+[A-Z$]+)";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].matches(regex)) {
                    counter++;
                    if (counter >= 2) {
                        counterRows++;
                    }
                }
            }
        }
        return counterRows;
    }

    public static void main(String[] args) {

        String filename = "src/zad5/napisy.txt";
        String[][] array = readData(filename);
        System.out.println(Arrays.deepToString(array));
        int result = atLeastTwoInscriptionsConsistingOfCapitalLettersOnlyCount(array);
        System.out.println(result);
    }
}
