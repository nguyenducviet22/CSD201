/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication177;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class JavaApplication177 {
    void a(int x) {
        if (x == 0) {
            return;
        }
        System.out.print(x + " ");
        System.out.print(x + "!" + " ");
        a(x - 1);
        
    }

    public static void main(String[] args) {
        JavaApplication177 j = new JavaApplication177();
        j.a(3);
    }
}
