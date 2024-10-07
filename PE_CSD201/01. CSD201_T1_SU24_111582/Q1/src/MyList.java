/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xId, int xWeight, int xPrice) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (xWeight < 0 || xPrice < 0) {
            return;
        }
        Node b = head;
        while (b != null) {
            if (b.info.id.equalsIgnoreCase(xId)) {
                return;
            }
            b = b.next;
        }
        Phone p = new Phone(xId, xWeight, xPrice);
        Node node = new Node(p);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        //---------------------------------------------------------
    }

    //==================================================================
    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Node v = new Node(new Phone("New", 8, 9));
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        insertIndexNode(v, 2);
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void insertIndexNode(Node node, int pos) {
        int count = 0;
        Node p = head;
        while (count < pos - 1) {
            p = p.next;
            count++;
        }
        node.next = p.next;
        p.next = node;
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        int weight = maxWeight();
//        Node n = searchNode(weight);
//        removeNode(n);
        removeNode2(weight);
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    int maxWeight() {
        int max = 0;
        Node p = head;
        while (p != null) {
            if (p.info.weight > max) {
                max = p.info.weight;
            }
            p = p.next;
        }
        return max;
    }

    Node searchNode(int weight) {
        Node n = head;
        while (n != null) {
            if (n.info.weight == weight) {
                return n;
            }
            n = n.next;
        }
        return null;
    }

    void removeNode(Node n) {
        Node p = head;
        Node pre = null;
        while (p != null) {
            if (p == n) {
                break;
            }
            pre = p;
            p = p.next;
        }
        if (p == null) {
            return;
        } else {
            pre.next = p.next;
        }
        if (p.next == null) {
            tail = p;
        }
    }

    void removeNode(int weight) {
        Node p = head;
        while (p.next.info.weight != weight) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    void removeNode2(int weight) {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (p.next.info.weight == weight) {
                count++;
                if (count == 2) {
                    p.next = p.next.next;
                }
            }
            p = p.next;
        }
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        int c = countPhones(5);
        f.writeBytes(c + "");
        // hint: you should write a new function named countSomeThing() for this question,
        // then assign int k = this.countSomeThing()
        // finally, you just call f.writeBytes(k + "") to complete this question.
        //---------------------------------------------------------
        f.close();
    }

    int countPhones(int price) {
        int count = 0;
        Node node = head;
        while (node != null) {
            if (node.info.price > price) {
                count++;
            }
            node = node.next;
        }
        return count;
    }

//==================================================================
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        deleteFirst();
        sort();
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void deleteFirst() {
        head = head.next;
    }

    void sort() {
        for (Node ci = head; ci != null; ci = ci.next) {
            for (Node cj = ci.next; cj != null; cj = cj.next) {
                Phone temp;
                if (ci.info.weight < cj.info.weight) {
                    temp = ci.info;
                    ci.info = cj.info;
                    cj.info = temp;
                }
            }
        }
    }
}
