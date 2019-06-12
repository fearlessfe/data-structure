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

    public void add(T e){
        if(root == null){
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private Node add(Node node, T e){
        // 递归终止条件
//        if(e.equals(node.e))
//            return;
//        else if(e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }
//        else if(e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
        if(node == null){
            size++;
            return new Node(e);
        }
        // 递归调用
        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }
}
