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

    public void addHead(int info) {
        DataNode newNode = new DataNode();
        newNode.setInfo(info);
        newNode.setNext(head);
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
    }

    public void addTail(int info) {
        DataNode newNode = new DataNode();
        newNode.setInfo(info);
        tail.setNext(newNode);
        tail = newNode;

        if (head == null) {
            head = newNode;
        }
    }

    public void insertDataNode(int info, int index) {
        if (index == 0) {
            addHead(info);
        } else {
            DataNode p = head;
            int pos = 0;
            while (p != null) {
                if (index - 1 == pos) {
                    break;
                }
                p = p.getNext();
                pos++;
            }
            if (p == null) {
                return;
            } else {
                DataNode newNode = new DataNode();
                if (p.getNext() == null) {
                    addTail(info);
                } else {
                    newNode.setInfo(info);
                    newNode.setNext(p.getNext());
                    p.setNext(newNode);
                }
            }
        }
    }

    public DataNode searchFirstInfo(int searchedInfo) {
        DataNode p = head;
        while (p != null) {
            if (p.getInfo() == searchedInfo) {
                return p;
            }
            p = p.getNext();
        }
        return p;
    }
    
    public DataNode searchPreFirstInfo(int searchInfo) {
        DataNode p = head;
        while (p != null){
            if (p.getNext().getInfo() == searchInfo) break;
            p = p.getNext();
        }
        return p;
    }
    
//    public DataNode searchLastInfo(int searchedInfo);
//    public DataNode searchPreLastInfo(int searchedInfo);
    
    public DataNode searchIndex(int index){
        DataNode p = head;
        int pos = 0;
        while (p !=null){
            if (index == pos) break;
            p = p.getNext();
            pos++;
        }
        if (p == null){
            return null;
        }
        return p;
    }

    public DataNode searchPreIndex(int index) {
        DataNode p = head;
        int pos = 0;
        while (p != null) {
            if (index - 1 == pos) {
                break;
            }
            p = p.getNext();
            pos++;
        }
        if (p == null) {
            return null;
        }
        return p;
    }

    public void deleteHead() {
        head = head.getNext();
    }

    public int delHead() {
        int value = head.getInfo();
        head = head.getNext();
        return value;
    }

    public void deleteTail() {
        DataNode p = head;
        while (p.getNext() != tail) {
            p = p.getNext();
        }
        p.getNext().setNext(null);
        tail = p;
    }

    public int delTail() {
        DataNode p = head;
        while (p.getNext() != tail) {
            p = p.getNext();
        }
        int value = p.getNext().getInfo();
        p.getNext().setNext(null);
        tail = p;
        return value;
    }

    public int deleteDataNode(int index) {
        if (index < 0) {
            return -1;
        }
        if (index == 0) {
            return delHead();
        }
        DataNode p = searchPreIndex(index);
        if (p == null) {
            return -1;
        }
        if (p == tail) {
            return delTail();
        }
        int value = p.getNext().getInfo();
        p.setNext(p.getNext().getNext());
        return value;
    }
    
    public void sort(){
        if (head == tail) return;
        for (DataNode i = head; i != null; i = i.getNext()){
            for (DataNode j = i.getNext(); j != null; j = j.getNext()){
                if (i.getInfo() > j.getInfo()){
                    int tem = i.getInfo();
                    i.setInfo(j.getInfo());
                    j.setInfo(tem);
                }
            }
        }
    }

    public void traverse() {
        DataNode p = head;
        while (p != null) {
            System.out.println(p);
            p = p.getNext();
        }
    }
}
