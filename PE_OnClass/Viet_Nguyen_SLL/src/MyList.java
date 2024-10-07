
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addNode(Node node) {
        if (isEmpty()) {
            head = tail = node;
        }
        tail.setNext(node);
        tail = node;
    }

    void addFirst(Node node) {
        if (node.getInfo().getYearOfProduct() == 2022) {
            return;
        }
        if (isEmpty()) {
            head = tail = node;
        }
        node.setNext(head);
        head = node;

    }

    void getPromotion() {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getBranch().equals("Honda")) {
                double price = p.getInfo().getPrice() - 1050000;
                p.getInfo().setPrice(price);
            }
            p = p.getNext();
        }
    }

    void printBlacks() {
        Node p = head;
        while (p != null) {
            if (p.getInfo().getColor().equals("black")) {
                System.out.println(p);
            }
            p = p.getNext();
        }
    }

    void delete() {
        head = head.getNext().getNext().getNext();
    }

    void sortAsc() {
        for (Node pi = head; pi != null; pi = pi.getNext()) {
            for (Node pj = pi.getNext(); pj != null; pj = pj.getNext()) {
                if (pi.getInfo().getPrice() > pj.getInfo().getPrice()) {
                    Motorbike temp = pi.getInfo();
                    pi.setInfo(pj.getInfo());
                    pj.setInfo(temp);
                }
            }
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p);
            p = p.getNext();
        }
    }

}
