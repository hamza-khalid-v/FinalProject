package org.hamza;

import org.hamza.dto.Department;
import org.hamza.dto.SchoolManagementSystem;

/**
 * Main class with all callings
 */
public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem system = new SchoolManagementSystem();

        // adding departments
        system.addDepartment(new Department("CS"));
        system.addDepartment(new Department("Math"));
        system.addDepartment(new Department("Physics"));

        // adding students
        system.addStudent("Hamza", "Khalid", "D001");
        system.addStudent("Aaron", "Zaltan", "D001");
        system.addStudent("Anil", "Dimitri", "D002");

        // adding teachers
        system.addTeacher("Wang", "Yi", "D001");
        system.addTeacher("Johnson", "Joel", "D002");

        // adding courses
        system.addCourse("Introduction to Programming", 3.0,"D001");
        system.addCourse("Calculus", 4.0,"D002");

        // printing
        System.out.println("Departments: ");
        system.printDepartments();

        System.out.println("\nStudents: ");
        system.printStudents();

        System.out.println("\nTeachers: ");
        system.printTeachers();

        System.out.println("\nCourses: ");
        system.printCourses();

        // modifying teacher from a course
        system.modifyCourseTeacher("T001", "C001");

        // registering a student to a course
        system.registerStudentToCourse("S001", "C001");
        system.registerStudentToCourse("S002", "C001");
        system.registerStudentToCourse("S003", "C002");

        // printing modifications (does not work as intended)
        System.out.println("\nModified Courses: ");
        system.printCourses();
    }
}
