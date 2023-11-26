package org.hamza.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a School Management System that manages departments, students, teachers, and courses.
 * The system has a maximum number for departments, students, teachers, and courses.
 * It provides methods to add departments, students, teachers, and courses to the system,
 * print information about departments, students, teachers, and courses,
 * and find departments, students, teachers, and courses by their id.
 * It also allows modifying the teacher of a course and registering students for courses.
 *
 * @author Hamza Khalid
 */
@EqualsAndHashCode
@ToString
@Getter
@Setter

public class SchoolManagementSystem {
    private static final int MAX_DEPARTMENT_NUM = 5;
    private static final int MAX_STUDENT_NUM = 200;
    private static final int MAX_TEACHER_NUM = 20;
    private static final int MAX_COURSE_NUM = 30;

    private Department[] departments;
    private Student[] students;
    private Teacher[] teachers;
    private Course[] courses;

    private int departmentIndex;
    private int studentIndex;
    private int teacherIndex;
    private int courseIndex;

    public SchoolManagementSystem() {
        this.departments = new Department[MAX_DEPARTMENT_NUM];
        this.students = new Student[MAX_STUDENT_NUM];
        this.teachers = new Teacher[MAX_TEACHER_NUM];
        this.courses = new Course[MAX_COURSE_NUM];

        this.departmentIndex = 0;
        this.studentIndex = 0;
        this.teacherIndex = 0;
        this.courseIndex = 0;
    }

    /**
     * Adds a new department to the system.
     *
     * @param departmentName The name of the new department.
     */
    public void addDepartment(String departmentName) {
        if (departmentIndex < MAX_DEPARTMENT_NUM) {
            departments[departmentIndex++] = new Department(departmentName);
        } else {
            System.out.println("Maximum department limit reached.");
        }
    }

    /**
     * Adds a new student to the system.
     *
     * @param fname The first name of the student.
     * @param lname The last name of the student.
     * @param departmentId The id of the department to which the student belongs.
     */
    public void addStudent(String fname, String lname, String departmentId) {
        Department department = findDepartment(departmentId);
        if (department != null) {
            if (studentIndex < MAX_STUDENT_NUM) {
                students[studentIndex++] = new Student(fname, lname, department);
            } else {
                System.out.println("Maximum student limit reached.");
            }
        } else {
            System.out.println("Department not found.");
        }
    }

    /**
     * Adds a teacher to the system.
     *
     * @param lname The last name of the teacher.
     * @param fname The first name of the teacher.
     * @param departmentId The id of the department to which the teacher belongs.
     */
    public void addTeacher(String lname, String fname, String departmentId) {
        Department department = findDepartment(departmentId);
        if (department != null) {
            if (teacherIndex < MAX_TEACHER_NUM) {
                teachers[teacherIndex++] = new Teacher(lname, fname, department);
            } else {
                System.out.println("Maximum teacher limit reached.");
            }
        } else {
            System.out.println("Department not found.");
        }
    }

    /**
     * Adds a new course to the system.
     *
     * @param courseName  The name of the course.
     * @param credit The credit value of the course.
     * @param departmentId The id of the department to which the course belongs.
     */
    public void addCourse(String courseName, double credit, String departmentId) {
        Department department = findDepartment(departmentId);
        if (department != null) {
            if (courseIndex < MAX_COURSE_NUM) {
                courses[courseIndex++] = new Course(courseName, credit, department);
            } else {
                System.out.println("Maximum course limit reached.");
            }
        } else {
            System.out.println("Department not found.");
        }
    }

    /**
     * Prints info of all departments of the system.
     */
    public void printDepartments() {
        for (Department department : departments) {
            if (department != null) {
                System.out.println(department);
            }
        }
    }

    /**
     * Prints info of all students of the system.
     */
    public void printStudents() {
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    /**
     * Prints info of all teachers of the system.
     */
    public void printTeachers() {
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }

    /**
     * Prints info of all courses of the system.
     */
    public void printCourses() {
        for (Course course : courses) {
            if (course != null) {
                System.out.println(course);
            }
        }
    }

    /**
     * Finds a department in the system by its id.
     *
     * @param departmentId The id of the department to find.
     * @return The department with the searched id, or null if not found.
     */
    public Department findDepartment(String departmentId) {
        for (Department department : departments) {
            if (department != null && department.getId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }

    /**
     * Finds a teacher in the system by their id.
     *
     * @param teacherId The id of the teacher to find.
     * @return The teacher with the searched id, or null if not found.
     */
    public Teacher findTeacher(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher != null && teacher.getId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * Finds a course in the system by its id.
     *
     * @param courseId The id of the course to find.
     * @return The course with the searched id, or null if not found.
     */
    public Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course != null && course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Finds a student in the system by their id.
     *
     * @param studentId The id of the student to find.
     * @return The student with the searched id, or null if not found.
     */
    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student != null && student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Modifies the teacher of a course in the system.
     *
     * @param teacherId The id of the teacher to assign to the course.
     * @param courseId The id of the course to be modified.
     */
    public void modifyCourseTeacher(String teacherId, String courseId) {
        Teacher teacher = findTeacher(teacherId);
        Course course = findCourse(courseId);

        if (teacher != null && course != null) {
            course.assignTeacher(teacher);
        } else {
            System.out.println("Teacher or course not found.");
        }
    }

    /**
     * Registers a student for a course in the system.
     *
     * @param studentId The id of the student to be registered for the course.
     * @param courseId The id of the course for which the student is registering.
     */
    public void registerCourse(String studentId, String courseId) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseId);

        if (student != null && course != null) {
            student.registerCourse(course);
        } else {
            System.out.println("Student or course not found.");
        }
    }
}