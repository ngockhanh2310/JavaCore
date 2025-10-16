package org.workspace.learn.basic.oop.encapsulation;

class Person {
    // private field
    private String name;
    private long age;

    // getter and setter

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
        if (age > 0) this.age = age;
    }
}

public class EncapsulationExam {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Khánh");
        person.setAge(22);
        System.out.println("Name: " + person.getName() + " - " + "Age: " + person.getAge());
    }
}
