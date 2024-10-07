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
    void addLast(String xProducer, int xWeight, int xPrice) { //f1
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (xWeight > 0 && xPrice > 0) {
            Laptop l = new Laptop(xProducer, xWeight, xPrice);
            Node node = new Node(l);
            if (isEmpty()) {
                head = tail = node;
            }
            tail.next = node;
            tail = node;
        }
        //---------------------------------------------------------
    }

    //==================================================================
    //You do not need to edit this function. Your task is to complete the 
    //addLast function above only.
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
        Node v = new Node(new Laptop("V", 8, 9));
        Node w = new Node(new Laptop("W", 1, 7));
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        
	Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        
        insert(w, 1);
        insert(v, 2);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void insert(Node node, int pos) {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (count == pos - 1) {
                node.next = p.next;
                p.next = node;
            }
            p = p.next;
            count++;
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
        delete(findMaxNode());
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    Node findMaxNode(){
        int max = head.info.weight;
        Node node = null;
        Node p = head;
        while (p != null){
            if (max <= p.info.weight){
                max = p.info.weight;
                node = p;
            }
            p = p.next;
        }
        return node;
    }
    
    void delete(Node node){
        Node p = head;
        while (p != null){
            if (p.next == node){
                p.next = p.next.next;
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
        int k = count();
        f.writeBytes(k + "\r\n");
        //------------------------------------------------------------------------------------
        f.close();
    }
    
    int count(){
        Node p = head;
        int count = 0;
        while (p != null){
            count++;
            p = p.next;
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        
		Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        head = head.next;
        sort();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    void sort(){
        for (Node pi = head; pi != null; pi = pi.next){
            for (Node pj = pi; pj != null; pj = pj.next){
                if (pi.info.weight > pj.info.weight){
                    Laptop temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }

}
