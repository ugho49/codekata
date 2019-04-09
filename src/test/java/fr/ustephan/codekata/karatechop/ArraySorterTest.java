package fr.ustephan.codekata.karatechop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArraySorterTest {


    @Test
    public void shouldReturnMinusOneWhenItemDontExist() {
        assertEquals(-1, ArraySorter.chop(3, new int[] {}));
        assertEquals(-1, ArraySorter.chop(3, new int[] {1}));
        assertEquals(-1, ArraySorter.chop(0, new int[] {1, 3, 5}));
        assertEquals(-1, ArraySorter.chop(2, new int[] {1, 3, 5}));
        assertEquals(-1, ArraySorter.chop(4, new int[] {1, 3, 5}));
        assertEquals(-1, ArraySorter.chop(6, new int[] {1, 3, 5}));
        assertEquals(-1, ArraySorter.chop(0, new int[] {1, 3, 5, 7}));
        assertEquals(-1, ArraySorter.chop(2, new int[] {1, 3, 5, 7}));
        assertEquals(-1, ArraySorter.chop(4, new int[] {1, 3, 5, 7}));
        assertEquals(-1, ArraySorter.chop(6, new int[] {1, 3, 5, 7}));
        assertEquals(-1, ArraySorter.chop(8, new int[] {1, 3, 5, 7}));
    }

    @Test
    public void shouldReturnCorrectIndexOfArray() {
        assertEquals(0,  ArraySorter.chop(1, new int[] {1}));
        assertEquals(0,  ArraySorter.chop(1, new int[] {1, 3, 5}));
        assertEquals(1,  ArraySorter.chop(3, new int[] {1, 3, 5}));
        assertEquals(2,  ArraySorter.chop(5, new int[] {1, 3, 5}));
        assertEquals(0,  ArraySorter.chop(1, new int[] {1, 3, 5, 7}));
        assertEquals(1,  ArraySorter.chop(3, new int[] {1, 3, 5, 7}));
        assertEquals(2,  ArraySorter.chop(5, new int[] {1, 3, 5, 7}));
        assertEquals(3,  ArraySorter.chop(7, new int[] {1, 3, 5, 7}));
    }
}