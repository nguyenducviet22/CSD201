
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        BSTree t = new BSTree();
        Student student1 = new Student("S001", "John Doe", 2000, 3.5, "555-1234");
        Student student2 = new Student("S002", "Jane Smith", 1999, 3.8, "555-5678");
        Student student3 = new Student("S003", "Alex Johnson", 2001, 3.7, "555-1111");
        Student student4 = new Student("S004", "Emily Davis", 2002, 3.9, "555-2222");
        Student student5 = new Student("S005", "Michael Brown", 2000, 3.6, "555-3333");
        Student student6 = new Student("S006", "Sarah Wilson", 1998, 3.4, "555-4444");
        Student student7 = new Student("S007", "David Lee", 2001, 3.2, "555-5555");
        Student student8 = new Student("S008", "Chris Evans", 1999, 3.3, "555-6666");
        Student student9 = new Student("S009", "Rachel Green", 2002, 4.0, "555-7777");
        Student student10 = new Student("S010", "Monica Geller", 2000, 3.9, "555-8888");

        Node sn1 = new Node(student1);
        Node sn2 = new Node(student2);
        Node sn3 = new Node(student3);
        Node sn4 = new Node(student4);
        Node sn5 = new Node(student5);
        Node sn6 = new Node(student6);
        Node sn7 = new Node(student7);
        Node sn8 = new Node(student8);
        Node sn9 = new Node(student9);
        Node sn10 = new Node(student10);

        t.insert(sn6);
        t.insert(sn3);
        t.insert(sn7);
        t.insert(sn2);
        t.insert(sn9);
        t.insert(sn5);
        t.insert(sn1);
        t.insert(sn4);
        t.insert(sn8);
        t.insert(sn10);
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println(" 1. Insert a new student");
            System.out.println(" 2. Delete by stdID");
            System.out.println(" 3. Update new GPA");
            System.out.println(" 4. Upadte new phone");
            System.out.println(" 5. Print all students");
            System.out.println(" 0. Exit");
            System.out.print("    Your selection (0 -> 5): ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    t.insert();
                    t.print();
                    break;
                case 2:
                    t.delete();
                    t.print();
                    break;
                case 3:
                    t.updateGPA(sn6);
                    t.print();
                    break;
                case 4:
                    t.updatePhone();
                    t.print();
                    break;
                case 5:
                    t.print();
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        } while (choice == 0);

    }
}
