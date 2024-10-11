
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class BSTree {

    Node root;
    Scanner sc = new Scanner(System.in);

    public BSTree() {
        root = null;
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    void insert(Node node) {
        if (isEmpty()) {
            root = node;
        }
        Node p = root, f = null;
        while (p != null) {
            if (p.getInfo().getStdID().compareTo(node.getInfo().getStdID()) == 0) {
                return;
            }
            f = p;
            if (p.getInfo().getStdID().compareTo(node.getInfo().getStdID()) > 0) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }
        if (f.getInfo().getStdID().compareTo(node.getInfo().getStdID()) > 0) {
            f.setLeft(node);
        } else {
            f.setRight(node);
        }
    }

    void insert() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Year of Birth: ");
        String yob = sc.nextLine();
        System.out.print("Enter GPA: ");
        String gpa = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String ID = sc.nextLine();

        Student s = new Student(id, name, Integer.parseInt(yob), Double.parseDouble(gpa), name);
        Node sn = new Node(s);

        if (isEmpty()) {
            root = sn;
        }
        Node p = root, f = null;
        while (p != null) {
            if (p.getInfo().getStdID().compareTo(id) == 0) {
                return;
            }
            f = p;
            if (p.getInfo().getStdID().compareTo(id) > 0) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }
        if (f.getInfo().getStdID().compareTo(id) > 0) {
            f.setLeft(sn);
        } else {
            f.setRight(sn);
        }
    }

    void delete() {
        System.out.print("Enter ID to delete: ");
        String id = sc.nextLine();

        if (isEmpty()) {
            return;
        }
        Node p = root, f = null;
        while (p != null) {
            if (p.getInfo().getStdID().compareTo(id) == 0) {
                break;
            }
            f = p;
            if (p.getInfo().getStdID().compareTo(id) > 0) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }

        //No child
        if (p.getLeft() == null && p.getRight() == null) {
            if (f == null) {
                root = null;
                return;
            }
            if (f.getLeft() == p) {
                f.setLeft(null);
            } else {
                f.setRight(null);
            }
        }

        //1 child 
        //left child
        if (p.getLeft() != null && p.getRight() == null) {
            if (f == null) {
                root = null;
                return;
            }
            if (f.getLeft() == p) {
                f.setLeft(p.getLeft());
            } else {
                f.setRight(p.getLeft());
            }
            //right child
        } else if (p.getLeft() == null && p.getRight() != null) {
            if (f == null) {
                root = null;
                return;
            }
            if (f.getLeft() == p) {
                f.setLeft(p.getRight());
            } else {
                f.setRight(p.getRight());
            }
        }

        //2 children
        //delete by copying
        if (p.getLeft() != null && p.getRight() != null) {
            f = null;
            Node rmost = p.getLeft();
            while (rmost.getRight() != null) {
                f = rmost;
                rmost = rmost.getRight();
            }
            p.setInfo(rmost.getInfo());
            if (f == null) {
                p.setLeft(rmost.getLeft());
            } else {
                f.setRight(rmost.getLeft());
            }
        }
    }

    void updateGPA(Node node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            node.getInfo().setGpa(node.getInfo().getGpa() + 1);
        }
        updateGPA(node.getLeft());
        updateGPA(node.getRight());
    }

    void updatePhone() {
        System.out.print("Enter ID to update phone: ");
        String id = sc.nextLine();

        if (isEmpty()) {
            return;
        }

        Node p = root, f = null;
        while (p != null) {
            if (p.getInfo().getStdID().compareTo(id) == 0) {
                System.out.print("Enter phone:");
                String phone = sc.nextLine();
                p.getInfo().setPhoneNumber(phone);
            }
            f = p;
            if (p.getInfo().getStdID().compareTo(id) > 0){
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }
    }

    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getInfo() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.println(node.getInfo() + " ");
        inOrder(node.getRight());
    }

    void print() {
        System.out.println("PreOrder List: ");
        preOrder(root);
        System.out.println("");
        System.out.println("InOrder List: ");
        inOrder(root);
    }

}
