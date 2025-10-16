package org.workspace.learn.basic.oop;

class Car {
    // Field , Attribute ( Thuộc tính )
    String brand;
    short year;

    // Method
    void startEngine() {
        System.out.println(brand + " engine started!");
    }

    void showInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

public class ObjectExample {
    public static void main(String[] args) {
        //ObjectExample objectExample = new ObjectExample();
        // Create object
        Car car = new Car();
        car.brand = "Honda";
        car.year = 2018;
        car.startEngine();
        car.showInfo();
    }
}
