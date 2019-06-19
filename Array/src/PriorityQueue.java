public class PriorityQueue<E extends Comparable<E>> implements Queue {
    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(Object e) {
        maxHeap.add((E)e);
    }

    @Override
    public E front() {
        return maxHeap.findMax();
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }
}
