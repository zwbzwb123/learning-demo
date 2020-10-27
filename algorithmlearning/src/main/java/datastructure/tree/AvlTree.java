package datastructure.tree;

import java.util.LinkedList;

public class AvlTree<T extends Comparable<? super T>> {

    // 只允许左右子树高度差为1
    private static final int ALLOWED_IMBALANCE = 1;

    private AvlNode root;

    public AvlTree(){
        root = null;
    }

    public void insert(T element){
        root = insert(element,root);
    }

    public void remove(T element){
        root = remove(element,root);
    }

    private AvlNode remove(T element, AvlNode root) {
        if (root == null)
            return null;
        int x = element.compareTo(root.element);
        if (x > 0) {
            root.right = remove(element,root.right);
        } else if ( x < 0) {
            root.left = remove(element,root.left);
        } else if (root.left != null && root.right != null){
            AvlNode p = root.right;
            while (p.left != null)
                p = p.left;
            root.element = p.element;
            root.right = remove(p.element,root.right);
        } else {
            root = (root.left == null?root.right:root.left);
        }
        return balance(root);
    }

    private AvlNode insert(T element, AvlNode root) {
        if (root == null)
            return new AvlNode(null,null,element);

        int x = element.compareTo(root.element);
        if(x > 0) {
            root.right = insert(element,root.right);
        } else if (x <0){
            root.left = insert(element,root.left);
        }

        return balance(root);
    }

    private AvlNode balance(AvlNode root) {
        if (height(root.left) - height(root.right) > ALLOWED_IMBALANCE){
            if ( height(root.left.left) >= height(root.left.right)) // remove 某一节点后，root节点的左子节点的左子树与右子树高度一直，应该是单旋转
                root = rotateWithLeftNode(root);
            else
                root = doubleRotateWithLeftNode(root);
        } else if (height(root.right) - height(root.left) > ALLOWED_IMBALANCE) {
            if (height(root.right.right) >= height(root.right.left))
                root = rotateWithRightNode(root);
            else
                root= doubleRotateWithRightNode(root);
        }
        root.height = Math.max(height(root.left),height(root.right))+1;
        return root;
    }

    private AvlNode doubleRotateWithRightNode(AvlNode root) {
        root.right = rotateWithLeftNode(root.right);
        return rotateWithRightNode(root);
    }

    private AvlNode doubleRotateWithLeftNode(AvlNode root) {
        root.left = rotateWithRightNode(root.left);
        return rotateWithLeftNode(root);
    }

    private AvlNode rotateWithRightNode(AvlNode root) {
        AvlNode p = root.right;
        root.right = p.left;
        p.left = root;
        root.height = Math.max(height(root.left),height(root.right))+1;
        p.height = Math.max(height(root),height(p.right))+1;
        return p;
    }

    private AvlNode rotateWithLeftNode(AvlNode root) {
        AvlNode p = root.left;
        root.left = p.right;
        p.right = root;
        root.height = Math.max(height(root.right),height(root.left))+1;
        p.height = Math.max(height(p.left),height(root))+1;
        return p;
    }

    private class AvlNode{

        AvlNode left;
        AvlNode right;
        int height;
        T element;

        public AvlNode(AvlNode left, AvlNode right, T element) {
            this.left = left;
            this.right = right;
            this.element = element;
            height = 0;
        }

    }

    public void print(){
        print(root);
    }
    private void print(AvlNode root){
        if (root == null)
            return;
        LinkedList<AvlNode> stack = new LinkedList<AvlNode>();
        stack.addLast(root);
        while (!stack.isEmpty()){
            AvlNode node = stack.removeFirst();
            if (node.left!=null)
                stack.addLast(node.left);
            if (node.right != null)
                stack.addLast(node.right);
            System.out.print(node.element+" ");
        }
    }
    private int height(AvlNode t){
        if (t == null)
            return -1;
        return t.height;
    }
}
