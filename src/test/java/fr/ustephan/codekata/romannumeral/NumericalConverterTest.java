package fr.ustephan.codekata.romannumeral;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumericalConverterTest {

    @Test
    public void shouldConvertThreeFirstnumbers() {
        assertEquals(NumericalConverter.convert(1), "I");
        assertEquals(NumericalConverter.convert(2), "II");
        assertEquals(NumericalConverter.convert(3), "III");
    }

    @Test
    public void shouldConvertFourNumericToIV() {
        assertEquals(NumericalConverter.convert(4), "IV");
        assertEquals(NumericalConverter.convert(14), "XIV");
    }

    @Test
    public void shouldConvertFiveNumericToV() {
        assertEquals(NumericalConverter.convert(5), "V");
    }

    @Test
    public void shouldConvertSixNumericToVI() {
        assertEquals(NumericalConverter.convert(6), "VI");
    }

    @Test
    public void shouldConvertSevenNumericToVII() {
        assertEquals(NumericalConverter.convert(7), "VII");
    }

    @Test
    public void shouldConvertNineNumericToIX() {
        assertEquals(NumericalConverter.convert(9), "IX");
    }

    @Test
    public void shouldConvertTenNumericToX() {
        assertEquals(NumericalConverter.convert(10), "X");
    }

    @Test
    public void shouldConvertSixteenNumericToXVI() {
        assertEquals(NumericalConverter.convert(16), "XVI");
    }

    @Test
    public void shouldConvertTwentyNumericToXX() {
        assertEquals(NumericalConverter.convert(20), "XX");
    }

    @Test
    public void shouldConvertFiftyNumericToL() {
        assertEquals(NumericalConverter.convert(50), "L");
    }

    @Test
    public void shouldConvertHundredNumericToC() {
        assertEquals(NumericalConverter.convert(100), "C");
    }

    @Test
    public void shouldConvertFiveHundredNumericToD() {
        assertEquals(NumericalConverter.convert(500), "D");
    }

    @Test
    public void shouldConvertThousandNumericToM() {
        assertEquals(NumericalConverter.convert(1000), "M");
    }
}
