/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author ADMIN
 */
public class Recursion {

    /**
     * @param args the command line arguments
     */
    public static void sayHi(int count) {
        if (count < 5) {
            System.out.println("Hello");
            sayHi(count + 1);
        }
        return;
    }

    public static int Factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * Factorial(num - 1);
    }

    public static void main(String[] args) {
//        sayHi(0);
        System.out.println(Factorial(6));
    }

}
