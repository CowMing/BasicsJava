package tree.binary.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary Search Tree
 * @author Ming
 * @date 2019-12-21
 */
public class BinarySearchTree <E extends Comparable> {

    public Node<E> root;
    public int size;

    private class Node<E>{
        E e;
        Node<E> leftChild;
        Node<E> rightChild;

        public Node(E e){
            this.e = e;
        }
    }

    public E get(Node<E> n){
        return n.leftChild.e;
    }

    public void add(E e){
        root = add(root, e);
    }

    private Node<E> add(Node<E> node,E e){
        if ( node == null ) {
            size++;
            return new Node(e);
        }

        if ( node.e.compareTo(e) > 0 ) {
            node.leftChild = add(node.leftChild, e);
        } else if ( node.e.compareTo(e) < 0 ) {
            node.rightChild = add(node.rightChild, e);
        }

        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node<E> node, E e){
        if(node == null){
            return false;
        }
        if(node.e.compareTo(e) == 0) {
            return true;
        } else if (node.e.compareTo(e) > 0){
            return contains(node.leftChild, e);
        } else {
            return contains(node.rightChild, e);
        }
    }

    /* -----   PreorderTraverse begin     ----- */

    public void preorderTraverse(){
        preorderTraverse(root);
    }

    private void preorderTraverse(Node<E> node){
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preorderTraverse(node.leftChild);
        preorderTraverse(node.rightChild);
    }

    public void preorderNoRecursion(){
        Stack<Node<E>> stack = new Stack<>();
        stack.push(this.root);
        while(!stack.isEmpty()){
            Node<E> pop = stack.pop();
            System.out.println(pop.e);
            if(pop.rightChild != null)
                stack.push(pop.rightChild);
            if(pop.leftChild != null)
                stack.push(pop.leftChild);
        }
    }

    /* -----   PreorderTraverse end     ----- */

    /* -----   InorderTraverse begin     ----- */
    public void inorderTraverse(){
        inorderTraverse(root);
    }

    private void inorderTraverse(Node<E> node){
        if (node == null) {
            return;
        }
        inorderTraverse(node.leftChild);
        System.out.println(node.e);
        inorderTraverse(node.rightChild);
    }

    public void inorderNoRecursion(){
        Stack<Node<E>> stack = new Stack<>();
        Node<E> n = root;
        while(!stack.isEmpty() || n != null){
            while(n != null){
                stack.push(n);
                n = n.leftChild;
            }
            if(!stack.isEmpty()){
                Node<E> pop = stack.pop();
                System.out.println(pop.e);
                n = pop.rightChild;
            }
        }
    }

    /* -----   InorderTraverse end     ----- */

    /* -----   epilogueTraverse begin     ----- */
    public void epilogueTraverse(){
        epilogueTraverse(root);
    }

    private void epilogueTraverse(Node<E> node){
        if (node == null) {
            return;
        }
        epilogueTraverse(node.leftChild);
        epilogueTraverse(node.rightChild);
        System.out.println(node.e);
    }

    public void epilogueNoRecursion(){
        Queue<Node<E>> queue = new LinkedList<>();
        Stack<Node<E>> stack = new Stack<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<E> peek = queue.poll();
            if (peek.rightChild != null){
                queue.offer(peek.rightChild);
            }
            if(peek.leftChild != null){
                queue.offer(peek.leftChild);
            }
            stack.push(peek);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().e);
        }
    }
    /* -----   epilogueTraverse end     ----- */

    /* -----   levelTraverse begin     breadth traverse ----- */
    public void levelTraverse(){
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node<E> poll = queue.poll();
            System.out.println(poll.e);
            if(poll.leftChild != null){
                queue.offer(poll.leftChild);
            }
            if(poll.rightChild != null){
                queue.offer(poll.rightChild);
            }
        }
    }

    /**
     * [[1]]
     * [[1,2,3,4]]
     * [[1,2,3,4,5,6]]
     * 力扣上的层序解法
     * @return
     */
    public List<List<E>> levelTraverseByLeetCode(){
        List<List<E>> levels = new ArrayList<>();

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(this.root);
        int levelSize = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            levels.add(new ArrayList<>());

            for(int i = 0; i < size; i++){
                Node<E> poll = queue.poll();
                levels.get(levelSize).add(poll.e);

                if (poll.leftChild != null)
                    queue.offer(poll.leftChild);
                if(poll.rightChild != null)
                    queue.offer(poll.rightChild);
            }
            levelSize++;
        }
        return levels;
    }
    /* -----   levelTraverse end        ----- */

    /* -----   minNode begin            ----- */
    public Node<E> minNode(){
        if(this.root == null){
            throw new RuntimeException("no element");
        }
        return delMinNodeEle(this.root);
    }

    private Node<E> minNodeEle(Node<E> node){
        Stack<Node<E>> stack = new Stack<>();
        stack.push(node);
        Node<E> minNode;
        while(true){
            Node<E> pop = stack.pop();
            if (pop.leftChild == null) {
                minNode = pop;
                break;
            }
            stack.push(pop.leftChild);
        }
        return minNode;
    }

    public Node<E> delMinNodeEle(Node<E> node){
        Stack<Node<E>> stack = new Stack<>();
        stack.push(node);
        Node<E> minNode = node;
        while(true){
            Node<E> pop = stack.pop();
            if (pop.leftChild == null) {
                minNode.leftChild = pop.rightChild;
                size--;
                break;
            }
            stack.push(pop.leftChild);
            minNode = pop;
        }
        return minNode;
    }
    /* -----   minNode end        ----- */

    /* -----   maxNode begin      ----- */
    public E maxNode(){
        if(this.root == null){
            throw new RuntimeException("no element");
        }
        return maxNodeEle(this.root);
    }

    private E maxNodeEle(Node<E> node){
        Stack<Node<E>> stack = new Stack<>();

        stack.push(node);
        Node<E> maxNode;
        while(true){
            Node<E> pop = stack.pop();
            if(pop.rightChild == null){
                maxNode = pop;
                break;
            }
            stack.push(pop.rightChild);
        }
        return maxNode.e;
    }
    /* -----   maxNode end        ----- */

    /* -----   removeNode begin   ----- */
    public void removeNode(E e){
        if (this.root == null)
            throw new NullPointerException("you see see you");
        Stack<Node<E>> stack = new Stack<>();
        Node<E> par = null;
        stack.push(this.root);
        do {
            Node<E> node = stack.pop();
            int i = node.e.compareTo(e);
            if (i > 0){
                stack.push(node.leftChild);
            } else if (i < 0){
                stack.push(node.rightChild);
            } else {
                //判断是否根节点
                boolean flag = par == null ? true : false;
                if (flag){
                    if (node.rightChild == null){
                        this.root = node.leftChild;
                    } else {
                        Node<E> eNode = delMinNodeEle(node.rightChild);
                        eNode.leftChild = node.leftChild;
                        eNode.rightChild = eNode.e.compareTo(node.rightChild.e) == 0 ? null : node.rightChild;
                        this.root = eNode;
                        size--;
                    }
                    break;
                }

                if(node.leftChild == null){
                    if(par.e.compareTo(node.e) > 0)
                        par.leftChild = node.rightChild;
                    else
                        par.rightChild = node.rightChild;
                    size--;
                    break;
                }
                if (node.rightChild == null){
                    if(par.e.compareTo(node.e) > 0)
                        par.leftChild = node.leftChild;
                    else
                        par.rightChild = node.leftChild;
                    size--;
                    break;
                }

                Node<E> eNode = delMinNodeEle(node.rightChild);
                eNode.leftChild = node.leftChild;
                eNode.rightChild = eNode.e.compareTo(node.rightChild.e) == 0 ? null : node.rightChild;
                if(par.e.compareTo(node.e) > 0){
                    par.leftChild = eNode;
                } else {
                    par.rightChild = eNode;
                }
                break;
            }
            par = node;
        } while (!stack.isEmpty());
    }


    /* -----   removeNode end     ----- */



}
