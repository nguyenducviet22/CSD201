/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class MyStack {

    Node head, tail;

    public MyStack() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    public void addNode(Node node) {
        if (isEmpty()) {
            head = tail = node;
        }
        tail.setNext(node);
        tail = node;
    }

    public void add(Node node) {
        if (node.getInfo().getYearOfProduct() < 2020) {
            return;
        }
        if (isEmpty()) {
            head = node;
        }
        node.setNext(head);
        head = node;
    }

    void showYearDesc() {
        for (Node pi = head; pi != null; pi = pi.getNext()) {
            for (Node pj = pi.getNext(); pj != null; pj = pj.getNext()) {
                if (pi.getInfo().getYearOfProduct() < pj.getInfo().getYearOfProduct()) {
                    Laptop temp = pi.getInfo();
                    pi.setInfo(pj.getInfo());
                    pj.setInfo(temp);
                }
            }
        }
    }

    void showBlues() {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getColor().equals("blue")) {
                System.out.println(p);
            }
            p = p.getNext();
        }
    }

    void increasePrice() {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getBrand().equals("APPLE")) {
                double price = p.getInfo().getPrice() * 1.2;
                p.getInfo().setPrice(price);
            }
            p = p.getNext();
        }
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p);
            p = p.getNext();
        }
    }
}
