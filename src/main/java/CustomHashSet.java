/**
 * A custom hash set implementation
 * @param <T> The type of the elements in the set
 */
public class CustomHashSet<T> {
    private Object[] table;
    private int size;

    /**
     * Create a new set
     */
    public CustomHashSet() {
        table = new Object[16];
        size = 0;
    }

    /**
     * Add an element to the set
     * @param element The element to add
     * @return True if the element was added, false if the element was already in the set
     */
    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }
        // Resize if the table is full
        if (size >= table.length) {
            resize();
        }

        int index = hash(element);

        // If index is already taken, find the next free index
        while (table[index] != null) {
            index = (index + 1) % table.length;
        }

        table[index] = element;
        size++;
        return true;
    }

    /**
     * Remove an element from the set
     * @param element The element to remove
     * @return True if the element was removed, false if the element was not in the set
     */
    public boolean remove(T element) {
        int index = hash(element);

        while (table[index] != null) {
            // If the element is found, remove it
            if (table[index].equals(element)) {
                table[index] = null;
                size--;
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }

    /**
     * Check if the set contains an element
     * @param element The element to check
     * @return True if the element is in the set, false if the element is not in the set
     */
    public boolean contains(T element) {
        int index = hash(element);

        while (table[index] != null) {
            // If the element is found, return true
            if (table[index].equals(element)) {
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }

    /**
     * Get the size of the set
     * @return The size of the set
     */
    public int getSize() {
        return size;
    }

    /**
     * Resize the set
     */
    private void resize() {
        Object[] oldTable = table;
        table = new Object[oldTable.length * 2];
        size = 0;

        // Rehash all elements
        for (Object element : oldTable) {
            if (element != null) {
                add((T) element);
            }
        }
    }

    /**
     * Hash an element
     * @param element The element to hash
     * @return The hash of the element
     */
    private int hash(T element) {
        return Math.abs(element.hashCode() % table.length);
    }

    // Code to test
    public static void main(String[] arr) {
        CustomHashSet<Integer> chs = new CustomHashSet<>();
        chs.add(6);
        chs.add(3);
        chs.add(0);
        chs.add(5);
    }
}
