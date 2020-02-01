package converter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class FileGenerator {
    public static void generateTestNumbers(Path pathToWrite, int numOfNumerals) throws IOException {
        File fileToWrite = new File(pathToWrite.toString());

        if (fileToWrite.exists()) {
            fileToWrite.delete();
        }

        Random rand = new Random();

        long startTime = System.currentTimeMillis();
        try (BufferedWriter writer = Files.newBufferedWriter(pathToWrite)) {
            for (int i = 0; i < numOfNumerals; i++) {
                writer.write(String.valueOf(rand.nextInt(3000) + 1));
                writer.write("\n");
            }
        }
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        System.out.println("Generating test numerals: " + (double)timeTaken/1000 + " s");
    }

    public static void convertToRoman(Path pathToRead, Path pathToWrite) throws IOException {
        File fileToWrite = new File(pathToWrite.toString());

        if (fileToWrite.exists()) {
            fileToWrite.delete();
        }

        NumeralConverter converter = new NumeralConverter();
        long startTime = System.currentTimeMillis();

        try (BufferedReader reader = Files.newBufferedReader(pathToRead);
             BufferedWriter writer = Files.newBufferedWriter(pathToWrite)) {
            reader.lines().forEach(line -> {
                try {
                    writer.write(converter.convert(Integer.valueOf(line)));
                    writer.write(System.lineSeparator());
                } catch (IOException exc) {
                    System.out.println("ooops");
                }
            });
        }

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        System.out.println("Converting to roman numerals: " + (double)timeTaken/1000 + " s");
    }

    public static void convertToArabic(Path pathToRead, Path pathToWrite) throws IOException {
        File fileToWrite = new File(pathToWrite.toString());

        if (fileToWrite.exists()) {
            fileToWrite.delete();
        }

        NumeralConverter converter = new NumeralConverter();
        long startTime = System.currentTimeMillis();

        try (BufferedReader reader = Files.newBufferedReader(pathToRead);
             BufferedWriter writer = Files.newBufferedWriter(pathToWrite)) {
            reader.lines().forEach(line -> {
                try {
                    writer.write(String.valueOf(converter.convert(line)));
                    writer.write(System.lineSeparator());
                } catch (IOException exc) {
                    System.out.println("ooops");
                }
            });
        }

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        System.out.println("Converting to arabic numerals: " + (double)timeTaken/1000 + " s");
    }

    public static boolean compare(Path testNumbers, Path compareTo) throws IOException {
        boolean result = true;
        int count = 0;
        try (BufferedReader testReader = Files.newBufferedReader(testNumbers);
             BufferedReader compareToReader = Files.newBufferedReader(compareTo)) {
            String testString;
            String compareString;
            while ((testString = testReader.readLine()) != null && (compareString = compareToReader.readLine()) != null) {
                count++;
                if (!testString.equals(compareString)) {
                    result = false;
                    break;
                }
            }
            System.out.println(count);
            return result;
        }


    }
}
