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
    void addLast(String xPlace, int xPrice, int xType) {
        //You should write here appropriate statements to complete this function.
        Brick b = new Brick(xPlace, xPrice, xType);
        Node n = new Node(b);
        if (xPlace.charAt(0) == 'A') {
            return;
        }
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
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
        Brick x, y, z;
        x = new Brick("X", 1, 2);
        y = new Brick("Y", 2, 3);
        z = new Brick("Z", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node nx = new Node(x);
        Node ny = new Node(y);
        Node nz = new Node(z);
        Node tmp = head.next;
        head.next = nx;
        nx.next = ny;
        ny.next = tmp;
        insertIndex(nz, 5);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void insertIndex(Node n, int pos) {
        Node cur = head;
        int index = 0;
        while (cur != null) {
            if (cur.next != null && index != pos - 1) {
                cur = cur.next;
                index++;
            }
        }
        Node tmp = cur.next;
        cur.next = n;
        n.next = tmp;
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
//        swap();
        Node n1 = searchNode("E");
        Node n2 = searchNode("G");
        swap(n1, n2);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    Node searchNode(String place) {
        Node c = head;
        while (c != null) {
            if (c.info.place.equals(place)) {
                return c;
            }
            c = c.next;
        }
        return null;
    }

    void swap(Node n1, Node n2) {
        Brick temp = n1.info;
        n1.info = n2.info;
        n2.info = temp;
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
        sort(0, 4);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    int findIndex(String place) {
        int index = 0;
        Node cur = head;
        while (cur != null) {
            if (cur.info.place.equals(place)) {
                break;
            }
            index++;
            cur = cur.next;
        }
        return index;
    }
    
    Node findNodeIndex(int k){
        int index = 0;
        Node cur = head;
        while (cur != null){
            if (index ==k){
                return cur;
            }
            index++;
            cur = cur.next;
        }
        return null;
    }
    
    void sort(int k, int h){
        Node u = findNodeIndex(k);
        Node v = findNodeIndex(h);
        Node pi = u;
        while (pi != v){
            Node pj = pi.next;
            while (pj != v){
                if (pi.info.type > pj.info.type){
                    Brick temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
}
