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
public class DataNode {
    private int info;
    private DataNode next;

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public DataNode getNext() {
        return next;
    }

    public void setNext(DataNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "DataNode{" + "info=" + info + '}';
    }
    
    
}
