package datastructure.stack;


import datastructure.Stack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ResizingArrayStack<T> implements Iterable<T>, Stack<T>{

    private final static int DEFAULT_CAPACITY = 16;

    private Object[] items;

    private int count;

    private int modCount;

    public ResizingArrayStack(){
        items = new Object[DEFAULT_CAPACITY];
        count = 0;
        modCount++;
    }

    public ResizingArrayStack(int capacity){
        if (capacity <= 0)
            capacity = DEFAULT_CAPACITY;
        items =new Object[capacity];
        count = 0;
        modCount++;
    }

    @Override
    public void push(T item){
        modCount++;
        if (items.length == count) resize(items.length*2);
        items[count++] = item;
    }

    @Override
    public T pop(){
        modCount++;
        if (isEmpty())
            return null;
        return (T)items[--count];
    }

    private void resize(int newCapacity) {
        Object[] ni = new Object[newCapacity];
        for (int i = 0;i<count;++i)
            ni[i] = items[i];
        items = ni;
    }

    @Override
    public boolean isEmpty(){
        return count == 0;
    }

    public int size(){
        return count;
    }

    public Iterator<T> iterator() {
        return new StackIterator(count,modCount);
    }

    private class StackIterator implements Iterator<T> {

        private int index;

        private int modC;

        public StackIterator(int index,int modCount){
            this.index = index;
            this.modC = modCount;
        }

        public boolean hasNext() {
            return index > 0;
        }

        public T next() {
            if (modCount != modC)
                throw new ConcurrentModificationException();
            return (T)items[--index];
        }

        public void remove() {
        }
    }

}
