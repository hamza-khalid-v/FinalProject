package org.hamza.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

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
    private static final int MAX_STUDENT_COURSE_NUM = 5;
    private static final int MAX_STUDENT_TO_COURSE_NUM = 5;

    private Department[] departments;
    private int departmentNum = 0;

    private Student[] students;
    private int studentNum = 0;

    private Teacher[] teachers;
    private int teacherNum = 0;

    private Course[] courses;
    private int courseNum = 0;

    public SchoolManagementSystem() {
        this.departments = new Department[MAX_DEPARTMENT_NUM];
        this.students = new Student[MAX_STUDENT_NUM];
        this.teachers = new Teacher[MAX_TEACHER_NUM];
        this.courses = new Course[MAX_COURSE_NUM];
    }

    /**
     * Adds a new department to the system.
     *
     * @param departmentName The name of the new department.
     */
    public void addDepartment(Department departmentName) {
        if (departmentNum < MAX_DEPARTMENT_NUM) {
            departments[departmentNum++] = departmentName;
            System.out.println("Add department " + departmentName + " successfully");
        } else {
            System.out.println("Max department reached, add a new department failed");
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
            if (studentNum < MAX_STUDENT_NUM) {
                Student newStudent = new Student(fname, lname, department);
                students[studentNum++] = newStudent;
                System.out.println(newStudent + " added successfully.");
            } else {
                System.out.println("Max student reached, add a new student failed");
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
            if (teacherNum < MAX_TEACHER_NUM) {
                Teacher newTeacher = new Teacher(lname, fname, department);
                teachers[teacherNum++] = newTeacher;
                System.out.println(newTeacher + " added successfully.");
            } else {
                System.out.println("Max teacher reached, add a new teacher failed.");
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
            if (courseNum < MAX_COURSE_NUM) {
                Course newCourse = new Course(courseName, credit, department);
                courses[courseNum++] = newCourse;
                System.out.println(newCourse + " added successfully.");
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
            Teacher oldTeacher = course.getTeacher();
            course.assignTeacher(teacher);
            System.out.println(course + " teacher info updated successfully. Previous Teacher: " + oldTeacher);
        } else if (course == null) {
            System.out.println("Cannot find any course match with courseId " + courseId +
                    ". Modify teacher for course " + courseId + " failed.");
        } else {
            System.out.println("Cannot find any teacher match with teacherId" + teacherId +
                    ", modify teacher for course " + courseId + " failed.");
        }
    }

    /**
     * Registers a student for a course in the system.
     *
     * @param studentId The id of the student to be registered for the course.
     * @param courseId The id of the course for which the student is registering.
     */
    public void registerStudentToCourse(String studentId, String courseId) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseId);

        if (student == null) {
            System.out.println("Cannot find any student match with studentId " + studentId +
                    ", register student for course " + courseId + " failed.");
        } else if (student.getCourseNum() >= MAX_STUDENT_COURSE_NUM) {
            System.out.println("Student " + studentId + " has already registered " + MAX_STUDENT_COURSE_NUM +
                    " courses, register course for student " + studentId + " failed.");
        } else if (course.getStudentNum() >= MAX_STUDENT_TO_COURSE_NUM) {
            System.out.println("Course " + courseId + " has been fully registered, register course " +
                    courseId + " for student " + studentId + " failed.");
        } else if (Arrays.asList(student.getCourses()).contains(course)) {
            System.out.println("Student " + studentId + " has already registered Course " +
                    courseId + ", register course " + courseId + " for student " + studentId + " failed.");
        } else {
            student.registerCourseToStudent(course);
            course.registerNumberOfStudentToCourse(student);
            System.out.println("Student register course successfully");
            System.out.println("Latest student: " + student);
            System.out.println("Latest course info: " + course);
        }
    }
}
