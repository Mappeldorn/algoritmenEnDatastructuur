package com.example.ad.sorting;

public class BubbleSort<T extends Comparable<T>> {
    public void bubbleSort(T[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {

                // Compare if the next element is greater than the current
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
