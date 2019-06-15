public class SetLinkedList<T> implements Set<T> {

    private LinkedList<T> list;

    public SetLinkedList(){
        list = new LinkedList<>();
    }

    @Override
    public void add(T e) {
        if(!list.contains(e))
            list.addFirst(e);
    }

    @Override
    public void remove(T e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(T e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return list.toString();
    }

    public static void main(String[] args){
        SetLinkedList<Integer> setLinkedList = new SetLinkedList<>();
        for(int i = 0; i < 5; i++){
            setLinkedList.add(i);
        }
        for(int i = 0; i < 5; i++){
            setLinkedList.add(i);
        }

        System.out.println(setLinkedList.toString());
        setLinkedList.remove(2);
        System.out.println(setLinkedList.toString());
    }

    // add    O(n)  需要遍历元素是否存在
    // contains   O（n）
    // remove    O(n)
}
