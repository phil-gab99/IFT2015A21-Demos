package demo1;

import java.util.Collection;

/**
 * Queue using an array implementation with some custom methods.
 *
 * @param T Generic type of queue
 * @author Philippe Gabriel
 */
public class MyQueue<T> {
    private static final int INIT_CAPACITY = 8;
    private int capacity;
    private Object[] queue;
    private int start;
    private int n;
    
    public MyQueue() {
        this(INIT_CAPACITY);
    }
    
    public MyQueue(int capacity) {
        this.capacity = capacity;
        start = n = 0;
        queue = new Object[capacity];
    }
    
    public MyQueue(Collection<T> collection) {
        this(INIT_CAPACITY);
        for (T e : collection) enqueue(e);
    }
    
    public void enqueue(T e) {
        if (n == queue.length) throw new OverflowException();
        int end = (start + n++) % queue.length; // Circular queue
        queue[end] = e;
    }
    
    public T dequeue() {
        if (isEmpty()) throw new UnderflowException();
        T e = queue(start);
        queue[start] = null;
        start = (start + 1) % queue.length; // Circular queue
        n--;
        return e;
    }
    
    public T first() {
        if (isEmpty()) throw new UnderflowException();
        return queue(start);
    }
    
    public boolean isEmpty() {
        return n == 0;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        int end = (start + n - 1) % queue.length;
        T e = null;
        int count = 0;
        
        for (int i = start; i < queue.length && (e = queue(i)) != null;
            i++, count ++)
            sb.append(e + ", ");
            
        if (e == null || count == capacity)
            return sb.substring(0, sb.length() -2) + "]";
        
        for (int i = 0; i < end; i++) {
            sb.append(queue(i) + ", ");
        }
        return sb.toString() + queue(end) + "]";
    }
    
    @SuppressWarnings("unchecked")
    private T queue(int i) {
        return (T)queue[i];
    }
    
    static class OverflowException extends RuntimeException {
        private OverflowException() {
            super("Queue is full");
        }
    }
    
    static class UnderflowException extends RuntimeException {
        private UnderflowException() {
            super("Queue is empty");
        }
    }
}