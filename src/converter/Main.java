package converter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    //VM options for GC logging: -XX:+UseSerialGC -Xms1024m -Xmx1024m -verbose:gc

    public static void main(String[] args) throws IOException {
//        Path testNumerals = Paths.get("D:\\Java\\Projects\\Roman_numerals\\test_numerals.txt");
//        Path romanNumerals = Paths.get("D:\\Java\\Projects\\Roman_numerals\\roman_numerals.txt");
//        Path arabicNumerals = Paths.get("D:\\Java\\Projects\\Roman_numerals\\arabic_numerals.txt");
//        FileGenerator.generateTestNumbers(testNumerals, 5_000_000);
//        FileGenerator.convertToRoman(testNumerals, romanNumerals);
//        FileGenerator.convertToArabic(romanNumerals, arabicNumerals);
//        System.out.println(FileGenerator.compare(testNumerals, arabicNumerals));

        NumeralConverter converter = new NumeralConverter();
        // 777
        // DCCLXXVII
        // 779
        // DCCLXXIX
        System.out.println(converter.convert2(779));
    }
}
