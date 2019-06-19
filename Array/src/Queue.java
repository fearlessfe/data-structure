public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);  // O(1) 均摊
    E front(); // O(1)
    E dequeue(); // O(n)
}
