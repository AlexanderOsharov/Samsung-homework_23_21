import java.util.Iterator;
// The most interesting thing begins with the 68th line
public class MyArrayList<T extends Comparable<T>> implements Iterable<T> {
    // The most interesting thing begins with the 68th line
    private Object[] data;
    private int capacity; // real size
    private int size = 0; // fill size
    public int size() {
        return size;
    }
    // The most interesting thing begins with the 68th line
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }
    // The most interesting thing begins with the 68th line
    public MyArrayList() {
        this(10);
    }
    // The most interesting thing begins with the 68th line
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
        return (T) data[index];
    }
    // The most interesting thing begins with the 68th line
    public void set(int index, T value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
        data[index] = value;
    }
    // The most interesting thing begins with the 68th line
    public void add(T value) {
        if (capacity == size) {
            capacity *= 1.5;
            Object[] newData = new Object[capacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size] = value;
        ++size;
    }
    // The most interesting thing begins with the 68th line
    public Object[] getData() {
        return data;
    }
    // The most interesting thing begins with the 68th line
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[size - 1] = null;
        --size;
    }
    // The most interesting thing begins with the 68th line
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++){
            str += data[i] + " ";
        }
        return str;
    }
    // The most interesting thing begins with the 68th line
    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    // Homework
    public void addAll(MyArrayList data) {
        Object[] array = new Object[size + data.size()];

        System.arraycopy(this.data, 0, array, 0, size);
        System.arraycopy(data.getData(), 0, array, size, data.size());

        this.data = array;
        size += data.size();
    }
    public void addAll(int index, MyArrayList data) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index + " size: " + size);

        Object[] array = new Object[size + data.size()];

        System.arraycopy(this.data, 0, array, 0, index);
        System.arraycopy(data.getData(), 0, array, index, data.size());
        System.arraycopy(this.data, index, array, data.size() + index, size - index);

        this.data = array;
        size += data.size();
    }

    public boolean contains(T value){
        for (Object element : data) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T target) {
        for (int i = 0; i < size; i++){
            if (data[i] == target) return i;
        }

        return -1;
    }

    public int binarySearch(T target) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (data[mid] == target) {
                return mid;
            } else if (target.compareTo((T) data[mid]) > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // not found
    }


    private class MyArrayListIterator implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            return (T) data[cursor++]; // data[cursor]; cursor++;
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(cursor);
        }
    }

}
