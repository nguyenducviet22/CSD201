/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedemo;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class Node {

    Car info;
    Node left, right;

    public Node() {
    }

    public Node(Car info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public Node(String name, int price) {
        info = new Car(name, price);
        left = right = null;
    }

    @Override
    public String toString() {
        return "(" + info + ")";
    }
    
    
}

class Car {

    String name;
    int price;

    public Car() {
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + price + ")";
    }

}
