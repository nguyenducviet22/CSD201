/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstree;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class BSTree {

    Node root = new Node();

    public BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    public void insert(int x) {
        Node node = new Node(x);
        if (isEmpty()) {
            root = node;
            return;
        }
        Node cur = root, dad = null;
        while (cur != null) {
            if (cur.value == x) {
                return;
            }
            dad = cur;
            if (cur.value > x) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (dad.value > x) {
            dad.left = node;
        } else {
            dad.right = node;
        }
    }

    public void preOrder(Node p) {//???
        if (p == null) {
            return;
        }
        System.out.print(p.value + " ");
        preOrder(p.left);
        preOrder(p.right);
    }

    public void preOrder() {
        preOrder(root);
        System.out.println("");
    }

    public void breadthFirst() {
        if (root == null) {
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(root);
        Node cur;
        while (!queue.isEmpty()) {
            cur = queue.dequeue();
            if (cur.left != null) {
                queue.enqueue(cur.left);
            }
            if (cur.right != null) {
                queue.enqueue(cur.right);
            }
            System.out.print(cur.value + " ");
        }
        System.out.println("");
    }

    public void deleteByCopying(Node node) {
        Node rightMost = node.left, par = null;
        while (rightMost.right != null) {
            par = rightMost;
            rightMost = rightMost.right;
        }
        node.value = rightMost.value;
        if (rightMost.right == null) {
            node.left = rightMost.left;
        } else {
            par.right = rightMost.left;
        }
    }

    public Node searchParent(Node node) {
        if (node == null) {
            return null;
        }
        Node cur = root, par = null;
        while (cur != null && cur != node) {
            par = cur;
            if (cur.value > node.value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return par;
    }

    public void deleteByMerging(Node node) {
        Node rightMost = node.left, par = searchParent(node);
        while (rightMost != null) {
            rightMost = rightMost.right;
        }
        rightMost.right = node.right;
        if (par == null) {
            root = node.left;
        } else if (par.left == node) {
            par.left = node.left;
        } else {
            par.right = node.left;
        }
    }

    public void delete(Node node) {
        if (isEmpty()) {
            return;
        }
        Node cur = root, par = null;
        while (cur != null) {
            if (cur.value == node.value) {
                break;
            }
            par = cur;
            if (cur.value > node.value) {
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
        if (cur.left != null && cur.right == null){
            if (par == null){
                root = cur.left;
                return;
            }
            if (par.left == cur){
                par.left = cur.left;
            } else {
                par.right = cur.left;
            }
        } else if (cur.left == null && cur.right != null){
            if (par == null){
                root = cur.right;
                return;
            }
            if (par.left == cur){
                par.left = cur.right;
            } else {
                par.right = cur.right;
            }
        }
    }
    
    Node rotateLeft(Node node){
        if (node == null || node.right == null){
            return node;
        }
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    public static void main(String[] args) {
        BSTree bst = new BSTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(4);
        bst.insert(2);
        bst.insert(8);
        bst.insert(7);
        bst.insert(6);
        bst.insert(9);
        Node trNode = new Node(3);

        System.out.println("PreOrder Traversal: ");
        bst.preOrder();
        System.out.println("Breadth-First Traversal: ");
        bst.breadthFirst();
        System.out.println("Delete by copying: ");
        bst.deleteByCopying(bst.searchParent(trNode));
        System.out.println("Delete by merging: ");
        bst.deleteByMerging(trNode);
    }
}
