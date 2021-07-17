//package zad7;
//
///*
//Plik tekstowy ‘temperatury.txt’ ma postać:
//23.4;24.3;24.2
//25.4;25.3;27.2
//28.4;23.3;21.2
//…
//Plik zawiera pomiary temperatury rano, w południe i wieczorem dla kolejnych 30 dni.
//Pobierz dane z pliku tekstowego i wyznacz numer dnia:
//a) w którym temperatura rano miała najmniejszą wartość,
//b) w którym temperatura w południe miała największą wartość,
//c) w którym średnia temperatur rano, w południe i wieczorem była największa
// */
//
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Zad7 {
//
////    static void saveToFile(String filename, String[][] array) {
////        try (FileWriter writer = new FileWriter(filename); PrintWriter printWriter = new PrintWriter(writer)) {
////            for (int i = 0; i < array.length; i++) {
////                for (int j = 0; j < array[i].length; j++) {
////                    printWriter.println(array[i][j]);
////                }
////            }
////        } catch (Exception e) {
////            throw new IllegalStateException(e.getMessage());
////        }
////    }
//
//
//    static int countLines(String filename) {
//        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
//            int counter = 0;
//            while (sc.hasNextLine()) {
//                ++counter;
//                sc.nextLine();
//            }
//            return counter;
//        } catch (Exception e) {
//            throw new IllegalStateException(e.getMessage());
//        }
//    }
//
//    static double[] getNumbers(String line) {
//        if (line == null || !line.matches("(\\d+\\D)*\\d+")) {
//            throw new IllegalArgumentException("Line is not correct");
//        }
//        String[] numbersStr = line.split(";");
//        double[] numbers = new double[numbersStr.length];
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = Double.parseDouble(numbersStr[i]);
//        }
//        return numbers;
//    }
//
//    static double[][] readData(String filename) {
//        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
//            double[][] numbers = new double[countLines(filename)][];
//            for (int i = 0; i < numbers.length; i++) {
//                numbers[i] = getNumbers(sc.nextLine());
//            }
//            return numbers;
//        } catch (Exception e) {
//            throw new IllegalStateException(e.getMessage());
//        }
//    }
//
//    static int highestTemperatureSouth(double[][] array) {
//        if (array == null || array.length == 0) {
//            throw new IllegalArgumentException("Array is null or empty");
//        }
//        int dayNumber = 0;
//        double maxTemp = Double.MIN_VALUE;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                if (array[i][1] > maxTemp) {
//                    maxTemp = array[i][1];
//                    dayNumber = i + 1;
//                }
//            }
//        }
//        return dayNumber;
//    }
//
//
//    static int smallestTemperatureMorning(double[][] array) {
//        if (array == null || array.length == 0) {
//            throw new IllegalArgumentException("Array is null or empty");
//        }
//        int dayNumber = 0;
//        double minTemp = Double.MAX_VALUE;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                if (array[i][0] < minTemp) {
//                    minTemp = array[i][0];
//                    dayNumber = i + 1;
//                }
//            }
//        }
//        return dayNumber;
//    }
//
//
//    static double calculateAverage(double[] array) {
//        if (array == null || array.length == 0) {
//            throw new IllegalArgumentException("Array is null or empty");
//        }
//
//        double sum = 0;
//        double avg = 0;
//        array = 
//        for (double value : array) {
//            String[ = line.split(",");
//            String salary = personData[2];
//        }
//        return avg / array.length;
//    }
//
//
//    static int averageTemperaturesInTheMorningMiddayAndEveningWereTheHighest(int[][] arr) {
//        int maxIdx = 0;
//        int maxSum = sumElements(arr[0]);
//        int sum;
//        for (int i = 1; i < arr.length; i++) {
//            sum = sumElements(arr[i]);
//            if (sum > maxSum) {
//                maxSum = sum;
//                maxIdx = i;
//            }
//        }
//
//        return maxIdx;
//    }
//
//
//    public static void main(String[] args) {
//
////        saveToFile("src/zad7/temperatury.txt", new String[][]{
////                {"23.4;", "24.3;", "24.2"},
////                {"25.4;", "25.3;", "27.2"},
////                {"28.4;", "23.3;", "21.2"},
////                {"22.3;", "25.7;", "24.8"},
////                {"23.3;", "24.9;", "23.9"},
////                {"22.4;", "25.6;", "24.8"},
////                {"22.2;", "23.3;", "21.1"}
////        });
//
//        String filename = "src/zad7/temperatury.txt";
//        double arr[][] = readData(filename);
//        System.out.println(Arrays.deepToString(arr));
//        int morningSmallest = smallestTemperatureMorning(arr);
//        System.out.println("The number of the day on which the morning temperature had the lowest value: " +
//                smallestTemperatureMorning(arr));
//        int southHighest = highestTemperatureSouth(arr);
//        System.out.println("The number of the day on which the midday temperature had the highest value: " +
//                southHighest);
//
//
//    }
//}