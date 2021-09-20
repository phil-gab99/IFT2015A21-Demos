package demo1;

import java.util.Collection;
import java.util.Iterator;

public class MyStack<T> implements Iterator<T> {
    private static final int INIT_CAPACITY = 8;
    private static final int ALPHA = 2;
    
    private Object[] stack;
    private int n;
    
    public MyStack() {
        this(INIT_CAPACITY);
    }
    
    public MyStack(int capacity) {
        n = 0;
        stack = new Object[INIT_CAPACITY];
    }
    
    public MyStack(Collection<T> collection) {
        this(INIT_CAPACITY);
        for (T e : collection) push(e);
    }
    
    public void push(T e) {
        if (n == stack.length) resize(ALPHA * stack.length);
        stack[n++] = e;
    }
    
    public T pop() {
        if (isEmpty()) throw new StackUnderflowException();
        T e = stack(n - 1);
        stack[n--] = null;
        
        if (n > 0 && n == stack.length / (2 * ALPHA))
            resize(stack.length / ALPHA);
        
        return e;
    }
    
    public T top() {
        if (isEmpty()) throw new StackUnderflowException();
        return stack(n - 1);
    }
    
    public boolean isEmpty() {
        return n == 0;
    }
    
    public int size() {
        return n;
    }
    
    public void clear() {
        while (hasNext()) pop();
    }
    
    public void recClear() {
        if (isEmpty()) return;
        pop();
        recClear();
    }
    
    public void rotate() {
        MyStack<T> copy = new MyStack<T>(n);
        for (int i = 0; i < n; i++) copy.stack[i + 1] = stack(i);
        copy.stack[0] = stack(n - 1); // Complete rotation
        this.stack = copy.stack;
    }
    
    private void resize(int capacity) {
        assert capacity >= n;
        
        Object[] copy = new Object[capacity];
        
        for (int i = 0; i < n; i++) {
            copy[i] = stack[i];
        }
        
        stack = copy;
    }
    
    public void transfer(MyStack<T> t) {
        while (hasNext()) t.push(pop());
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        
        for (int i = 0; i < n - 1; i++) {
            sb.append(stack(i) + ", ");
        }
        
        return sb.toString() + stack(n - 1) + "]";
    }
    
    @Override
    public boolean hasNext() {
        return n > 0;
    }
    
    public T next() {
        throw new UnsupportedOperationException();
    }
    
    @SuppressWarnings("unchecked")
    private T stack(int i) {
        return (T)stack[i];
    }
    
    
    static class StackUnderflowException extends RuntimeException {
        private StackUnderflowException() {
            super("Stack empty");
        }
    }
}