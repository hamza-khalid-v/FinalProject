package org.hamza;

import org.hamza.dto.Department;
import org.hamza.dto.SchoolManagementSystem;

/**
 * Main class with all callings
 */
public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem system = new SchoolManagementSystem();
    // 1.
        // a. adding departments
        system.addDepartment(new Department("CS"));
        system.addDepartment(new Department("Math"));
        system.addDepartment(new Department("Physics"));
    // 2.
        // printing departments
        System.out.println("Departments: ");
        system.printDepartments();
    // 3.
        // a. adding students
        system.addStudent("Hamza", "Khalid", "D001");
        system.addStudent("Aaron", "Zoltan", "D001");
    // 4.
        // printing students
        System.out.println("\nStudents: ");
        system.printStudents();
    // 5.
        // a. adding teachers
        system.addTeacher("Wang", "Yi", "D001");
    // 6.
        // printing teachers
        System.out.println("\nTeachers: ");
        system.printTeachers();
    // 7.
        // a. adding courses
        system.addCourse("Intro to Programming", 3.0,"D001");
    // 8.
        // modifying teacher from a course
        system.modifyCourseTeacher("T001", "C001");
        system.printCourses();
    // 9.
        // registering a student to a course
        system.registerStudentToCourse("S001", "C001");
        system.registerStudentToCourse("S001", "C001"); // bonus
    }
}
