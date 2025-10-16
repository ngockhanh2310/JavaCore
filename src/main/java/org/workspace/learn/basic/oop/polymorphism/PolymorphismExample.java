package org.workspace.learn.basic.oop.polymorphism;

class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Cat(); // Upcasting - Gán đối tượng Cat cho Animal

        a1.makeSound(); // Animal sound
        a2.makeSound(); // Cat sound (runtime polymorphism)
    }
}
