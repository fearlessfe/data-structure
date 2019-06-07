public class LinkedList<T> {
    private class Node{
        public T e;
        public Node next;

        public Node(T e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(T e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public  LinkedList(){
        dummyHead = new Node(null, null );
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index, T e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed, Illegal index");
        Node prev = dummyHead;
        for (int i = 0; i < index; i ++)
            prev = prev.next;
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(T e){
        add(0, e);
    }

    public void addLast(T e){
        add(size, e);
    }

    public T get(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed, Illegal index");

        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }

    public T getFirst(){
        return get(0);
    }

    public T getLast(){
        return get(size - 1);
    }

    public void set(int index, T e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed, Illegal index");
        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++)
            cur = cur.next;

        cur.e = e;
    }

    public boolean contains(T e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public T remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed; index is illegal");
        Node prev = dummyHead;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size - 1);
    }


    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        linkedList.set(3, 8);
        System.out.println(linkedList);
        linkedList.remove(2);
        linkedList.removeFirst();
        System.out.println(linkedList);
    }

    // addLast  O(n)
    // addFirst O(1)
    // add O(n)
    // removeLast()  O(n)
    // removeFirst() O(1)
    // remove O(n)
    // 修改 O(n)
    // 查找 O(n)


}
