package org.workspace.learn.basic.oop.abstraction;

abstract class Shape {
    // Abstract method - Phương thức trừu tượng
    abstract void draw();

    public void show() {
        System.out.println("kaka");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle - Vẽ hình tròn");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Rectangle - Vẽ hình chữ nhật");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();

        s1.draw();
        s2.draw();
    }
}
