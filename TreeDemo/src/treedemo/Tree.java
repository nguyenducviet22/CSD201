/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedemo;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class Tree {
    Node root;

    public Tree() {
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    void insert(Car c){
        Node n = new Node(c);
        if (isEmpty()) root = n;
        else {
            Node cur = root;
            Node par = null;
            while (cur != null){
                if (cur.info.price == c.price){
                    System.out.println(c.price + " is existing.");
                    return;
                }
                par = cur;
                if (cur.info.price > c.price){
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            if (par.info.price > c.price){
                par.left = n;
            } else {
                par.right = n;
            }
        }
    }
    
    void visit(Node p){
        if (p == null) return;
        System.out.print(p.info + ", ");
    }
    
    void preOrder(Node p){
        if (p == null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    
    void preOrder(){
        preOrder(root);
    }
    
    void postOrder(Node p){
        if (p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    
    void postOrder(){
        postOrder(root);
    }
    
    void inOrder(Node p) {
        if (p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    
    void inOrder(){
        inOrder(root);
    }
    
    public Node findNode(int value){
        Node cur = root;
        while (cur != null){
            if (cur.info.price == value) return cur;
            if (cur.info.price > value) cur = cur.left;
            else cur = cur.right;
        }
        return null;
    }
    
    public Node findParentNode(int value){
        Node cur = root;
        Node par = null;
        while (cur != null){
            if (cur.info.price == value) return par;
            par = cur;
            if (cur.info.price > value){
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }
}
