package demo3;

public interface Position<T> {
    /**
     * Returns the element stored at this position.
     *
     * @return the stored element
     * @throws IllegalStateException if position no longer valid
     */
    T getElement() throws IllegalStateException;
}