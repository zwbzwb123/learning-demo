package datastructure.queue;

import java.util.NoSuchElementException;

public class LeftistHeap<T extends Comparable<? super T>> {
    private Node root;

    public LeftistHeap() {
    }

    public void insert (T element){
        if (root == null){
            root = new Node(element);
            return;
        }
        root = merge(root,new Node(element));
    }

    public T deleteMin(){
        if (isEmpty())
            throw new NoSuchElementException();
        T res = root.data;
        merge(root.left,root.right);
        return res;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node merge(Node or) {
        if (or == root)
            return root;
        return merge(root, or);
    }


    private Node merge(Node root, Node or) {
        if (root == null)
            return or;
        if (or == null)
            return root;

        // 结点数较小的右子树与数大的合并
        if (root.data.compareTo(or.data) < 0)
            return merge1(root, or);
        else
            return merge1(or, root);
    }

    private Node merge1(Node h1, Node h2) {
        if (h1.left == null) {
            h1.left = h2;
        } else {
            h1.right = merge(h1.right, h2);
            if (h1.left.npl < h1.right.npl)
                swapChild(h1);
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    private void swapChild(Node h1) {
        Node r = h1.right;
        h1.right = h1.left;
        h1.left = r;
    }

    class Node {
        T data;
        Node left;
        Node right;
        int npl;

        public Node(T data) {
            this.data = data;
        }
    }
}
