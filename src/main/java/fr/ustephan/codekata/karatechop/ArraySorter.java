package fr.ustephan.codekata.karatechop;

import java.util.Arrays;

class ArraySorter {

    /*
    A binary chop method that takes an integer search target and a sorted array of integers.
    It should return the integer index of the target in the array, or -1 if the target is not in the array.
    chop(int, array_of_int)  -> int
     */
    static int chop(int search, int[] values) {
        int indice = Arrays.binarySearch(values, search);
        return indice < 0 ? -1 : indice;
    }
}
