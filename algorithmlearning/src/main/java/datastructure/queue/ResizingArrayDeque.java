package datastructure.queue;


import datastructure.Deque;

/**
 * 可扩容的双端队列，数组实现
 */
public class ResizingArrayDeque<T>  implements Deque<T> {

    private static int DEFAULT_CAPACITY = 16;

    private static int OVERFLOW = -2;

    private int size;

    private int capacity;

    private int leftIndex;

    private int rightIndex;

    private T[] items;


    public ResizingArrayDeque() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ResizingArrayDeque(int capacity) {
        this.capacity = transferCapacity(capacity);
        items = (T[]) new Object[this.capacity];
        size = 0;
        leftIndex = 0;
        rightIndex = this.capacity - 1;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void pushLeft(T item) {
        checkIfNeedResize();
        items[leftIndex++] = item;
        size++;
    }

    private boolean isFull() {
        return rightIndex == leftIndex;
    }

    @Override
    public void pushRight(T item) {
        checkIfNeedResize();
        items[rightIndex--] = item;
        size++;
    }

    @Override
    public T popLeft() {
        T item = items[leftIndex];
        items[--leftIndex] = null;
        // 缩容检查
        // checkIfNeedResize
        size--;
        return item;
    }

    @Override
    public T popRight() {
        T item = items[rightIndex];
        items[++rightIndex] = null;
        size--;
        return item;
    }

    private void resize(int capacity) {
        if (capacity == OVERFLOW) {
            return;
        }
        T[] temp = (T[]) new Object[capacity];
        int length = size;
        this.capacity = capacity;
        int limit = size / 2;
        for (int i = 0; i <= limit; i++) {
            temp[i] = items[i];
            temp[--capacity] = items[length--];
        }
        rightIndex = this .capacity- limit - 1;
        this.items = temp;
    }

    private void checkIfNeedResize() {
        if (leftIndex == rightIndex)
            resize(this.capacity << 1);
    }

    private int transferCapacity(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n > 0 ? n + 1 : DEFAULT_CAPACITY;
    }

    public String toString() {
        System.out.println("capacity is :" + capacity);
        for (int i = 0; i < items.length; i++)
            System.out.print(" " + items[i]);

        return "";
    }
}
