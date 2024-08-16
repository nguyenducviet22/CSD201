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
public class TreeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(new Car("A", 3));
        t.insert(new Car("A", 5));
        t.insert(new Car("A", 1));
        t.insert(new Car("A", 2));
        t.insert(new Car("A", 8));
        t.insert(new Car("A", 3));
        System.out.print("PreOrder: ");
        t.preOrder();
        System.out.println("");
        System.out.print("PostOrder: ");
        t.postOrder();
        System.out.println("");
        System.out.print("InOrder: ");
        t.inOrder();
        System.out.println("");
        System.out.println("Parent node: " + t.findParentNode(1));
        System.out.println("Node: " + t.findNode(1));
    }
    
}
