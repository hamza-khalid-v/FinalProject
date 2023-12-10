package org.hamza.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

/**
 * This class represents a student for the school management system.
 * Each student has an id, a first name, a last name, an associated department
 * and can register for up to 5 different courses.
 *
 * @author Hamza Khalid
 */
@EqualsAndHashCode
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

    /**
     * Constructs a new student with a given first name, last name, department and id.
     *
     * @param fname The first name of the student.
     * @param lname The last name of the student.
     * @param department The department to which the student is associated with.
     */
    public Student(String fname, String lname, Department department) {
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.id = String.format("S%03d", nextId++);
        this.courses = new Course[MAX_STUDENT_COURSE_NUM];
        this.courseNum = 0;
    }

    /**
     * Registers a course for the student.
     *
     * @param course The course to be registered.
     */
    public void registerCourseToStudent(Course course) {
        if (courseNum < MAX_STUDENT_COURSE_NUM) {
            courses[courseNum++] = course;
        } else {
            System.out.println("Maximum number of courses reached for this student.");
        }
    }

    /**
     * Private method to get the full name of the student
     *
     * @return The full name of the student.
     */
    private String fullName() {
        return fname + " " + lname;
    }

    /**
     * Returns a string representation of the student, the student's id,
     * full name, associated department, and registered courses.
     *
     * @return the representation of the student string.
     */
    @Override
    public String toString() {
        return "Student{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", id='" + id + '\'' +
                ", department=" + department +
                ", courses=" + Arrays.toString(courses) +
                ", courseNum=" + courseNum +
                '}';
    }
}
