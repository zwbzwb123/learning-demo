package datastructure.queue;


public class LinkedQueue<T> {

    Node<T> head;
    Node<T> tail;

    int count;

    public void enqueue(T item) {
        Node ot = tail;
        tail = new Node<T>(item,null);
        if (isEmpty())  head = tail;
        else            ot.next = tail;
        count++;
    }

    public T dequeue() {
        if (isEmpty())
            return null;
        T res = head.item;
        head = head.next;
        count--;
        return res;
    }

    public int size() {
        return count;
    }


    public boolean isEmpty() {
        return head == null;
    }

    private class Node<T> {
        T item;
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
