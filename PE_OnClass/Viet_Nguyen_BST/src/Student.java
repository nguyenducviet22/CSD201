/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Student implements Comparable<Student> {

    private String stdID;
    private String stdName;
    private int yearOfBirth;
    private double gpa;
    private String phoneNumber;

    public Student() {
    }

    public Student(String stdID, String stdName, int yearOfBirth, double gpa, String phoneNumber) {
        this.stdID = stdID;
        this.stdName = stdName;
        this.yearOfBirth = yearOfBirth;
        this.gpa = gpa;
        this.phoneNumber = phoneNumber;
    }

    public String getStdID() {
        return stdID;
    }

    public void setStdID(String stdID) {
        this.stdID = stdID;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s",
                stdID, stdName, yearOfBirth, gpa, phoneNumber);
    }

    @Override
    public int compareTo(Student o) {
        return this.stdID.compareTo(o.stdID);
    }

}
