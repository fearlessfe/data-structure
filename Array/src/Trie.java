import java.util.TreeMap;

public class Trie {
    private class Node{

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node (boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }

        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            res.append(next);
            return res.toString();
        }
    }

    public Node root;
    public int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }
    // 添加
    public void add(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size ++;
        }

    }
    // 查询
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prifix){
        Node cur = root;
        for(int i = 0; i < prifix.length(); i++){
            char c = prifix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.add("abc");
        trie.add("abd");
        System.out.println(trie.root.next);

    }
}
