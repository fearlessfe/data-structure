import java.util.Random;

public class Main {
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

    public static void main(String[] args) throws IllegalAccessException {

        int opCount = 80000;

        QueueArray<Integer> queueArray = new QueueArray<>();
        double time1 = testQueue(queueArray, opCount);
        System.out.println("QueueArray time: " + time1 + "2");


        LoopQueue<Integer> queueLoop = new LoopQueue<>();
        double time2 = testQueue(queueLoop, opCount);
        System.out.println("QueueArray time: " + time2 + "2");


    }
}
