
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
        MyList list = new MyList();

        Motorbike m1 = new Motorbike("A", 4000000, 2020, "black", "Honda");
        Motorbike m2 = new Motorbike("B", 3000000, 2021, "red", "Honda");
        Motorbike m3 = new Motorbike("C", 2000000, 2022, "black", "Vision");
        Motorbike m4 = new Motorbike("D", 1000000, 2023, "blue", "Vision");

        Node n1 = new Node(m1);
        Node n2 = new Node(m2);
        Node n3 = new Node(m3);
        Node n4 = new Node(m4);

        list.addNode(n1);
        list.addNode(n2);
        list.addNode(n3);
        list.addNode(n4);

        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(" 1. Test addFirst");
            System.out.println(" 2. Test getPromotion");
            System.out.println(" 3. Test printBlacks");
            System.out.println(" 4. Test delete");
            System.out.println(" 5. Test sortAsc");
            System.out.println(" 0. Exit");
            System.out.print("Enter your selection: ");
            choice = sc.nextLine().trim();
            System.out.println("List: ");
            list.traverse();

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
                    System.out.print("Enter node branch: ");
                    String branch = sc.nextLine();

                    Motorbike m = new Motorbike(id, price, year, color, branch);
                    Node node = new Node(m);

                    list.addFirst(node);
                    System.out.println("Output: ");
                    list.traverse();
                    break;
                case "2":
                    list.getPromotion();
                    System.out.println("Output: ");
                    list.traverse();
                    break;
                case "3":
                    System.out.println("Output: ");
                    list.printBlacks();
                    break;
                case "4":
                    list.delete();
                    System.out.println("Output: ");
                    list.traverse();
                    break;
                case "5":
                    list.sortAsc();
                    System.out.println("Output: ");
                    list.traverse();
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
