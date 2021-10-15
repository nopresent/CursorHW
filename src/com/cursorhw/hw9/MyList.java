package com.cursorhw.hw9;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<V> implements List<V> {

    private static final int DEFAULT_MAP_CAPACITY = 10;
    private int size;
    private int currentCapacity;
    Node<V>[] table;

    public MyList(int capacity) {
        table = new Node[capacity];
        currentCapacity = capacity;
        size = 0;
    }

    public MyList() {
        this(DEFAULT_MAP_CAPACITY);
    }

    static class Node<V> {
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size < 0)
            throw new IllegalStateException("Size cant be negative!");
        return size == 0;
    }

    public boolean add(V v) {
        table[size] = new Node<>(v);
        size++;
        return true;
    }

    private void checkSize(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Element does not exists!");
        }
    }

    @Override
    public V get(int index) {
        checkSize(index);
        return table[index].value;
    }

    @Override
    public String toString() {
        String returnString = "[";
        for (int i = 0; i < size; i++) {
            returnString += "(" + i + ":" + table[i].value + ")";
        }
        returnString += "]";
        return returnString;
    }

    @Override
    public V remove(int index) {
        checkSize(index);
        int y = 0;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                table[index] = null;
                y++;
            }
            table[i] = table[i + y];
        }
        size--;
        return null;
    }


    @Override
    public void add(int index, V v) {

        if (index > currentCapacity - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " not in currentCapacity: " + currentCapacity);
        }

        if (index == size) {
            add(v);
        } else if (index > size) {
            // Добавить пустых елементов
            int tmpSize = size;
            for (int i = tmpSize; i < index; i++) {
                add(null);
            }
            add(v);
        } else {
            // Добавляем пустую запись, на которую будет идти смещение
            add(null);
            for (int i = size - 1; i > index; i--) {
                set(i, get(i - 1));
            }
            set(index, v);
        }

    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        checkSize(fromIndex);
        checkSize(toIndex);
        MyList<V> mylist = new MyList<>();
        for (int i = fromIndex; i <= toIndex; i++) {
            mylist.add(get(i));
        }
        return mylist;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (get(i) == o) {
                remove(i);
            }
        }
        return false;
    }

    @Override
    public V set(int index, V element) {
        checkSize(index);
        table[index] = new Node<>(element);
        return null;
    }

    // Осталось переопределить )

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }


}
