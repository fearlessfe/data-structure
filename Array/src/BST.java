import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
    // 添加元素
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

    public boolean contains(T e){
        return contains(root, e);
    }
    // 查询
    private  boolean contains(Node node, T e){
        if(node == null)
            return false;
        if(e.compareTo(node.e) == 0)
            return true;
         else if(e.compareTo(node.e) > 0)
            contains(node.right, e);
         else
            contains(node.left, e);
        return false;
    }

    // 遍历二分搜索树
    // 前序遍历，先访问节点，然后访问左右子树
    public  void preOrder(){
        preOrder(root);
    }
    // 前序遍历
    private void preOrder(Node node){
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);

        preOrder(node.right);

    }

    // 前序遍历的非递归写法，使用栈结构，先进右孩子，然后左孩子。深度优先
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    // 广度优先遍历，层序遍历,主要是为了查找
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }
    }
    // 二分搜索树中序遍历的结果是顺序的
    public void inOrder(){
        inOrder(root);
    }
    // 中序遍历
    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }

    public void postOrder(){
        postOrder(root);
    }
    // 中序遍历
    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    // 寻找二分搜索树的最小值和最大值
    public T minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is emoty");
        Node min = minimumNR(root);
        return min.e;
    }

    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node minimumNR(Node node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public T maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is emoty");
        Node max = maximumNR(root);
        return max.e;
    }

    private Node maximum(Node node){
        if(node.right == null)
            return node;
        return maximum(node.right);
    }

    private Node maximumNR(Node node){
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    // 删除二分搜索树的最大最小值
    public T removeMin(){
        T ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node righNode = node.right;
            node.right = null;
            size--;
            return righNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public T removeMax(){
        T ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(T e){
        root = remove(root, e);
    }

    private Node remove(Node node, T e){
        if(node == null)
            return null;
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
        } else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
        } else {
            // 左子树为空
            if(node.left == null){
                Node righNode = node.right;
                node.right = null;
                size--;
                return righNode;
            }
            // 右子树为空
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 寻找右子树最小值来替换

            //Node successor = minimum(node.right);
//            successor.right = removeMin(node.right);
//            successor.left = node.left;
//            node.left = node.right = null;
//            return successor;

            // 寻找左子树的最大值来替换
            Node successor = maximum(node.right);
            successor.left = removeMax(node.left);
            successor.right = node.right;
            node.left = node.right = null;
            return successor;
        }
        return node;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3,6,8,4,2};
        for (int num: nums){
            bst.add(num);
        }
        System.out.println(bst.minimum());
        System.out.println(bst.maximum());
        System.out.println();
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println(bst.toString());
        bst.inOrder();
        bst.postOrder();
    }

}
