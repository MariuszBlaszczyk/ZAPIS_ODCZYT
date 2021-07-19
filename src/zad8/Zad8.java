package zad8;

/*
Plik tekstowy ‘liczby.txt’ ma postać:
3 4
5 6
…
Trzy kropki symbolizują, że plik ma dowolną liczbę wierszy ustalaną podczas tworzenia pliku.
Należy odczytać kolejne wiersze z pliku i dla uzyskanych dwóch liczb z każdego wiersza obliczyć ich sumę
oraz iloczyn, a następnie zapisać do nowego pliku tekstowego o nazwie ‘wyniki.txt’.
Dla dwóch wierszy pliku ‘liczby.txt’ zaproponowanego na początku zadania plik ‘wynik.txt’ powinien mieć postać:
7 12
11 30
…
 */


import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Zad8 {

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

    static int[] getNumbers(String line) {
        if (line == null || !line.matches("(\\d+\\D)*\\d+")) {
            throw new IllegalArgumentException("Line is null or empty");
        }
        String[] numberStr = line.split(" ");
        int[] numbers = new int[numberStr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberStr[i]);
        }
        return numbers;
    }

    static int[][] readData(String filename) {
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

    static void saveToFile(String filename, int[][] array) {
        try (FileWriter writer = new FileWriter(filename); PrintWriter printWriter = new PrintWriter(writer)) {
            int tempSum;
            int tempProduct;
            for (int i = 0; i < array.length; i++) {
                int sum = 0;
                int product = 1;
                for (int j = 0; j < array[i].length; j++) {
                    sum += array[i][j];
                    product *= array[i][j];
                }
                tempSum = sum;
                tempProduct = product;
                printWriter.print(tempSum + " ");
                printWriter.print(tempProduct);
                if (i < array.length - 1) {
                    System.out.println();
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public static void main(String[] args) {

        String filename = "src/zad8/liczby.txt";
        int[][] array = readData(filename);

        saveToFile("src/zad8/wynik.txt", array);
    }
}
