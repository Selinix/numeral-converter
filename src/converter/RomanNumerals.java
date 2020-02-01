package converter;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class RomanNumerals {
    private static List<Pair<String, Integer>> romanNumerals;
    static {
        romanNumerals = new ArrayList<>();
        romanNumerals.add(new Pair<>("I", 1));
        romanNumerals.add(new Pair<>("V", 5));
        romanNumerals.add(new Pair<>("X", 10));
        romanNumerals.add(new Pair<>("L", 50));
        romanNumerals.add(new Pair<>("C", 100));
        romanNumerals.add(new Pair<>("D", 500));
        romanNumerals.add(new Pair<>("M", 1000));
    }

    public static String getRoman(int index) {
        return romanNumerals.get(index).getKey();
    }
    public static int getArabic(int index) {
        return romanNumerals.get(index).getValue();
    }


    public static int getSize() {
        return romanNumerals.size();
    }
}
