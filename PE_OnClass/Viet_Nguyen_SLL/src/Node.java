/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Node {

    private Motorbike info;
    private Node next;

    public Node() {
    }

    public Node(Motorbike info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(Motorbike info) {
        this.info = info;
        next = null;
    }

    public Motorbike getInfo() {
        return info;
    }

    public void setInfo(Motorbike info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("%s, %.0f, %d, %s, %s",
                info.getID(), info.getPrice(), info.getYearOfProduct(), info.getColor(), info.getBranch());
    }

}
