/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstree;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class BSTree {

    Node root = new Node();

    public BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    public void insert(int x) {
        Node node = new Node(x);
        if (isEmpty()) {
            root = node;
            return;
        }
        Node cur = root, dad = null;
        while (cur != null) {
            if (cur.value == x) {
                return;
            }
            dad = cur;
            if (cur.value > x) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (dad.value > x) {
            dad.left = node;
        } else {
            dad.right = node;
        }
    }
    
    public void preOrder(Node p){//???
        if (p == null) return;
        System.out.print(p.value + " ");
        preOrder(p.left);
        preOrder(p.right);
    }
    
    public void preOrder(){
        preOrder(root);
    }
    
    public void breadthFirst(){
        if (root == null) return;
        Queue queue = new Queue();
        queue.enqueue(root);
        Node cur;
        while (!queue.isEmpty()){
            cur = queue.dequeue();
            if (cur.left != null){
                queue.enqueue(cur.left);
            }
            if (cur.right != null){
                queue.enqueue(cur.right);
            }
            System.out.println(cur.value + " ");
        }
    }

    public static void main(String[] args) {
        BSTree bst = new BSTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(4);
        bst.insert(2);
        bst.insert(8);
        bst.insert(7);
        bst.insert(6);
        bst.insert(9);
        
        bst.preOrder();
    }
}
