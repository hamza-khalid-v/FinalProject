package org.hamza.dto;

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

    public void addDepartment(String departmentName) {
        if (departmentIndex < MAX_DEPARTMENT_NUM) {
            departments[departmentIndex++] = new Department(departmentName);
        } else {
            System.out.println("Maximum department limit reached.");
        }
    }

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

    public void printDepartments() {
        for (Department department : departments) {
            if (department != null) {
                System.out.println(department);
            }
        }
    }

    public void printStudents() {
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    public void printTeachers() {
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }

    public void printCourses() {
        for (Course course : courses) {
            if (course != null) {
                System.out.println(course);
            }
        }
    }

    public Department findDepartment(String departmentId) {
        for (Department department : departments) {
            if (department != null && department.getId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }
    public Teacher findTeacher(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher != null && teacher.getId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }
    public Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course != null && course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student != null && student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void modifyCourseTeacher(String teacherId, String courseId) {
        Teacher teacher = findTeacher(teacherId);
        Course course = findCourse(courseId);

        if (teacher != null && course != null) {
            course.assignTeacher(teacher);
        } else {
            System.out.println("Teacher or course not found.");
        }
    }

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