package datastructure.queue;

import java.util.NoSuchElementException;

// 优先队列
public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] elements;

    private int size;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    public void insert(T element) {
        if (size == elements.length)
            enlargeElements(elements.length * 2 + 1);
        elements[0] = element;
        int hole = ++size;
        while (element.compareTo(elements[hole / 2]) < 0 && hole > 0) {
            elements[hole] = elements[hole / 2];
            hole = hole / 2;
        }
        elements[hole] = element;
    }

    private void enlargeElements(int newCapacity) {
        T[] old = elements;
        elements =(T[]) new Object[newCapacity];
        for (int j = 0; j <= size; j++) {
                elements[j] = old[j];
        }
    }

    public T deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        T res = elements[1];
        elements[1] = elements[size--];
        sink(1);
        return res;
    }

    private void sink(int hole) {
        T element = elements[hole];
        int child;
        for (; hole * 2 <= size; hole = child) {
            child = hole * 2;
            if (child != size && elements[child+1].compareTo(elements[child]) < 0)
                child ++;
            if (elements[child] .compareTo(element) < 0)
                elements[hole] = elements[child];
            else
                break;
        }
        elements[hole] = element;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
