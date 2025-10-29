package org.workspace.exercise.oop.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private int id;
    private String name;
    private int age;
    private String country;
    private String className;

    public Student(String name, int age, String country, String className) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.className = className;
    }

    public Student(int id, String name, int age, String country, String className) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.className = className;
    }

    public void display() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  ID: " + id);
        System.out.println("║  Name: " + name);
        System.out.println("║  Age: " + age);
        System.out.println("║  Country: " + country);
        System.out.println("║  Class: " + className);
        System.out.println("╚════════════════════════════════════════╝");
    }
}
