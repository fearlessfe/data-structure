public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merge;
    public SegmentTree(E[] arr, Merger<E> merge){
        this.merge = merge;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];

        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0,0, data.length - 1);
    }


    // 在treeIndex的位置创建表示区间[l, r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r){
        if (l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l , mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merge.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        return data[index];
    }

    // 区间查询[queryL, queryR]
    public E query(int queryL, int queryR){
        if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal");

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        if(l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        if(queryL >= mid + 1){
            return query(rightChildIndex, mid + 1, r, queryL, queryR);
        } else if(queryR <= mid){
            return query(leftChildIndex, l, mid, queryL, queryR);
        }
        E leftResult = query(leftChildIndex, l, mid, queryL, mid);
        E rightResult = query(rightChildIndex, mid + 1, r, mid + 1, queryR);
        return merge.merge(leftResult, rightResult);
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
            else
                res.append("]");

        }
        return res.toString();
    }
    public static void main(String[] args){
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> (a+b));
        System.out.println(segmentTree.toString());

        System.out.println(segmentTree.query(1,4));
    }
}
