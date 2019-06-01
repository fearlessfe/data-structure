public class Array<T> {
    private  T[] data;
    private  int size;

    /**
     * @param capacity 初始容量
     */
    public Array(int capacity) {
        data = (T[])new Object[capacity];
        size = 0;
    }

    /**
     * 默认为10
     */
    public Array() {
        this(10);
    }
    // 获取数组元素个数
    public int getSize() {
        return size;
    }
    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }
    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    // 向数组末尾添加元素
    public void addLast(T e) throws IllegalAccessException {
        add(size, e);
    }
    // 向数组头添加元素
    public void addFirst(T e) throws IllegalAccessException {
        add(0, e);
    }
    // 在指定位置添加元素
    public void add(int index, T e) throws IllegalAccessException {
        if(size == data.length)
            resize(2 * data.length);

        if(index < 0 || index > size)
            throw new IllegalAccessException("Add failed. Require index >= 0 and index <= size");

        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    public T get(int index) throws IllegalAccessException {
        if(index < 0 || index >= size)
            throw new IllegalAccessException("Add failed. Require index >= 0 and index <= size");
        return data[index];
    }

    public void set(int index, T e) throws IllegalAccessException {
        if(index < 0 || index >= size)
            throw new IllegalAccessException("Add failed. Require index >= 0 and index <= size");
        data[index] = e;
    }
    // 查看数组中是否有元素e
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    public T remove(int index) throws IllegalAccessException {
        if(index < 0 || index >= size)
            throw new IllegalAccessException("Add failed. Require index >= 0 and index <= size");

        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;

        if(size == data.length / 2)
            resize(data.length / 2);
        return ret;
    }

    public T removeFirst(int index) throws IllegalAccessException {
        return remove(0);
    }

    public T removeLast(int index) throws IllegalAccessException {
        return remove(size - 1);
    }

    public void removeElement(T e) throws IllegalAccessException {
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1)
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity){
        T[] newData = (T[])new Object[newCapacity];
        for(int i = 0; i<size; i++)
            newData[i] = data[i];
        data = newData;
    }
}
