package tree.binary.avl;

/**
 * @author Ming
 * @date 2019-12-29
 */
public class AvlTree<K extends Comparable<K>, V> {

    private Node<K, V> root;

    private class Node<K, V>{
        public K k;
        public V v;
        public int height;
        public Node<K, V> leftNode;
        public Node<K, V> rightNode;

        public Node(K k, V v){
            this.k = k;
            this.v = v;
            this.height = 1;
        }
    }

    private int getHeight(Node<K, V> node){
        if (node == null) return 0;
        return node.height;
    }

    private int getBalanceFactor(Node node){
        if (node == null) return 0;
        return getHeight(node.leftNode) - getHeight(node.rightNode);
    }

    public void put(K k, V v){
        put(this.root, k, v);
    }

    public Node<K, V> put(Node<K, V> node, K k, V v){
        if (node == null){
            return new Node<>(k, v);
        }
        if (node.leftNode.k.compareTo(k) > 0)
            node.leftNode = put(node.leftNode, k, v);
        else if (node.rightNode.k.compareTo(k) < 0)
            node.rightNode = put(node.rightNode, k, v);
        else
            node.v = v;

        node.height = Math.max(node.leftNode.height, node.rightNode.height) + 1;
        int balanceFactor = getBalanceFactor(node);
        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.leftNode) >= 0)
            return rightRotate(node);
        //RR
        if (balanceFactor < -1 && getBalanceFactor(node.rightNode) <= 0)
            return leftRotate(node);
        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.leftNode) < 0){
            node.leftNode = leftRotate(node.leftNode);
            return rightRotate(node);
        }
        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.rightNode) > 0){
            node.rightNode = rightRotate(node.rightNode);
            return leftRotate(node);
        }

        return node;
    }

    /**
     *       Y                   x
     *      / \                /   \
     *     x  t4              z     y
     *    / \       ->       / \   / \
     *   z  t3              t1 t2 t3  t4
     *  / \
     * t1 t2
     * @param y
     */
    private Node<K, V> rightRotate(Node<K, V> y){
        Node<K, V> x = y.leftNode;
        Node<K, V> t3 = x.rightNode;

        x.rightNode = y;
        y.leftNode = t3;

        y.height = Math.max(getHeight(y.leftNode), getHeight(y.rightNode)) + 1;
        x.height = Math.max(getHeight(x.leftNode), getHeight(x.rightNode)) + 1;

        return x;
    }

    /**
     *       Y                   x
     *      / \                 / \
     *     t4  x              y    z
     *        / \     ->     / \   /\
     *      t3   z          t4 t3 t1 t2
     *          / \
     *        t1   t2
     * @param y
     */
    private Node<K, V> leftRotate(Node<K, V> y){
        Node<K, V> x = y.rightNode;
        Node<K, V> t3 = x.leftNode;

        x.leftNode = y;
        y.rightNode = t3;

        y.height = Math.max(getHeight(y.leftNode), getHeight(y.rightNode)) + 1;
        x.height = Math.max(getHeight(x.leftNode), getHeight(x.rightNode)) + 1;

        return x;
    }

}