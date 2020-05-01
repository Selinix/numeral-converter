package converter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    //VM options for GC logging: -XX:+UseSerialGC -Xms1024m -Xmx1024m -verbose:gc

    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir");
        Path testNumerals = Paths.get(dir + "test_numerals.txt");
        Path romanNumerals = Paths.get(dir + "roman_numerals.txt");
        Path arabicNumerals = Paths.get(dir + "arabic_numerals.txt");
        FileGenerator.generateTestNumbers(testNumerals, 5_000_000);
        FileGenerator.convertToRoman(testNumerals, romanNumerals);
        FileGenerator.convertToArabic(romanNumerals, arabicNumerals);
        System.out.println(FileGenerator.compare(testNumerals, arabicNumerals));
    }
}
