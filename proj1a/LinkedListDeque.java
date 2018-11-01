public class LinkedListDeque<T> {
    private TNode sentinel;
    private int size;

    public class TNode {
        public TNode prev;
        public T item;
        public TNode next;

        private TNode(T i, TNode n, TNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }
    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new TNode(null, sentinel, sentinel);
        size = 0;
    }
    /** Creates an linked list deque with one item. */
    public LinkedListDeque(T item) {
        sentinel = new TNode(null, sentinel, sentinel);
        sentinel.next = new TNode(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (isEmpty()) {
            sentinel.next = new TNode(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
            size += 1;
        }
        else {
            sentinel.next = new TNode(item, sentinel.next, sentinel);
            sentinel.next.next.prev = sentinel.next;
            size += 1;
        }
    }
    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (isEmpty()) {
            sentinel.prev = new TNode(item, sentinel, sentinel);
            sentinel.next = sentinel.prev;
            size =+ 1;
        }
        else {
            sentinel.prev = new TNode(item, sentinel, sentinel.prev);
            sentinel.prev.prev.next = sentinel.prev;
            size += 1;
        }
    }
    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        TNode P = this.sentinel.next;
        while (P != sentinel) {
            System.out.print(P.item + " ");
            P = P.next;
        }
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        TNode first = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return first.item;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        TNode last = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return last.item;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        if (sentinel.next == sentinel) {
            return null;
        }
        TNode P = sentinel.next;
        int i = 0;
        while (i < index) {
            P = P.next;
            i++;
        }
        return P.item;
    }

    /**helper method for getRecursive*/
    private T getHelper(TNode P, int index) {
        if (index == 0) {
            return P.item;
        }
        else {
            return getHelper(P.next, index - 1);
        }
    }

    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        if (size == 0) {
            return null;
        }

        TNode P = sentinel.next;
        return getHelper(P, index);
    }


}