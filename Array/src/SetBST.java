public class SetBST<T extends Comparable<T>> implements Set<T> {
    private BST<T> bst;

    public SetBST(){
        bst = new BST<>();
    }

    @Override
    public void add(T e) {
        bst.add(e);
    }

    @Override
    public void remove(T e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(T e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }


    // 最坏的情况就是链表，最坏为O(n)
    // add    O(logn)  平均为logn
    // contains   O(logn) 平均为logn
    // remove    O(logn)  平均为logn
}
