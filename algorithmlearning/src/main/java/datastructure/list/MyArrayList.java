package datastructure.list;

import datastructure.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyArrayList<T> implements Iterable<T>, List<T> {

    private final static int DEFAULT_CAPACITY = 10;
    private T[] items;
    private int size;
    private int modCount;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        items = (T[]) new Object[capacity];
        size = modCount = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(T t) {
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return items[index];
    }

    @Override
    public void add(T item) {
        add(size(), item);
    }

    private void add(int index, T item) {
        ensureCapacity();
        modCount++;
        for (int i = size(); i > index; i--)
            items[i] = items[i - 1];
        items[index] = item;
        size++;
    }

    @Override
    public T remove(int index) {
        T item = items[index];
        int size = size();
        for (int i = index; i < size; i++)
            items[i] = items[i + 1];
        size--;
        modCount++;
        return item;
    }

    private void ensureCapacity() {
        if (size() == items.length)
            resize();
    }

    private void resize() {
        T[] oldItems = items;
        items = (T[]) new Object[items.length * 2];
        int size = size();
        for (int i = 0; i < size; i++) {
            items[i] = oldItems[i];
        }
    }

    public Iterator<T> iterator() {
        return null;
    }

    private class ListIterator implements Iterator {

        boolean canRemove = false;
        int mc = modCount;
        int index = 0;

        public void remove() {
            if (mc != modCount)
                throw new ConcurrentModificationException();
            if (!canRemove)
                throw new IllegalStateException();
            MyArrayList.this.remove(--index);
            mc++;
            canRemove = false;
        }

        public boolean hasNext() {
            return index < size();
        }

        public T next() {
            if (mc != modCount)
                throw new ConcurrentModificationException();
            if (!hasNext())
                throw new NoSuchElementException();
            canRemove = true;
            return items[index++];
        }
    }
}
