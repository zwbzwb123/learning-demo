package datastructure;

public interface OrderedST<K extends Comparable<K>,V> extends ST<K,V> {

    K min();

    K max();

    K floor(K key); // 小于等于 key 的最大键

    K ceiling(K key); // 大于等于 key 的最小键

    int rank(K key); // 小于 key 的键的数量

    K select(int index); // 排名为 index 的 key

    Iterable<K> keys(K lo,K hi);

    default Iterable<K> keys(){
        return keys(min(),max());
    }

    default void deleteMin(){
        delete(min());
    }

    default void deleteMax(){
        delete(max());
    }

    default int size(K lo,K hi){
        if (hi.compareTo(lo) < 0)
            return 0;
        else if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }
}
