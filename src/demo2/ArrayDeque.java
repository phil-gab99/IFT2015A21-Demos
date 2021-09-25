package demo2;

public class ArrayDeque<T> implements Deque<T> {
    private static final int DEFAULT_CAPACITY = 16; 
    
    private Object[] deque;
    private int n;
    private int first, last;
    
    public ArrayDeque() {
        deque = new Object[DEFAULT_CAPACITY];
        n = 0;
        first = DEFAULT_CAPACITY >> 1;
        last = DEFAULT_CAPACITY >> 1;
    }
    
    public int size() {
        return n;
    }
    
    public boolean isEmpty() {
        return n == 0;
    }
    
    public T first() {
        if (first == last) throw new DequeUnderflowException();
        return deque(first);
    }
    
    public T last() {
        if (first == last) throw new DequeUnderflowException();
        return deque(last);
    }
    
    public void addFirst(T e) {
        if (first == 0) {
            if (last == deque.length - 1) throw new DequeOverflowException();
            else {
                // Division entière
                int newFirst = (deque.length - 1 - last) >> 1;
                Object[] copy = new Object[deque.length];
                
                int bound = newFirst + n;
                for (int i = newFirst; i < bound; i++)
                    copy[i] = deque(first++);
                
                last += n - 1;
                deque = copy;
            }
        }
        deque[--first] = e;
        n++;
    }
    
    public void addLast(T e) {
        if (last == deque.length - 1) {
            if (first == 0) throw new DequeOverflowException();
            else {
                int newFirst = first >> 1;
                Object[] copy = new Object[deque.length];
                
                int bound = newFirst + n;
                for (int i = newFirst; i < bound; i++)
                    copy[i] = deque(first++);
                
                first = newFirst;
                last -= n + 1;
                deque = copy;
            }
        }
        deque[++last] = e;
        n++;
    }
    
    public T removeFirst() {
        if (first == last) throw new DequeUnderflowException();
        T e = deque(first);
        deque[first++] = null;
        n--;
        return e;
    }
    
    public T removeLast() {
        if (first == last) throw new DequeUnderflowException();
        T e = deque(last);
        deque[last--] = null;
        n--;
        return e;
    }
    
    @SuppressWarnings("unchecked")
    private T deque(int i) {
        return (T)deque[i];
    }
    
    static class DequeOverflowException extends RuntimeException {
        private DequeOverflowException() {
            super("Deque full");
        }
    }
    
    static class DequeUnderflowException extends RuntimeException {
        private DequeUnderflowException() {
            super("Deque empty");
        }
    }
}