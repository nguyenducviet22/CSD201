/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class LinkedList {

    Node head, tail;

    public LinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void addIndex(int value, int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addFirst(value);
        } else {
            Node cur = head;
            int pos = 0;
            while (cur != null) {
                if (index - 1 == pos) {
                    break;
                }
                cur = cur.next;
                pos++;
            }
            if (cur == null) {
                return;
            } else {
                Node node = new Node(value);
                node.next = cur.next;
                cur.next = node;
            }
        }
    }

    void delLast() {
        if (isEmpty()) {
            return;
        } else {
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
            tail = cur;
        }
    }

    int deleteLast() {
        int value = 0;
        if (isEmpty()) {
            return -1;
        } else {
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            value = cur.next.value;
            cur.next = null;
            tail = cur;
        }
        return value;
    }

    void delFirst() {
        if (isEmpty()) {
            return;
        } else {
            head = head.next;
        }
    }

    void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(5);
        ll.addFirst(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.addIndex(4, 3);
        System.out.println("List of numbers: ");
        ll.display();
        int x = ll.deleteLast();
        if (x == -1) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Deleted: " + x);
        }
        ll.display();

        ll.delLast();
        ll.delFirst();
        ll.display();
    }
}
