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
//==================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xMaker, int xVolume, int xColor) {
        //You should write here appropriate statements to complete this function.
        if (xMaker.charAt(0) == 'A') {
            return;
        }
        Node node = new Node(new Bottle(xMaker, xVolume, xColor));
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
        Bottle x, y, z;
        x = new Bottle("X", 1, 2);
        y = new Bottle("Y", 2, 3);
        z = new Bottle("Z", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node nx = new Node(x);
        Node ny = new Node(y);
        Node nz = new Node(z);
        Node temp = head.next;
        head.next = nx;
        nx.next = ny;
        ny.next = temp;
        insertPos(nz, 4);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void insertPos(Node nz, int pos) {
        int index = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (index == pos - 1) {
                Node temp = cur.next;
                cur.next = nz;
                nz.next = temp;
            }
            index++;
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
//        System.out.println(remove(findMaxColor()).info);
        insertIndex(remove(findMaxColor()), 1);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    int findMaxColor() {
        int max = head.info.color;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (max < cur.info.color) {
                max = cur.info.color;
            }
        }
        return max;
    }

    Node remove(int max) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.next.info.color == max) {
                Node temp = cur.next;
                cur.next =cur.next.next;
                return temp;
            }
        }
        return null;
    }

    void insertIndex(Node node, int index) {
        int pos = 0;
        Node cur = head;
        while (cur != null) {
            if (pos == index - 1) {
                Node temp = cur.next;
                cur.next = node;
                node.next = temp;
            }
            pos++;
            cur = cur.next;
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
        sort(0, changeColor(6));
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    int changeColor(int pos){
        int index = 0;
        for (Node cur = head; cur != null; cur = cur.next){
            if (index == pos - 1){
                cur.info.color = 88;
                break;
            }
            index++;
        }
        return index;
    }
    
    Node pos(int index){
        int count = 0;
        Node cur = head;
        while (cur != null){
            if (count == index) return cur;
            count++;
            cur = cur.next;
        }
        return null;
    }
    
    void sort(int k, int h){
        Node nk = pos(k);
        Node nh = pos(h+1);
        for (Node ci = nk; ci != nh; ci = ci.next){
            for (Node cj = ci.next; cj != nh; cj = cj.next){
                if (ci.info.color > cj.info.color){
                    Bottle temp = ci.info;
                    ci.info = cj.info;
                    cj.info = temp;
                }
            }
        }
    }

}
