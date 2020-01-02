package tree.binary.rbtree;


import java.util.HashMap;

/**
 * @author Ming
 * @date 2019-12-31
 */
public class RedBlackTree<K extends Comparable,V> {

    private static final boolean RED = true;
    private static final boolean BLEAK = false;

    private class Node<K, V>{
        public K k;
        public V v;
        public Node<K, V> leftChild, rightChild;
        boolean color;


        public Node(K k, V v){
            this.k = k;
            this.v = v;
            leftChild = null;
            rightChild = null;
            color = RED;
        }
    }

    private Node<K, V> root;
    private int size;

    private Node leftRotate(Node node){
        Node x = node.rightChild;
        node.rightChild = x.leftChild;
        x.leftChild = node;

        x.color = node.color;
        node.color = RED;

        return x;

    }

    public void add(K key, V value){
        this.root = add(this.root, key, value);
        this.root.color = BLEAK;
    }

    private Node<K ,V> add(Node<K, V> node,K key, V value){
        if (node == null){
            this.size ++;
            return new Node<>(key, value);
        }if (node.k.compareTo(key) > 0){
            node.leftChild = add(node.leftChild, key, value);
        } else if (node.k.compareTo(key) < 0){
            node.rightChild = add(node.rightChild, key, value);
        } else {
            node.v = value;
        }
        return node;
    }

    public static void main(String[] args) {
        System.out.println(2 << 1);
    }
}
