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
                newText[i] = sc.nextLine();
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

    static double changeStringToDouble(String string) {
        double number = Double.parseDouble(string);
        return number;
    }

    static double calculateAverage(String[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        double sum = 0;
        int numbers = 0;
        for (String line : array) {
            String[] personData = line.split(",");
            String salary = personData[2];
            if (isNumeric(salary)) {
                sum += changeStringToDouble(salary);
                numbers++;
            }
        }
        return sum / numbers;
    }

    static String employeeWithTheHighestSalary(String[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        String name = null;
        String surname = null;
        String salary;
        double maxSalary = Double.MIN_VALUE;
        for (String line : array) {
            String[] personData = line.split(",");
            salary = personData[2];
            if (changeStringToDouble(salary) > maxSalary) {
                maxSalary = changeStringToDouble(salary);
                name = personData[0];
                surname = personData[1];
            }
        }
        return name + surname;
    }

    public static void main(String[] args) {

        String filename = "src/zad6/osoby.txt";
        String[] ne = readData(filename);
        System.out.println(Arrays.toString(ne));
        double average = calculateAverage(ne);
        System.out.println("Salary average: " + average);
        String empWithMaxSal = employeeWithTheHighestSalary(ne);
        System.out.println("The employee with the highest salary: " + empWithMaxSal);

    }
}
