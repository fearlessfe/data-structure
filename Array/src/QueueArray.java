public class QueueArray<T> implements Queue<T> {
    Array<T> array;

    public QueueArray(int capacity){
        array = new Array<>(capacity);
    }

    public QueueArray(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        try {
            array.addLast(e);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public T front() {
        try {
            return array.getFirst();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T dequeue() {
        try {
            return array.removeFirst();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i <array.getSize(); i++) {
            try {
                res.append(array.get(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] end");
        return res.toString();
    }

    public static void main(String[] args){
        QueueArray<Integer> queue = new QueueArray<>();
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
