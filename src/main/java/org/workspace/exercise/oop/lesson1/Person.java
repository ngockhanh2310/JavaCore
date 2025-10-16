package org.workspace.exercise.oop.lesson1;

import java.util.Scanner;

public class Person {
    private String name;
    private long age;
    private String address;

    public Person() {
    }

    public Person(String name, long age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void getInfo(Scanner scanner) {
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter age: ");
        age = Long.parseLong(scanner.nextLine());
        System.out.print("Enter address: ");
        address = scanner.nextLine();
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}
