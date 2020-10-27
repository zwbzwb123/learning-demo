package datastructure;

/*
 *  符号表
 */
public interface ST<K,V> {

    void put(K key,V value);

    V get(K key);

    void delete(K key);

    boolean contains(K key);

    boolean isEmpty();

    int size();

    Iterable<K> keys();
}
