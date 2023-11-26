package org.hamza.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter

public class Student {
    private static final int MAX_STUDENT_COURSE_NUM = 5;
    private static int nextId = 1;

    private String fname;
    private String lname;
    private String id;
    private Department department;
    private Course[] courses;
    private int courseNum;

    public Student(String fname, String lname, Department department) {
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.id = String.format("S%03d", nextId++);
        this.courses = new Course[MAX_STUDENT_COURSE_NUM];
        this.courseNum = 0;
    }
    public void registerCourse(Course course) {
        if (courseNum < MAX_STUDENT_COURSE_NUM) {
            courses[courseNum++] = course;
        } else {
            System.out.println("Maximum number of courses reached for this student.");
        }
    }
    private String fullName() {
        return fname + " " + lname;
    }
}
