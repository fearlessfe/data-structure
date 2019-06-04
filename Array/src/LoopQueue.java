import java.util.Objects;

public class LoopQueue<T> implements Queue<T> {
    private T[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){
        data = (T[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(T e) {
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public T front() {
        if(isEmpty()) {
            try {
                throw new IllegalAccessException("Qequeue is empty");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data[front];
    }

    @Override
    public T dequeue() {
        if(isEmpty()) {
            try {
                throw new IllegalAccessException("Cannot dequeue from an empty queue");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        T ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    private void resize(int newCapacity){
        T[] newData = (T[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++){
            newData[i] = data[(front + i) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if((i+1) % data.length !=  tail)
                res.append(',');
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0; i < 10; i++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
