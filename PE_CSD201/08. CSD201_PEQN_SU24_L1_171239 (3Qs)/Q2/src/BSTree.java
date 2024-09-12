/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xType, int xRate, int xWing) {
        //You should insert here statements to complete this function
        if (xType.charAt(0) == 'B') {
            return;
        }
        Node node = new Node(new Bird(xType, xRate, xWing));
        if (isEmpty()) {
            root = node;
            return;
        }
        Node p = root;
        Node f = null;
        while (p != null) {
            if (xWing == p.info.wing) {
                return;
            }
            f = p;
            if (xWing < p.info.wing) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (xWing < f.info.wing) {
            f.left = node;
        } else {
            f.right = node;
        }
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        breadth2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.info.rate > 4) {
                fvisit(r, f);
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

//=============================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        postOrder(root);
        deleteByCopying(findNode);
        //------------------------------------------------------------------------------------
        postOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    int count = 0;
    Node findNode = null;

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        count++;
        if (count == 5) {
            findNode = p;
        }
        return;
    }

    public void deleteByCopying(Node node) {
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node f = null;
        while (p != null) {
            if (p.info.wing == node.info.wing) {
                break;
            }
            f = p;
            if (p.info.wing > node.info.wing) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        //No child
        if (node.left == null && node.right == null) {
            if (f.left == node) {
                f.left = null;
            } else {
                f.right = null;
            }
        }

        //1 child
        if (node.left != null && node.right == null) {
            if (f == null){
                root = f.left;
                return;
            }
            if (f.left == node) {
                f.left = node.left;
            } else {
                f.right = node.left;
            }
        } else if (node.left == null && node.right != null) {
            if (f == null){
                root = f.right;
                return;
            }
            if (f.left == node) {
                f.left = node.right;
            } else {
                f.right = node.right;
            }
        }

        //2 children
        if (node.left != null && node.right != null) {
            f = null;
            Node rm = node.left;
            while (rm.right != null) {
                f = rm;
                rm = rm.right;
            }
            node.info = rm.info;
            if (f == null) {
                node.left = rm.left;
            } else {
                f.right = rm.left;
            }
        }

    }

//=============================================================
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        postOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}
