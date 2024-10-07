/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Node {

    private Student info;
    private Node left, right;

    public Node() {
    }

    public Node(Student info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public Student getInfo() {
        return info;
    }

    public void setInfo(Student info) {
        this.info = info;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
