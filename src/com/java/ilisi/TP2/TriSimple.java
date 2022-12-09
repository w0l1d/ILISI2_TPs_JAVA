package com.java.ilisi.TP2;

import java.util.Arrays;

public class TriSimple {
    private static final int DEFAULT_SIZE = 20;
    private static final int DEFAULT_INCREMENT = 5;
    private int nbrElem;
    private final int increment;
    private int[] array;
    public TriSimple() {
        this.array = new int[DEFAULT_SIZE];
        this.nbrElem = 0;
        this.increment = DEFAULT_INCREMENT;
    }
    public TriSimple(int size, int increment) {
        this.array = new int[size];
        this.increment = increment;
        this.nbrElem = 0;
    }
    public void inserer(int entier) {
        try {
            increaseSize();
        } catch (CannotDecreaseArraySize e) {
            System.err.println(e.getMessage());
            if (nbrElem == array.length) {
                System.err.println("error: cannot insert, array is full!");
                return;
            }
        }
        for (int i = nbrElem; i > 0;--i) {
            if (array[i-1] <= entier) {
                array[i] = entier;
                nbrElem++;
                return;
            }
            array[i] = array[i-1];
        }
        array[0] = entier;
        nbrElem++;
    }

    public void supprimer(int entier) {
        if (nbrElem == 0 || array[0] > entier  || entier > array[nbrElem-1])
            return;
        for (int i = 0; i < nbrElem; i++) {
            if (array[i] > entier)
                return;

            if (array[i] == entier) {
                for (int j = i; j < nbrElem-1; j++)
                    array[j] = array[j+1];
                nbrElem--;
                decreaseSize();
                return;
            }
        }
    }

    private void decreaseSize() {
        if (2*increment > array.length - nbrElem )
            return;
        System.err.println("decreased size from " + array.length + " to " + (array.length-increment));
        int[] arr = new int[array.length-increment];
        for (int i = 0; i < nbrElem; i++)
            arr[i] = array[i];
        array = arr;
    }
    private void increaseSize() throws CannotDecreaseArraySize {
        if (nbrElem < array.length-1)
            return;
        if (increment == 0)
            throw new CannotDecreaseArraySize("la valeur d'increment est 0");
        System.err.println("increased size from " + array.length + " to " + (array.length+increment));
        int[] arr = new int[array.length+increment];
        for (int i = 0; i < nbrElem; i++)
            arr[i] = array[i];
        array = arr;
    }
    @Override
    public String toString() {
        return "TriSimple{" +
                "nbrElem=" + nbrElem +
                ",\narray=" + Arrays.toString(Arrays.stream(array).limit(nbrElem).toArray()) +
                "\n}";
    }


}
