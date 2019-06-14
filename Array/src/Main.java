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



    public static void main(String[] args) throws IllegalAccessException {

        int opCount = 10000;

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


//        StackArray<Integer> stackArray = new StackArray<>();
//        double time3 = testStack(stackArray, opCount);
//        System.out.println("StackArray time: " + time3 + "2");
//
//
//        StackLinkedList<Integer> stackLinkedList = new StackLinkedList<>();
//        double time4 = testStack(stackLinkedList, opCount);
//        System.out.println("StackLinkedList time: " + time4 + "2");

        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int n = 1000;

        for(int i = 0; i < n; i++){
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty())
            nums.add(bst.removeMax());

        System.out.println(nums);


    }
}
