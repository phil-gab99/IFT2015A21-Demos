package demo3;

public interface PositionalList<T> {
    int size();
    boolean isEmpty();
    Position<T> first();
    Position<T> last();
    Position<T> before(Position<T> p) throws IllegalArgumentException;
    Position<T> after(Position<T> p) throws IllegalArgumentException;
    Position<T> addFirst(T e);
    Position<T> addLast(T e);
    Position<T> addBefore(Position<T> p, T e) throws IllegalArgumentException;
    Position<T> addAfter(Position<T> p, T e) throws IllegalArgumentException;
    T set(Position<T> p, T e) throws IllegalArgumentException;
    T remove(Position<T> p, T e) throws IllegalArgumentException;
}