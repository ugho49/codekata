package fr.ustephan.codekata.romannumeral;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumericalConverterTest {

    @Test
    void shouldConvertThreeFirstnumbers() {
        assertThat(NumericalConverter.convert(1)).isEqualTo("I");
        assertThat(NumericalConverter.convert(2)).isEqualTo("II");
        assertThat(NumericalConverter.convert(3)).isEqualTo("III");
    }

    @Test
    void shouldConvertFourNumericToIV() {
        assertThat(NumericalConverter.convert(4)).isEqualTo("IV");
        assertThat(NumericalConverter.convert(14)).isEqualTo("XIV");
    }

    @Test
    void shouldConvertFiveNumericToV() {
        assertThat(NumericalConverter.convert(5)).isEqualTo("V");
    }

    @Test
    void shouldConvertSixNumericToVI() {
        assertThat(NumericalConverter.convert(6)).isEqualTo("VI");
    }

    @Test
    void shouldConvertSevenNumericToVII() {
        assertThat(NumericalConverter.convert(7)).isEqualTo("VII");
    }

    @Test
    void shouldConvertNineNumericToIX() {
        assertThat(NumericalConverter.convert(9)).isEqualTo("IX");
    }

    @Test
    void shouldConvertTenNumericToX() {
        assertThat(NumericalConverter.convert(10)).isEqualTo("X");
    }

    @Test
    void shouldConvertSixteenNumericToXVI() {
        assertThat(NumericalConverter.convert(16)).isEqualTo("XVI");
    }

    @Test
    void shouldConvertTwentyNumericToXX() {
        assertThat(NumericalConverter.convert(20)).isEqualTo("XX");
    }

    @Test
    void shouldConvertFiftyNumericToL() {
        assertThat(NumericalConverter.convert(50)).isEqualTo("L");
    }

    @Test
    void shouldConvertHundredNumericToC() {
        assertThat(NumericalConverter.convert(100)).isEqualTo("C");
    }

    @Test
    void shouldConvertFiveHundredNumericToD() {
        assertThat(NumericalConverter.convert(500)).isEqualTo("D");
    }

    @Test
    void shouldConvertThousandNumericToM() {
        assertThat(NumericalConverter.convert(1000)).isEqualTo("M");
    }
}
