package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] array;

    public ArrayUtility(T[] inputArray){
        array = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        for (int j = 0; j < arrayToMerge.length; j++) {
            arrayList.add(arrayToMerge[j]);
        }
        Integer count = 0;
        for (T t : arrayList) {
            if (t == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        return null;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (T t : array) {
            if (t == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        return null;
    }
}
