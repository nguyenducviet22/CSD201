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
    void addLast(String xOwner, int xColor, int xSize) {
        //You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'B') {
            return;
        }
        Node node = new Node(new Boat(xOwner, xColor, xSize));
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
        Boat x, y;
        x = new Boat("X", 1, 2);
        y = new Boat("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node nx = new Node(x);
        nx.next = head;
        head = nx;
        Node ny = new Node(y);
        insertIndex(ny, 2);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void insertIndex(Node node, int index) {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            if (cur.next != null && count == index - 1) {
                Node temp = cur.next;
                cur.next = node;
                node.next = temp;
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        remove(6);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void remove(int color) {
        int count = 0;
        Node pre = null;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.info.color < color) {
                count++;
                if (count == 2) {
                    if (pre == null) {
                        head = cur.next;
                    } else {
                        pre.next = cur.next;
                    }
                }
            } else {
                pre = cur;
            }
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
        sortFromHToK(3, 6);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    Node findNode(int index) {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            if (count == index) {
                return cur;
            }
            count++;
            cur = cur.next;
        }
        return null;
    }
    
    int size(){
        Node cur = head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    void sortFromHToK(int h, int k) {
        if (h > k) {
            return;
        }
        if (h < 0) {
            h = 0;
        }
        int n = size();
        if (k > n - 1){
            k = n - 1;
        }
        Node nh = findNode(h);
        Node nk = findNode(k + 1);
        for (Node ci = nh; ci != nk; ci = ci.next) {
            for (Node cj = ci.next; cj != nk; cj = cj.next) {
                if (ci.info.color > cj.info.color) {
                    Boat temp = ci.info;
                    ci.info = cj.info;
                    cj.info = temp;
                }
            }
        }
    }
}
