
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        MyStack ms = new MyStack();
        
        Laptop m1 = new Laptop("L01", 4000000, 2020, "red", "MSI");
        Laptop m2 = new Laptop("L02", 3000000, 2022, "blue", "ACER");
        Laptop m3 = new Laptop("L03", 2000000, 2021, "silver", "ASUS");
        Laptop m4 = new Laptop("L04", 1000000, 2023, "black", "APPLE");

        Node n1 = new Node(m1);
        Node n2 = new Node(m2);
        Node n3 = new Node(m3);
        Node n4 = new Node(m4);

        ms.addNode(n1);
        ms.addNode(n2);
        ms.addNode(n3);
        ms.addNode(n4);
        
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(" 1. Test add");
            System.out.println(" 2. Test show year desc");
            System.out.println(" 3. Test show blues");
            System.out.println(" 4. Test increase APPLE price");
            System.out.println(" 0. Exit");
            System.out.print("Enter your selection: ");
            choice = sc.nextLine().trim();
            System.out.println("List: ");
            ms.traverse();

            switch (choice) {
                case "1":
                    System.out.print("Enter node ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter node price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter node year: ");
                    int year = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter node color: ");
                    String color = sc.nextLine();
                    System.out.print("Enter node brand: ");
                    String brand = sc.nextLine();

                    Laptop m = new Laptop(id, price, year, color, brand);
                    Node node = new Node(m);

                    ms.add(node);
                    System.out.println("Output: ");
                    ms.traverse();
                    break;
                case "2":
                    ms.showYearDesc();
                    System.out.println("Output: ");
                    ms.traverse();
                    break;
                case "3":
                    System.out.println("Output: ");
                    ms.showBlues();
                    break;
                case "4":
                    ms.increasePrice();
                    System.out.println("Output: ");
                    ms.traverse();
                    break;
                case "0":
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }

        } while (!choice.equals("0"));
    }
}
