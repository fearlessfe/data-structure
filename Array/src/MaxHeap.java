import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    // heapify  将任意数组整理成堆的形状
    // 1.将数组中的元素增加到堆中 O(nlogn)
    // 2.将数组看为一颗完全二叉树，将最后一个非叶子节点(最后一个节点的父节点)，执行siftDown方法 O(n)
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }


    // 寻找父节点
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(E e){
        try {
            data.addLast(e);
            siftUp(data.getSize() - 1);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    private void siftUp(int k){
        try {
            while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
                data.swap(k, parent(k));
                k = parent(k);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public E findMax(){
        try {
            if (data.isEmpty())
                throw new IllegalArgumentException("Array is empty");
            return data.get(0);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        try {
            data.removeLast();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            try {
                if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                    j = rightChild(k);
                if(data.get(k).compareTo(data.get(j)) >= 0)
                    break;
                data.swap(k, j);
                k = j;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    // replace  取出最大元素，然后放入一个新的元素；
    public E replace(E e){
        E ret = findMax();
        try {
            data.set(0, e);
            siftDown(0);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0; i < n; i++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        int[] arr = new int[n];

        for (int i = 1; i < n; i++){
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        }

        System.out.println("Test completed");
    }
}
