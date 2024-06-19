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

        list.insertDataNode(5, 2);
        list.insertDataNode(15, 6);
        list.addTail(25);

//        list.deleteHead();
//        System.out.println("first node: " + list.delHead());
//        list.delHead();
//        list.deleteTail();
//        System.out.println("last node: " + list.delTail());
//        list.delTail();
//        list.delTail();
//        list.delTail();
        list.traverse();

//        DataNode p = list.searchInfo(10);
//        if (p != null) {
//            System.out.println("Found: " + p);
//        } else {
//            System.out.println("Not found");
//        }
        
        System.out.println(list.searchIndex(2).getInfo());
        
//        System.out.println("Delete: " + list.deleteDataNode(2));
//        list.traverse();
    }
}
