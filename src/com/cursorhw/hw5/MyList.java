package com.cursorhw.hw5;

import java.util.ArrayList;
import java.util.Collections;

public class MyList<T extends Number> {

    private ArrayList<T> arrayList = new ArrayList<>();

    public void add(T param) {
        arrayList.add(param);
    }

    public ArrayList getArrayList() {
        return arrayList;
    }

    public T smallest() {
        ArrayList arrayList = getArrayList();
        return (T) Collections.min(arrayList);
    }

    public T largest() {
        ArrayList arrayList = getArrayList();
        return (T) Collections.max(arrayList);
    }
}