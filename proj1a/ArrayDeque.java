public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;


    /** Creates an empty array deque.*/
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    /** wraps pointers around to the other side of the list when they reach a boundary.*/
    public void wrap() {
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
         }
         if (nextFirst == items.length) {
             nextFirst = 0;
         }
        if (nextLast == items.length) {
            nextLast = 0;
         }
        if (nextLast == -1) {
            nextLast = items.length - 1;
         }
    }
    public int wrap(int index) {
        if (index == items.length) {
            return 0;
        }
        else {
            return index;
        }
    }
    /** doubles the size of the array if size == items.length and halves the size of the array if less than 25%
     * of the array is being used */
    public void resize() {

        if (size == items.length) {
            T[] newItems = (T []) new Object[size * 2];
            if (nextLast < nextFirst) {
                System.arraycopy(items, nextLast, newItems, 0, items.length);
            }
            else {
                System.arraycopy(items, nextLast, newItems, 0, items.length - nextLast);
                System.arraycopy(items, 0, newItems, items.length - nextLast, nextFirst + 1);
            }
            items = newItems;
            nextFirst = items.length - 1;
            nextLast = size;
        }
        if ((double)size / items.length < 0.25 && items.length > 8)  {
            T[] newItems = (T[]) new Object[items.length / 2];
            if (nextFirst < nextLast) {
                System.arraycopy(items, nextFirst + 1, newItems, 0, size);
            }
            else {
                if (nextFirst == items.length - 1) {
                    System.arraycopy(items, 0, newItems, 0, size);
                }
                else if (nextLast == 0) {
                    System.arraycopy(items, nextFirst + 1, newItems, 0, size);
                }
                else {
                    System.arraycopy(items, nextFirst + 1, newItems, 0, items.length - nextFirst - 1);
                    System.arraycopy(items, 0, newItems, items.length - nextFirst - 1, nextLast);
                }
            }
            items = newItems;
            nextFirst = items.length - 1;
            nextLast = size;

        }
    }

    /**Adds an item of type T to the front of the deque.*/
    public void addFirst (T item) {
        resize();
        items[nextFirst] = item;
        nextFirst -= 1;
        wrap();
        size += 1;
    }

    /**Adds an item of type T to the back of the deque.*/
    public void addLast(T item){
        resize();
        items[nextLast] = item;
        nextLast += 1;
        wrap();
        size += 1;
    }

    /**Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /** Returns the number of items in the deque.*/
    public int size(){
        return size;
    }

    /**Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque(){
        int idx = nextFirst + 1;
        while (idx != nextLast) {
            if (idx == items.length) {
                idx = 0;
            }
            System.out.print(items[idx] + " ");
            idx += 1;
        }
        System.out.println();
    }

    /**Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst(){
        nextFirst += 1;
        wrap();
        T pop = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        resize();
        return pop;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast() {
        nextLast -= 1;
        wrap();
        T pop = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        resize();
        return pop;
    }

    /**Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item
     * exists, returns null. Must not alter the deque! */
    public T get(int index) {
        resize();
        if (index > size - 1) {
            System.out.println("index cannot be larger than size of list");
            return null;
        }
        int i = nextFirst + 1;
        wrap(i);
        for(int j = 0; j < index; j++) {
            i++;
            i = wrap(i);
        }
        return items[i];
    }
}