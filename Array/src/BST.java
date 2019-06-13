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
        bst.preOrder();
        System.out.println();
        System.out.println(bst.toString());
        bst.inOrder();
        bst.postOrder();
    }

}
