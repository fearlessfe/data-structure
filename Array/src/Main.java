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
        SetLinkedList<Integer> setLinkedList = new SetLinkedList<>();
        double time8 = testSet(setLinkedList, opCount);
        System.out.println("setLinkedList time: " + time8 + "2");


        SetBST<Integer> setBST = new SetBST<>();
        double time9 = testSet(setBST, opCount);
        System.out.println("setBST time: " + time9 + "2");

        // 二分搜索树和链表映射类性能测试
        MapLinkedList<Integer, Integer> mapLinkedList = new  MapLinkedList<>();
        double time10 = testMap(mapLinkedList, opCount);
        System.out.println("setLinkedList time: " + time10 + "2");


        MapBST<Integer, Integer> mapBST = new MapBST<>();
        double time11 = testMap(mapBST, opCount);
        System.out.println("setBST time: " + time11 + "2");

    }
}
