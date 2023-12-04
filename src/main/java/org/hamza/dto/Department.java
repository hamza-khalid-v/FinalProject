package org.hamza.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents a department for the school management system.
 *
 * @author Hamza Khalid
 */
@EqualsAndHashCode
@Getter
@Setter

public class Department {
    private static int nextId = 1;
    private String id;
    private String departmentName;

    /**
     * Constructs a new Department with a given name and id.
     *
     * @param departmentName The name of the department.
     */
    public Department(String departmentName) {
        this.id = String.format("D%03d", nextId++);
        this.departmentName = departmentName;
    }

    /**
     * Returns a string representation of the department, the department's id and name.
     *
     * @return string representation of the department.
     */
    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
