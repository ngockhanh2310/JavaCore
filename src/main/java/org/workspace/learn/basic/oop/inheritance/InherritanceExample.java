package org.workspace.learn.basic.oop.inheritance;

// Lớp cha (Parent class)
class Animal {
    void eat() {
        System.out.println("This animal eats food");
    }

    void sound(String sound) {
        System.out.println("This animal makes a sound : " + sound);
    }
}

// Lớp con (Child class)
class Dog extends Animal {
    void bark() {
        super.sound("Dog barks");
        System.out.println("Dog barks");
    }
}

public class InherritanceExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
        Animal animal = new Dog();
        animal.eat();
        // Dog dog2 = new Animal(); False - Error Compiler
    }
}
