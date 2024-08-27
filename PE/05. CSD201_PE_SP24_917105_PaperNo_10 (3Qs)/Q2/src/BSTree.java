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
    void insert(String xMaker, int xVolume, int xColor) {
        //You should insert here statements to complete this function
        if (xMaker.charAt(0) == 'A') {
            return;
        }
        Node node = new Node(new Bottle(xMaker, xVolume, xColor));
        if (isEmpty()) {
            root = node;
        }
        Node cur = root;
        Node par = null;
        while (cur != null) {
            if (cur.info.color == xColor) {
                return;
            }
            par = cur;
            if (cur.info.color > xColor) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (par.info.color > xColor) {
            par.left = node;
        } else {
            par.right = node;
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
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        preOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.volume < 7) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
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
        deleteByCopying(p);
        //------------------------------------------------------------------------------------
        postOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    Node p = null;
    int count = 0;

    void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        if (count == 5) {
            p = node;
        }
        count++;
    }

    public void deleteByCopying(Node node) {
        if (isEmpty()) {
            return;
        }
        Node cur = root, par = null;
        while (cur != null) {
            if (cur.info == node.info) {
                break;
            }
            par = cur;
            if (cur.info.color > node.info.color) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        //No child
        if (cur.left == null && cur.right == null) {
            if (par == null) {
                root = null;
                return;
            }
            if (par.left == cur) {
                par.left = null;
            } else {
                par.right = null;
            }
        }

        //1 child
        if (cur.left != null && cur.right == null) {
            if (par == null) {
                root = cur.left;
                return;
            }
            if (par.left == cur) {
                par.left = cur.left;
            } else {
                par.right = cur.left;
            }
        } else if (cur.left == null && cur.right != null) {
            if (par == null) {
                root = cur.right;
                return;
            }
            if (par.left == cur) {
                par.left = cur.right;
            } else {
                par.right = cur.right;
            }
        }

        //2 children
        if (node.left != null && node.right != null) {
            Node rightMost = node.left;
            while (rightMost.right != null) {
                par = rightMost;
                rightMost = rightMost.right;
            }
            node.info = rightMost.info;
            if (rightMost.right == null) {
                node.left = rightMost.left;
            } else {
                par.right = rightMost.left;
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
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        preOrder4(root);
        p4.info.volume = preOrder5(p4) + 100;

        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    Node p4 = null;
    int count4 = 0;

    void preOrder4(Node node) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            if (count4 == 2) {
                p4 = node;
            }
            count4++;
        }
        preOrder4(node.left);
        preOrder4(node.right);
    }

    int count5 = 0;

    int preOrder5(Node node) {
        if (node == null) {
            return 0;
        }
        count5++;
        preOrder5(node.left);
        preOrder5(node.right);
        return count5;
    }

}
