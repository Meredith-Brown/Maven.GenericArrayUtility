package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

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
        ArrayList<T> withDuplicates = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            withDuplicates.add(array[i]);
        }
        for (int j = 0; j < arrayToMerge.length; j++) {
            withDuplicates.add(arrayToMerge[j]);
        }

        ArrayList<T> arrayList = new ArrayList<>(); // no duplicates
        for (T t : withDuplicates) {
            if (arrayList.contains(t)) {

            } else {
                arrayList.add(t);
            }
        }

        ArrayList<Integer> frequencyList = new ArrayList<>();
        for (T t : arrayList) {
            Integer count = 0;
            for (T t2 : withDuplicates) {
                if (t2 == t) {
                    count++;
                }
            }
            frequencyList.add(count);
        }

        T output = arrayList.get(0);
        Integer outputFrequency = frequencyList.get(0);
        for (int k = 1; k < arrayList.size(); k++) {
            if (frequencyList.get(k) > outputFrequency) {
                output = arrayList.get(k);
                outputFrequency = frequencyList.get(k);
            }
        }
        return output;
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
        ArrayList<T> arrayList = new ArrayList<>();
        for (T t : array) {
            if (t != valueToRemove) {
                arrayList.add(t);
            }
        }
        T[] output = arrayList.toArray(new T[0]);
        for (int i = 0; i < arrayList.size(); i++) {
            output[i] = arrayList.get(i);
        }
        return output;
    }
}
