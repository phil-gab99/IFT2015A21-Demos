package demo2;

public class DequeStack<T> implements Stack<T> {
    private DoublyLinkedDeque<T> list;
    
    public DequeStack() {
        list = new DoublyLinkedDeque<T>();
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void push(T e) {
        list.addFirst(e);
    }
    
    public T top() {
        return list.first();
    }
    
    public T pop() {
        return list.removeFirst();
    }
}