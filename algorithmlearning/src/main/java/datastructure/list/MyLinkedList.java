package datastructure.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable {

    private int modCount;
    private int     size;
    private Node<T> head;
    private Node<T> tail;

    public static void main(String[] args) {
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(1);
        list.add(3);
        list.add(2);

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    public MyLinkedList() {
        head = new Node<T>(null, null, null);
        tail = new Node<T>(null, head, null);
        head.next = tail;
    }

    public void add(T item) {
        add(size(), item);
    }

    public void add(int index, T item) {
        Node<T> p = getNode(index);
        p.prev = p.prev.next = new Node<T>(item,p.prev,p);
        size++;
        modCount++;
    }

    /*
     *   头节点的下一个节点是第1个节点
     */
    public T get(int index) {
        return getNode(index).item;
    }

    public T remove(int index) {
        Node<T> node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        modCount++;
        return node.item;
    }

    private Node<T> getNode(int index) {

        if (index < 0 || index > size())
            throw new NoSuchElementException();
        if (size() == 0)
            return tail;
        Node<T> p;
        if (size() / 2 > index) {
            p = head;
            for (int i = 0; i < index; i++)
                p = p.next;
            return p;
        } else {
            p = tail;
            for (int i = size(); i > index; i--)
                p = p.prev;
            return p;
        }
    }

    public boolean contains(T item){
        Node<T> t = head;
        while (t != tail){
            if (t.item == item)
                return true;
            t = t.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {

        boolean canRemove = false;
        int mc = modCount;
        Node<T> h = head.next;

        public boolean hasNext() {
            return h != tail;
        }

        public T next() {
            if (mc != modCount)
                throw new ConcurrentModificationException();
            Node<T> t = h;
            h = h.next;
            canRemove = true;
            return t.item;
        }

        public void remove() {
            if (!canRemove)
                throw new IllegalStateException();
            if (mc != modCount)
                throw new ConcurrentModificationException();
            Node<T> n = h.prev;
            n.prev.next = n.next;
            n.next.prev = n.prev;
            canRemove = false;
        }
    }

    private class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;

        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
