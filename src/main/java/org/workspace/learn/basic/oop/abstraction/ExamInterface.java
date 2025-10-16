package org.workspace.learn.basic.oop.abstraction;

interface Person {
    public void info();
}

class Student implements Person {
    @Override
    public void info() {
        System.out.println("Student info");
    }

}

public class ExamInterface {
    public static void main(String[] args) {
        Student student = new Student();
        student.info();
    }
}
