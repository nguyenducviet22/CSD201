/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.EmptyStackException;

/**
 *
 * @author ADMIN
 */
public class Stack {

    /**
     * @param args the command line arguments
     */
    private class Node {

        private int data;
        private Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int length;

    public Stack() {
        this.top = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node temp = top;
        top = top.next;
        length--;
        return temp.data;
    }

    public int peek() {
        return top.data;
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(12);
        s.push(15);
        s.push(17);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.peek());
    }

}
