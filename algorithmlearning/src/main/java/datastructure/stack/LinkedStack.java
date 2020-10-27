package datastructure.stack;


import datastructure.Stack;

public class LinkedStack<T> implements Stack<T> {

    private Node<T> head;

    public void push(T item){
        Node<T> oh = head;
        head = new Node<>(item,oh);
    }

    public T pop(){
        if (isEmpty())
            return null;
        Node<T> res = head;
        head = head.next;
        return res.item;
    }

    public boolean isEmpty(){
        return head == null;
    }

    private class Node<T>{
        T item;
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
