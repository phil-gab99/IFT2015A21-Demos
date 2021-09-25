package demo2;

/**
 * Expected behaviour of Stack data structure (LIFO).
 *
 * @param T Generic type within structure
 * @author Philippe Gabriel
 */
public interface Stack<T> {
    /**
     * Returns the number of elements within stack.
     *
     * @return Number of elements in stack
     */
    int size();
    
    /**
     * Checks whether the current stack structure is empty or not.
     *
     * @return <ul><li>{@code true} if the stack is empty,</li><li>{@code false}
     * otherwise</li></ul>
     */
    boolean isEmpty();
    
    /**
     * Adds an element at the top of the stack.
     *
     * @param t Element of the generic type to be added
     */
    void push(T e);
    
    /**
     * Peeks at the top of the stack without removing the element.
     *
     * @return Element at the top of the stack
     */
    T top();
    
    /**
     * Removes the element at the top of the stack.
     *
     * @return The removed element
     */
    T pop();
}