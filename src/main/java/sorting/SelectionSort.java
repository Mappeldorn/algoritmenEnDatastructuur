package sorting;

import java.util.Collections;
import java.util.List;

public class SelectionSort {

    public static <E extends Comparable<E>> void selectionSort(List<E> list) {
        //Size of the list
        int listSize = list.size();

        for (int i = 0; i < listSize - 1; i++) {
            int min_index = i;
            for (int j = i+1; j < listSize; j++) {
                if (list.get(j).compareTo(list.get(min_index)) < 0)
                    min_index = j;
            }

            Collections.swap(list, i, min_index);
        }
    }
}
