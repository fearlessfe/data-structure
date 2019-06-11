public class BST<T extends Comparable<T>> {
    private class Node{
        public T e;
        public Node left, right;

        public Node(T e){
            this.e = e;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
