package org.hamza.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents a course for the school management system.
 * Each course has an id, name, credit value, assigned teacher and a
 * maximum number of students.
 *
 * @author Hamza Khalid
 */
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

    /**
     * Constructs a new Course with a given name, credit value, department and an id.
     *
     * @param courseName The name of the course.
     * @param credit The credit value of the course.
     * @param department The department to which the course is associated with.
     */
    public Course(String courseName, double credit, Department department) {
        this.id = String.format("C%03d", nextId++);
        this.courseName = courseName;
        this.credit = credit;
        this.department = department;
        this.students = new Student[MAX_STUDENT_NUM];
        this.studentNum = 0;
    }

    /**
     * Assigns a teacher to the course.
     *
     * @param teacher The teacher to be assigned to the course.
     */
    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Registers a student for the course.
     *
     * @param student The student to be registered for the course.
     */
    public void registerStudent(Student student) {
        if (studentNum < MAX_STUDENT_NUM) {
            students[studentNum++] = student;
        } else {
            System.out.println("Maximum number of students reached for this course.");
        }
    }
}
