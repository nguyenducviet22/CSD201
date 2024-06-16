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
public class LinkedList {
    private DataNode head;
    private DataNode tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public DataNode getHead() {
        return head;
    }

    public void setHead(DataNode head) {
        this.head = head;
    }

    public DataNode getTail() {
        return tail;
    }

    public void setTail(DataNode tail) {
        this.tail = tail;
    }
    
    public void addHead(int info){
        DataNode newNode = new DataNode();
        newNode.setInfo(info);       
        newNode.setNext(head);
        head = newNode;
        
        if (tail == null) {
            tail = newNode;
        }
    }
    
    public void addTail(int info){
        DataNode newNode = new DataNode();
        newNode.setInfo(info);
        tail.setNext(newNode);
        tail = newNode;
        
        if (head == null){
            head = newNode;
        }
    }
    
    public DataNode search(int searchedInfo){
        DataNode p = head;
        while (p != null){
            if (p.getInfo() == searchedInfo){
                return p;
            }
            p = p.getNext();
        }
        return p;
    }
    
    public void removeDataNode(int n){
        DataNode p = head;
        int i = 0;
        while(i < n-1 && p != null){
//            p.setNext(p);
            p = p.getNext();
            i++;
        }
        if (p != null){
            p = p.getNext();
        }
    }
    
    public void traverse(){
        DataNode p = head;
        while (p != null){
            System.out.println(p);
            p = p.getNext();
        }
    }
}
