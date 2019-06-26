import java.util.ArrayList;
import java.util.Random;

public class Main {
    //队列性能测试
    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++){
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    // 栈性能测试
    private static double testStack(Stack<Integer> q, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++){
            q.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++){
            q.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    // 集合性能测试
    private static double testSet(Set<Integer> q, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++){
            q.add(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++){
            q.remove(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    // 映射性能测试
    private static double testMap(Map<Integer, Integer> q, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++){
            q.add(random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++){
            q.remove(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    // 映射性能测试
    private static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();
        Random random = new Random();

        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else {
            maxHeap = new MaxHeap<>();
            for (int i = 0; i < testData.length; i++)
                maxHeap.add(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    // 并查集性能测试
    private static double testUF(UF uf, int m){
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for(int i = 0; i<m; i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        for(int i = 0; i<m; i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }



    public static void main(String[] args) throws IllegalAccessException {

        int opCount = 5000;

        // 数组队列，循环队列和链表队列性能比较

//        QueueArray<Integer> queueArray = new QueueArray<>();
//        double time1 = testQueue(queueArray, opCount);
//        System.out.println("QueueArray time: " + time1 + "2");
//
//
//        LoopQueue<Integer> queueLoop = new LoopQueue<>();
//        double time2 = testQueue(queueLoop, opCount);
//        System.out.println("LoopQueue time: " + time2 + "2");
//
//        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
//        double time5 = testQueue(linkedListQueue, opCount);
//        System.out.println("LinkedListQueue time: " + time5 + "2");


        // 数组栈和链表栈性能比较
//        StackArray<Integer> stackArray = new StackArray<>();
//        double time3 = testStack(stackArray, opCount);
//        System.out.println("StackArray time: " + time3 + "2");
//
//
//        StackLinkedList<Integer> stackLinkedList = new StackLinkedList<>();
//        double time4 = testStack(stackLinkedList, opCount);
//        System.out.println("StackLinkedList time: " + time4 + "2");

        // 测试二分搜索树删除功能
        //BST<Integer> bst = new BST<>();
//        Random random = new Random();
//        int n = 1000;
//
//        for(int i = 0; i < n; i++){
//            bst.add(random.nextInt(10000));
//        }
//
//        ArrayList<Integer> nums = new ArrayList<>();
//        while (!bst.isEmpty())
//            nums.add(bst.removeMax());
//
//        System.out.println(nums);


        // 二分搜索树和链表集合类性能测试
//        SetLinkedList<Integer> setLinkedList = new SetLinkedList<>();
//        double time8 = testSet(setLinkedList, opCount);
//        System.out.println("setLinkedList time: " + time8 + "2");
//
//
//        SetBST<Integer> setBST = new SetBST<>();
//        double time9 = testSet(setBST, opCount);
//        System.out.println("setBST time: " + time9 + "2");
//
//        // 二分搜索树和链表映射类性能测试
//        MapLinkedList<Integer, Integer> mapLinkedList = new  MapLinkedList<>();
//        double time10 = testMap(mapLinkedList, opCount);
//        System.out.println("setLinkedList time: " + time10 + "2");
//
//
//        MapBST<Integer, Integer> mapBST = new MapBST<>();
//        double time11 = testMap(mapBST, opCount);
//        System.out.println("setBST time: " + time11 + "2");
        // MaxHeap   heapify  和 add  性能测试
//        int n = 1000000;
//        Integer[] testData = new Integer[n];
//        Random random = new Random();
//        for (int i = 0; i< n; i++)
//            testData[i] = random.nextInt(Integer.MAX_VALUE);
//
//        // 二分搜索树和链表映射类性能测试
//        double time101 = testHeap(testData, true);
//        System.out.println("heapify time: " + time101 + "2");
//
//        double time102 = testHeap(testData, false);
//        System.out.println("add time: " + time102 + "2");


        int size = 10000000;
        int m = 10000000;
//        UnionFind1 uf1 = new UnionFind1(size);
//        System.out.println("UnionFind1 : " + testUF(uf1, m) + "s");
//        UnionFind2 uf2 = new UnionFind2(size);
//        System.out.println("UnionFind2 : " + testUF(uf2, m) + "s");
        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3 : " + testUF(uf3, m) + "s");
        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4 : " + testUF(uf4, m) + "s");
        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5 : " + testUF(uf5, m) + "s");
        UnionFind6 uf6 = new UnionFind6(size);
        System.out.println("UnionFind56 : " + testUF(uf6, m) + "s");
    }
}
