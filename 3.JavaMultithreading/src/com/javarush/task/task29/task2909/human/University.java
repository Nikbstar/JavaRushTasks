package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student result = null;
        for (Student student : this.students) {
            if (student.getAverageGrade() == averageGrade) {
                result = student;
                break;
            }
        }
        return result;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student result = this.students.get(0);
        for (int i = 1; i < this.students.size(); i++) {
            if (this.students.get(i).getAverageGrade() > result.getAverageGrade()) {
                result = this.students.get(i);
            }
        }
        return result;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student result = this.students.get(0);
        for (int i = 1; i < this.students.size(); i++) {
            if (this.students.get(i).getAverageGrade() < result.getAverageGrade()) {
                result = this.students.get(i);
            }
        }
        return result;
    }

    public void expel(Student student) {
        this.students.remove(student);
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}