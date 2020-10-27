package datastructure.st;

import datastructure.OrderedST;

/**
 * 最优的查找和空间需求
 * 较慢的插入(扩容)
 * @link Bi
 */
public class OrderArrayST<K extends Comparable<K>,V> implements OrderedST<K,V> {

    private static final int DEFAULT_CAPACITY = 16;

    private Node[] table;

    private int size;

    private class Node{
        K key;
        V value;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    public OrderArrayST(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public OrderArrayST(int capacity) {
        table = (Node[]) new Object[capacity];
    }

    @Override
    public K min() {
        return table[0].key;
    }

    @Override
    public K max() {
        if (size() > 0)
            return table[size - 1].key;
        return null;
    }

    @Override
    public K floor(K key) {
        if (size() > 0) {
            int index = get(key,0,size() -1);
            if (index > 0)
                return table[index - 1].key;
        }
        return null;
    }

    @Override
    public K ceiling(K key) {
        if (size() > 0) {
            int index = get(key,0,size() -1);
            if (index != -1)
                return table[index + 1].key;
        }
        return null;
    }

    @Override
    public int rank(K key) {
        if (size() > 0){
            int index = get(key,0,size() -1 );
            if (index != -1)
                return index + 1;
        }
        return -1;
    }

    @Override
    public K select(int index) {
        return null;
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {
        return null;
    }

    @Override
    public void put(K key, V value) {
        // 定位

        // 后移

        // 扩容？
    }

    @Override
    public V get(K key) {
        if (size() > 0 && key != null){
            int index;
            if ((index = get(key,0,size() - 1)) != -1)
                return table[index].value;
        }
        return null;
    }

    /**
     * @return 返回 key 所在的下标，没有则返回 -1
     */
    private int get(K key,int lo,int hi){
        if (hi < lo || key == null) return -1;
        Node node;
        while (hi >= lo) {
            int mid = lo + (hi - lo) >> 1;
            node = table[mid];
            int res = node.key.compareTo(key);
            if (res > 0) {
                hi = mid - 1;
            }
            else if (res < 0) {
                lo = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    @Override
    public void delete(K key) {
        // 定位

        // 前移
    }

    @Override
    public boolean contains(K key) {
        if (get(key,0,size()-1) != -1)
            return true;
        else
            return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
