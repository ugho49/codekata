package fr.ustephan.codekata.romannumeral;

class NumericalConverter {

    static String convert(int numeral) {
        StringBuilder result = new StringBuilder();

        numeral = getNumeral(numeral, 1000, "M", result);
        numeral = getNumeral(numeral, 500, "D", result);
        numeral = getNumeral(numeral, 100, "C", result);
        numeral = getNumeral(numeral, 50, "L", result);
        numeral = getNumeral(numeral, 10, "X", result);
        numeral = getNumeral(numeral, 9, "IX", result);
        numeral = getNumeral(numeral, 5, "V", result);
        numeral = getNumeral(numeral, 4, "IV", result);
        getNumeral(numeral, 1, "I", result);

        return result.toString();
    }

    private static int getNumeral(int numeral, int numericNumber, String romanNumber, StringBuilder result) {
        while (numeral / numericNumber != 0) {
            result.append(romanNumber);
            numeral -= numericNumber;
        }
        return numeral;
    }

}