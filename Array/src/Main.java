public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        StackArray<Integer> stack = new StackArray<>();

        for (int i = 0; i < 5; i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());

    }
}
