public class MapBST<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;


        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }

    }

    private Node root;
    private int size;

    public MapBST(){
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        if(root == null){
            root = new Node(key, value);
            size++;
        } else {
            add(root, key, value);
        }
    }

    // 添加元素
    private Node add(Node node, K key, V value){
        if(node == null){
            size++;
            return new Node(key, value);
        }
        // 递归调用
        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else
            node.value = value;

        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){
        if(node == null)
            return null;
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
        } else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
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
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exists");
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(Node node, K key){
        if(node == null)
            return null;
        if(key.compareTo(node.key) == 0)
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    public Node maximum(Node node){
        if(node.right == null)
            return node;
        return maximum(node.right);
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

    public static void main(String[] args) {
        Map<Integer, Integer> bst = new MapBST<>();
        int[] nums = {5, 3,6,8,4,2};
        for (int num: nums){
            bst.add(num, num);
        }
        System.out.println(bst.toString());

    }

    // 各项操作时间复杂度与Set一致
}
