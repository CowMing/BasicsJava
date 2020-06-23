package tree.trie;

import java.util.TreeMap;

/**
 * @author Ming
 * @date 2019-12-27
 */
public class Trie {

    private Node root;
    private int size;

    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(Boolean isWord){
            this.isWord = false;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    public Trie(){
        root = new Node();
        size = 0;
    }


    public void add(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            if (cur.next.get(word.charAt(i)) == null)
                return false;
            cur = cur.next.get(word.charAt(i));
        }
        return cur.isWord;
    }

    public static void main(String[] args) {
        System.out.println((12)%20);
    }
}
