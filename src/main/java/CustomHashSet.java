public class CustomHashSet<T> {
    private Object[] table;
    private int size;

    public CustomHashSet() {
        table = new Object[16];
        size = 0;
    }

    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }
        if (size >= table.length) {
            resize();
        }

        int index = hash(element);

        while (table[index] != null) {
            index = (index + 1) % table.length;
        }

        table[index] = element;
        size++;
        return true;
    }

    public boolean remove(T element) {
        int index = hash(element);
        while (table[index] != null) {
            if (table[index].equals(element)) {
                table[index] = null;
                size--;
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }

    public boolean contains(T element) {
        int index = hash(element);
        while (table[index] != null) {
            if (table[index].equals(element)) {
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    private void resize() {
        Object[] oldTable = table;
        table = new Object[oldTable.length * 2];
        size = 0;
        for (Object element : oldTable) {
            if (element != null) {
                add((T) element);
            }
        }
    }

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
