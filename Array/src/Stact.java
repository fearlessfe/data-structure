public interface Stact<T> {
    int getSize();
    boolean isEmpty();
    void push(T e); //O(1)均摊
    T pop(); //O(1)
    T peek(); //O(1)
}
