package datastructure;

public interface Deque<T> {

    void pushRight(T t);

    void pushLeft(T t);

    T popRight();

    T popLeft();
}
