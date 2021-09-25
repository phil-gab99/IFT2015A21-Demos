package demo2;

public class DequeQueue<T> implements Queue<T> {
    private DoublyLinkedDeque<T> list;
    
    public DequeQueue() {
        list = new DoublyLinkedDeque<T>();
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void enqueue(T e) {
        list.addLast(e);
    }
    
    public T first() {
        return list.first();
    }
    
    public T dequeue() {
        return list.removeFirst();
    }
}