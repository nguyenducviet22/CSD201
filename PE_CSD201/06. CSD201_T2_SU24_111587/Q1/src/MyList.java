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
    void addLast(String xPlace, int xWeight, int xColor) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (xWeight < 0) {
            return;
        }
        if (xColor < 3) {
            return;
        }
        Node node = new Node(new Car(xPlace, xWeight, xColor));
        if (isEmpty()) {
            head = tail = node;
        }
        tail.next = node;
        tail = node;
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
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        deleteNode(3);
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void deleteNode(int pos) {
        Node cur = head;
        int count = 1;
        while (cur != null) {
            if (cur.next != null && count == pos - 1) {
                Node temp = cur.next.next;
                cur.next = temp;
            }
            count++;
            cur = cur.next;
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
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        swapHeadTail();
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void swapHeadTail() {
        Node temp = new Node();
        temp.info = tail.info;
        tail.info = head.info;
        head.info = temp.info;
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
        delete(4);
        ftraverse(f);
        //---------------------------------------------------------
        f.close();
    }

    void delete(int weight) {
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            if (cur.info.weight < weight) {
                if (pre == null) {
                    head = cur.next;
                } else {
                    pre.next = cur.next;
                }
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
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
        head = head.next;
        sort();
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void sort() {
        Node ci = head;
        while (ci.next != null) {
            Node cj = ci.next;
            while (cj.next != null) {
                Car temp;
                if (ci.info.weight > cj.next.info.weight) {
                    temp = ci.info;
                    ci.info = cj.next.info;
                    cj.next.info = temp;
                }
                cj = cj.next;
            }
            ci = ci.next;
        }
    }

}
