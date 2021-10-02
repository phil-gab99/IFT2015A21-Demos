package demo3;

public class LinkedPositionalList<T> implements PositionalList<T> {
    
    private Node<T> header;
    private Node<T> trailer;
    private int size = 0;
    
    public LinkedPositionalList( ) {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }
    
    /**
     * Validates the position and returns it as a node.
     */
    private Node<T> validate(Position<T> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Invalid p");
        
        Node<T> node = (Node<T>) p;        
        if (node.next == null)
            throw new IllegalArgumentException("p is no longer in the list");

        return node;
    }
    
    /**
     * Returns the given node as a Position (or null, if it is a sentinel).
     */
    private Position<T> position(Node<T> node) {
        if (node == header || node == trailer) return null;
        return node;
    }
    
    /**
     * Adds element e to the linked list between the given nodes.
     */
    private Position<T> addBetween(E e, Node<T> pred, Node<T> succ) {
        Node<T> newest = new Node<>(e, pred, succ);
        pred.next = newest;
        succ.prev = newest;
        size++;
        return newest;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public Position<T> first() {
        return position(header.next);
    }
    
    @Override
    public Position<T> last() {
        return position(trailer.prev);
    }
    
    @Override
    public Position<T> before(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return position(node.prev);
    }
    
    @Override
    public Position<T> after(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return position(node.next);
    }
    
    @Override
    public Position<T> addFirst(E e) {
        return addBetween(e, header, header.next);
    }
    
    @Override
    public Position<T> addLast(E e) {
        return addBetween(e, trailer.prev, trailer);
    }
    
    @Override
    public Position<T> addBefore(Position<T> p, T e)
        throws IllegalArgumentException {
        Node<T> node = validate(p);
        return addBetween(e, node.prev, node);
    }
    
    @Override
    public Position<T> addAfter(Position<T> p, T e)
        throws IllegalArgumentException {
        Node<T> node = validate(p);
        return addBetween(e, node, node.next);
    }
    
    @Override
    public T set(Position<T> p, T e) throws IllegalArgumentException {
        Node<T> node = validate(p);
        T temp = node.element;
        node.element = e;
        return temp;
    }

    @Override
    public T remove(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        Node<T> pred = node.prev;
        Node<T> succ = node.next;
        pred.next = succ;
        succ.prev = pred;
        size--;
        
        T temp = node.element;
        // Avoid loitering
        node.element = null;
        node.next = null;
        node.prev = null;
        return temp;
    }
    
    public int indexOf(Position<T> p) {
        int i = 0;
        for (Position<T> q = first(); q != p && q != null; q = after(q)) i++;
        if (q == null) return -1;
        return i;
    }
    
    public Position<T> findPosition(T e) {
        for (Position<T> q = first(); q != null; q = after(q))
            if (q.getElement().equals(e)) return q;
        return null;
    }
    
    private static class Node<T> implements Position<T> {
        private T element;
        private Node<T> prev;
        private Node<T> next;
        
        public Node(E element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
        
        @Override
        public T getElement() throws IllegalStateException {
            if (next == null)
                throw new IllegalStateException("Position no longer valid");
            return element;
        }
    }
}