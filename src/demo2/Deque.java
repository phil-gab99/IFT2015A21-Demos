package demo2;

/**
 * Expected behaviour of Deque data structure.
 *
 * @param T Generic type within structure
 * @author Philippe Gabriel
 */
public interface Deque<T> {
    /**
     * Returns the number of elements within deque.
     *
     * @return Number of elements in deque
     */
    int size(); // -> size() Stack
    
    /**
     * Checks whether the current deque structure is empty or not.
     *
     * @return <ul><li>{@code true} if the deque is empty,</li><li>{@code false}
     * otherwise</li></ul>
     */
    boolean isEmpty(); // 
    
    /**
     * Peeks at the first element of the deque without removing it. 
     *
     * @return First element of deque
     */
    T first(); // top()
    
    /**
     * Peeks at the last element of the deque without removing it. 
     *
     * @return last element of deque
     */
    T last();
    
    /**
     * Inserts element at the beginning of the deque.
     *
     * @param e Element of generic type to be added
     * @return 
     */
    void addFirst(T e); // -> push(e)
    
    /**
     * Inserts element at the end of the deque.
     *
     * @param e Element of generic type to be added
     * @return 
     */
    void addLast(T e);
    
    /**
     * Removes the element at the beginning of the deque.
     *
     * @return The removed element
     */
    T removeFirst();
    
    /**
     * Removes the element at the end of the deque.
     *
     * @return The removed element
     */
    T removeLast();
}