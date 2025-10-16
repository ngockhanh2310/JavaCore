package org.workspace.exercise.oop.lesson1;

import java.util.Scanner;

public class Student extends Person {
    private long id;
    private String school;
    private String classRoom;

    public Student() {
        super();
    }

    public Student(String name, long age, String address, long id, String school, String classRoom) {
        super(name, age, address);
        this.id = id;
        this.school = school;
        this.classRoom = classRoom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public void getInfo(Scanner scanner) {
        super.getInfo(scanner);
        System.out.print("Enter id: ");
        id = Long.parseLong(scanner.nextLine());
        System.out.print("Enter school: ");
        school = scanner.nextLine();
        System.out.print("Enter class room: ");
        classRoom = scanner.nextLine();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Id: " + id);
        System.out.println("School: " + school);
        System.out.println("Class room: " + classRoom);
    }
}
