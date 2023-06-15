package com.example.ad.sorting;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort <T extends Comparable<T>> {

    public List<T> selectionSort(List<T> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            T temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
        return list;
    }
}
