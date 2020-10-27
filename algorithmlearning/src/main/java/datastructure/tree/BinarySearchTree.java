package datastructure.tree;


public class BinarySearchTree<T extends Comparable<? super T>> {

    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T data) {
        return contains(data, root);
    }

    public void insert(T data) {
        root = insert(data, root);
     }

    public void remove(T data) {
        root = remove(data, root);
    }

    private TreeNode remove(T data, TreeNode root) {
        if (root == null)
            return null;
        int x = data.compareTo(root.data);
        if (x < 0) {
            root.left = remove(data, root.left);
        } else if (x > 0) {
            root.right = remove(data, root.right);
        } else if (root.left != null && root.right != null) {
            TreeNode p = root.right;
            while (p != null)
                p = p.left;
            root.data = p.data;
            root.right = remove(p.data, root.right);
        } else {
            root = (root.left == null ? root.right : root.left);
        }
        return root;
    }

    private TreeNode insert(T data, TreeNode r) {
        if (r == null) {
            r = new TreeNode(data, null, null);
            return r;
        }
        int x = data.compareTo(r.data);
        if (x > 0) {
            r.right = insert(data, r.right);
        } else if (x < 0) {
            r.left = insert(data, r.left);
        }
        return r;
    }

    private boolean contains(T data, TreeNode root) {
        if (root == null)
            return false;

        if (root.data.compareTo(data) == 0)
            return true;
        return contains(data, root.left) || contains(data, root.right);
    }

    class TreeNode {
        T data;
        TreeNode left;
        TreeNode right;

        public TreeNode(T data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
