package datastructure;

public interface List<T> {

    T remove(int index);

    boolean contains(T t);

    T get(int index);

    void add(T t);

    boolean isEmpty();

    int size();
}
