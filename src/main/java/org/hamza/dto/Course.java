package org.hamza.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter

public class Course {
    private static final int MAX_STUDENT_NUM = 5;
    private static int nextId = 1;

    private double credit;
    private String id;
    private Student[] students;
    private Department department;
    private int studentNum;
    private Teacher teacher;
    private String courseName;

    public Course(String courseName, double credit, Department department) {
        this.id = String.format("C%03d", nextId++);
        this.courseName = courseName;
        this.credit = credit;
        this.department = department;
        this.students = new Student[MAX_STUDENT_NUM];
        this.studentNum = 0;
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void registerStudent(Student student) {
        if (studentNum < MAX_STUDENT_NUM) {
            students[studentNum++] = student;
        } else {
            System.out.println("Maximum number of students reached for this course.");
        }
    }
}
