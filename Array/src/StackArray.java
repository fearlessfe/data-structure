public class StackArray<T> implements Stact<T> {
    Array<T> array;

    public StackArray(int capacity){
        array = new Array<>(capacity);
    }

    public StackArray(){
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
    public void push(T e){
        try {
            array.addLast(e);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public T pop() {
        try {
            return array.removeLast();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T peek() {
        try {
            return array.getLast();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        for (int i = 0; i <array.getSize(); i++) {
            try {
                res.append(array.get(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
