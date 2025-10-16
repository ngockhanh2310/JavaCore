package org.workspace.learn.basic.oop.abstraction;

abstract class Vehicle {
    public void startEngine() {
        System.out.println("Engine Started");
    }
}

class Car extends Vehicle {
    private String color;

    public Car(String color) {
        this.color = color;
    }

    public void printDetails() {
        System.out.println("Car color: " + this.color);
    }
}

public class Example {
    public static void main(String[] args) {
        Car car = new Car("red");
        car.startEngine();
        car.printDetails();
    }
}
