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

    void sort() {
        Node cur = head;
        while (cur != null) {
            Node index = cur.next;
            while (index != null) {
                if (cur.value > index.value) {
                    int temp = cur.value;
                    cur.value = index.value;
                    index.value = temp;
                }
                index = index.next;
            }
            cur = cur.next;
        }
    }

    void sortFirstKNodes(int k) {
        for (int i = 0; i < k - 1; i++) {
            int count = 0;
            for (Node cur = head; count < k - 1; cur = cur.next) {
                if (cur.value > cur.next.value) {
                    int temp = cur.value;
                    cur.value = cur.next.value;
                    cur.next.value = temp;
                }
                count++;
            }
        }
    }

    void sortLastKNodes(int k) {
        int startedIndex = size() - k;
        Node cur = head;
        for (int i = 0; i < size(); i++) {
            if (i < startedIndex && cur.next != null) {
                cur = cur.next;
            }
        }
        for (Node lastKNode = cur; lastKNode != null; lastKNode = lastKNode.next) {
            for (Node index = lastKNode.next; index != null; index = index.next) {
                if (lastKNode.value > index.value) {
                    int temp = lastKNode.value;
                    lastKNode.value = index.value;
                    index.value = temp;
                }
            }
        }
    }

    int size() {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

//    int getIndexByWhile(int value) {
//        int count = 0;
//        Node cur = head;
//        while (cur != null) {
//            if (cur.value == value) {
//                break;
//            }
//            count++;
//            cur = cur.next;
//        }
//        return count;
//    }
//
//    int getIndexByFor(int value) {
//        int count = 0;
//        for (Node cur = head; cur != null; cur = cur.next) {
//            if (cur.value == value) {
//                break;
//            } else count++;
//        }
//        return count;
//    }

    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return p;
            }
            i++;
            p = p.next;
        }
        return null;
    }

    void sortFromKToHByWhile(int k, int h) {
        if (k > h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        int n = size();
        if (h > n - 1) {
            h = n - 1;
        }
        Node u = pos(k);
        Node v = pos(h + 1);//???
        Node pi, pj;
        pi = u;
        while (pi != v) {
            pj = pi.next;
            while (pj != v) {
                if (pi.value > pj.value) {
                    int temp = pi.value;
                    pi.value = pj.value;
                    pj.value = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
    
    void sortFromKToHByFor(int k, int h){
        Node nk = pos(k);
        Node nh = pos(h+1);
        for (Node pi = nk; pi != nk; pi = pi.next){
            for(Node pj = nh; pj != nh; pj = pj.next){
                if (pi.value > pj.value){
                    int temp = pi.value;
                    pi.value = pj.value;
                    pj.value = temp;
                }
            }
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
        ll.addFirst(6);
        ll.addLast(2);
        ll.addLast(1);
        ll.addIndex(4, 3);
        ll.addLast(9);
        ll.addLast(7);
        ll.addLast(8);
        System.out.println("List of numbers: ");
        ll.display();
//        int x = ll.deleteLast();
//        if (x == -1) {
//            System.out.println("The list is empty.");
//        } else {
//            System.out.println("Deleted: " + x);
//        }
//        ll.display();
//
//        ll.delLast();
//        ll.delFirst();
//        ll.display();
//
//        ll.sort();;
//        ll.sortInSelection();
//        ll.sortInBubble();
//        System.out.println("Sorted list: ");
//        ll.display();
//        
//        ll.sortFirstKNodes(4);
//        System.out.println("Sorted list: ");
//        ll.display();
//
//        ll.sortLastKNodes(4);
//        System.out.println("Sorted list: ");
//        ll.display();
//
        ll.sortFromKToHByWhile(1, 7);
        System.out.println("Sorted list: ");
        ll.display();
        
        ll.sortFromKToHByFor(1, 7);
        System.out.println("Sorted list: ");
        ll.display();
    }
}
