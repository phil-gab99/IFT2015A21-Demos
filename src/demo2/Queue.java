package demo2;

/**
 * Expected behaviour of Queue data structure (FIFO).
 *
 * @param T Generic type within structure
 * @author Philippe Gabriel
 */
public interface Queue<T> {
    /**
     * Returns the number of elements within queue.
     *
     * @return Number of elements in queue
     */
    int size();
    
    /**
     * Checks whether the current queue structure is empty or not.
     *
     * @return <ul><li>{@code true} if the queue is empty,</li><li>{@code false}
     * otherwise</li></ul>
     */
    boolean isEmpty();
    
    /**
     * Adds an element at the end of the queue.
     *
     * @param t Element of the generic type to be added
     */
    void enqueue(T e);
    
    /**
     * Peeks at the first element of the queue without removing the element.
     *
     * @return Element at the top of the queue
     */
    T first();
    
    /**
     * Removes the element at the end of the queue.
     *
     * @return The removed element
     */
    T dequeue();
}