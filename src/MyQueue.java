import java.util.Collection;

public class MyQueue<T> {
    private static final int INIT_CAPACITY = 8;
    
    private Object[] queue;
    private int start;
    private int n;
    
    public MyQueue() {
        this(INIT_CAPACITY);
    }
    
    public MyQueue(int capacity) {
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