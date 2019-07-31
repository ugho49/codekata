package fr.ustephan.codekata.karatechop;

import org.junit.jupiter.api.Test;

import static fr.ustephan.codekata.karatechop.ArraySorter.chop;
import static org.assertj.core.api.Assertions.assertThat;

class ArraySorterTest {

    @Test
    void shouldReturnMinusOneWhenItemDontExist() {
        assertThat(chop(3, new int[]{})).isEqualTo(-1);
        assertThat(chop(3, new int[]{1})).isEqualTo(-1);
        assertThat(chop(0, new int[]{1, 3, 5})).isEqualTo(-1);
        assertThat(chop(2, new int[]{1, 3, 5})).isEqualTo(-1);
        assertThat(chop(4, new int[]{1, 3, 5})).isEqualTo(-1);
        assertThat(chop(6, new int[]{1, 3, 5})).isEqualTo(-1);
        assertThat(chop(0, new int[]{1, 3, 5, 7})).isEqualTo(-1);
        assertThat(chop(2, new int[]{1, 3, 5, 7})).isEqualTo(-1);
        assertThat(chop(4, new int[]{1, 3, 5, 7})).isEqualTo(-1);
        assertThat(chop(6, new int[]{1, 3, 5, 7})).isEqualTo(-1);
        assertThat(chop(8, new int[]{1, 3, 5, 7})).isEqualTo(-1);
    }

    @Test
    void shouldReturnCorrectIndexOfArray() {
        assertThat(chop(1, new int[]{1})).isEqualTo(0);
        assertThat(chop(1, new int[]{1, 3, 5})).isEqualTo(0);
        assertThat(chop(3, new int[]{1, 3, 5})).isEqualTo(1);
        assertThat(chop(5, new int[]{1, 3, 5})).isEqualTo(2);
        assertThat(chop(1, new int[]{1, 3, 5, 7})).isEqualTo(0);
        assertThat(chop(3, new int[]{1, 3, 5, 7})).isEqualTo(1);
        assertThat(chop(5, new int[]{1, 3, 5, 7})).isEqualTo(2);
        assertThat(chop(7, new int[]{1, 3, 5, 7})).isEqualTo(3);
    }
}
