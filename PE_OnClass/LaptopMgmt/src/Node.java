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

    private Laptop info;
    private Node next;

    public Node() {
    }

    public Node(Laptop info) {
        this.info = info;
        next = null;
    }

    public Node(Laptop info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Laptop getInfo() {
        return info;
    }

    public void setInfo(Laptop info) {
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
                info.getID(), info.getPrice(), info.getYearOfProduct(), info.getColor(), info.getBrand());
    }

}
