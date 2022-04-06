package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] array;
    T[] a;

    public ArrayUtility(T[] inputArray){
        array = inputArray;
    }

    public ArrayUtility(Class<T[]> clazz, int length){
        a = clazz.cast(Array.newInstance(clazz.getComponentType(), length));
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
        Class clazzRemove = array.getClass();
        ArrayList<T> arrayList = new ArrayList<>();
        for (T t : array) {
            if (t != valueToRemove) {
                arrayList.add(t);
            }
        }
        ArrayUtility intermediate = new ArrayUtility(clazzRemove, arrayList.size());

        for (int i = 0; i < arrayList.size(); i++) {
            intermediate.a[i] = arrayList.get(i);
        }
        T[] output = (T[]) Arrays.copyOf(intermediate.a, intermediate.a.length);
        return output;
    }
}
