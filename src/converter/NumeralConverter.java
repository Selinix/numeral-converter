package converter;


public class NumeralConverter {

    public String convert(int arabicNumber) {
        if (arabicNumber == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        Romans[] romans = Romans.values();
        float left = arabicNumber;
        while (left > 0) {
            for (int index = romans.length - 1; index >= 0; index--) {
                float divide = left / romans[index].getArabicValue();
                if (divide >= 0.9f & left / romans[index].getArabicValue() < 1f) {
                    result.append(romans[index - 2]);
                    result.append(romans[index]);
                    left -= romans[index].getArabicValue() * 0.9;
                    break;
                }
                if (divide >= 4) {
                    result.append(romans[index]);
                    result.append(romans[index + 1]);
                    left -= romans[index].getArabicValue() * 4;
                    break;
                }
                if (divide >= 1) {
                    for (int i = 0; i < (int)divide; i++) {
                        result.append(romans[index]);
                    }
                    left -= romans[index].getArabicValue() * (int)divide;
                    break;
                }
            }
        }
        return result.toString();
    }

    public int convert(String romanNumber) {
        if (romanNumber == null || romanNumber.length() == 0) return 0;
        if (romanNumber.length() == 1) return Romans.valueOf(romanNumber).getArabicValue();

        char[] romanLetters = romanNumber.toCharArray();

        int result = 0;
        int currentValue;
        int nextValue;
        int add;

        for (int i = 0; i < romanLetters.length; i++) {
            currentValue = Romans.valueOf(String.valueOf(romanLetters[i])).getArabicValue();
            nextValue = i < romanLetters.length - 1 ? Romans.valueOf(String.valueOf(romanLetters[i + 1])).getArabicValue() : 0;
            if (nextValue > currentValue) {
                add = nextValue - currentValue;
                i++;
            } else {
                add = currentValue;
            }
            result += add;
        }
        return result;
    }
}
