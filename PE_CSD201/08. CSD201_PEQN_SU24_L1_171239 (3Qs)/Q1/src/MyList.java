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
    void addLast(String xType, int xRate, int xWing) {
        //You should write here appropriate statements to complete this function.
        if (xType.charAt(0) == 'B') {
            return;
        }
        Node node = new Node(new Bird(xType, xRate, xWing));
        if (isEmpty()) {
            head = tail = node;
        }
        tail.next = node;
        tail = node;
    }

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
        Bird x, y;
        x = new Bird("X", 1, 2);
        y = new Bird("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node xn = new Node(x);
        Node yn = new Node(y);
        insert(xn, 3);
        insert(yn, 5);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void insert(Node node, int index) {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (count == index - 1) {
                Node temp = p.next;
                p.next = node;
                node.next = temp;
            }
            count++;
            p = p.next;
        }
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        findNode(6);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void findNode(int rate) {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (p.info.rate < 6) {
                count++;
                if (count == 2) {
                    p.info.wing = 99;
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        int maxRate = findMaxRate();
        int maxRateIndex = findMaxRateIndex(maxRate);
        sort(0, maxRateIndex);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    int findMaxRate() {
        Node p = head;
        int maxRate = p.info.rate;
        while (p != null) {
            if (p.info.rate > maxRate) {
                maxRate = p.info.rate;
            }
            p = p.next;
        }
        return maxRate;
    }

    int findMaxRateIndex(int maxRate) {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (p.info.rate == maxRate) {
                break;
            }
            count++;
            p = p.next;
        }
        return count;
    }

    Node pos(int index) {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (count == index) {
                return p;
            }
            count++;
            p = p.next;
        }
        return null;
    }

    void sort(int h, int k) {
        Node hn = pos(h);
        Node kn = pos(k);//??? k vs k+1
        for (Node pi = hn; pi != kn; pi = pi.next) {
            for (Node pj = pi.next; pj != kn; pj = pj.next) {
                if (pi.info.rate > pj.info.rate) {
                    Bird temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }
}
