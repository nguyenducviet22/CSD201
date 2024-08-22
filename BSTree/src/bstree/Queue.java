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
public class Queue {

    QueueNode head, tail;

    public Queue() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void enqueue(Node node) {
        QueueNode qn = new QueueNode(node);
        if (isEmpty()) {
            head = tail = qn;
        } else {
            tail.next = qn;
            tail = qn;
        }
    }

    Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node value = head.value;
        head = head.next;
        return value;
    }

}
