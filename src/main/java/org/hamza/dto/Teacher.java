package org.hamza.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents a teacher for the school management system.
 *
 * @author Hamza Khalid
 */
@EqualsAndHashCode
@ToString
@Getter
@Setter

public class Teacher {
    private static int nextId = 1;
    private String lname;
    private String fname;
    private String id;
    private Department department;

    /**
     * Constructs a new Teacher with a given name and id.
     *
     * @param lname The last name of the teacher.
     * @param fname The first name of the teacher.
     * @param department The department the teacher is assigned to.
     */
    public Teacher(String lname, String fname, Department department) {
        this.lname = lname;
        this.fname = fname;
        this.department = department;
        this.id = String.format("T%03d", nextId++);
    }
}
