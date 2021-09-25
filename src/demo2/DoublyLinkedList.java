package demo2;

import java.util.NoSuchElementException;

/**
 * Doubly linked list implementation.
 *
 * @param Data Generic type of carried data
 * @author Philippe Gabriel
 */
 
public class DoublyLinkedList<Data> {
    private Node<Data> head;
    private Node<Data> tail;
    
    private int n;
    
    public DoublyLinkedList() {
        head = tail = null;
        n = 0;
    }
    
    public int size() {
        return n;
    }
    
    public boolean isEmpty() {
        return n == 0;
    }
    
    public Data getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.data;
    }
    
    public Data getLast() {
        if (tail == null) throw new NoSuchElementException();
        return tail.data;
    }
    
    public void addFirst(Data e) {
        head = new Node<Data>(null, e, head);
        if (tail == null) tail = head;
        n++;
    }
    
    public void addLast(Data e) {
        tail = new Node<Data>(tail, e, null);
        if (head == null) head = tail;
        n++;
    }
    
    public Data removeFirst() {
        if (head == null) throw new NoSuchElementException();
        Data first = head.data;
        Node<Data> temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null; // Avoid loitering
        n--;
        return first;
    }
    
    public Data removeLast() {
        if (tail == null) throw new NoSuchElementException();
        Data last = tail.data;
        Node<Data> temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        n--;
        return last;
    }
    
    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;
        
        private Node(Node<T> prev, T data, Node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}