/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Motorbike {

    private String ID;
    private double price;
    private int yearOfProduct;
    private String color;
    private String branch;

    public Motorbike() {
    }

    public Motorbike(String ID, double price, int yearOfProduct, String color, String branch) {
        this.ID = ID;
        this.price = price;
        this.yearOfProduct = yearOfProduct;
        this.color = color;
        this.branch = branch;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearOfProduct() {
        return yearOfProduct;
    }

    public void setYearOfProduct(int yearOfProduct) {
        this.yearOfProduct = yearOfProduct;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}
