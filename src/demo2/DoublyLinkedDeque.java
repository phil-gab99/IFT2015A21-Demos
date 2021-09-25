package demo2;

/**
 * Deque structure implementation using DoublyLinkedList.
 *
 * @param T Generic type of structure
 * @author Philippe Gabriel
 */
public class DoublyLinkedDeque<T> implements Deque<T> {
    private DoublyLinkedList<T> list;
    
    /**
     * Initializes list. 
     */
    public DoublyLinkedDeque() {
        list = new DoublyLinkedList<T>();
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public T first() {
        return list.getFirst();
    }
    
    public T last() {
        return list.getLast();
    }
    
    public void addFirst(T e) {
        list.addFirst(e);
    }
    
    public void addLast(T e) {
        list.addLast(e);
    }
    
    public T removeFirst() {
        return list.removeFirst();
    }
    
    public T removeLast() {
        return list.removeLast();
    }
}