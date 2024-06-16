/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistdemo;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class LinkedListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.addHead(10);
        list.addHead(20);
        list.addHead(30);
        
        list.addTail(40);
        list.addTail(50);
        
//        list.traverse();       
        DataNode p = list.search(10);
        if (p != null){
            System.out.println("Found: " + p);
        } else {
            System.out.println("Not found");
        }
        
        p = list.search(3);
        if (p != null){
            System.out.println("Found: " + p);
        } else {
            System.out.println("Not found");
        }
    }
    
}
