public interface Queue<T> {
    int getSize();
    boolean isEmpty();
    void enqueue(T e);  // O(1) 均摊
    T front(); // O(1)
    T dequeue(); // O(n)
}
