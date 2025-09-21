package org.example.springdataautomappingobjects.dtos;

import org.example.springdataautomappingobjects.entities.Employee;

import java.util.List;

public class ManagerDto {

    private String firstName;
    private String lastName;
    private List<Employee> team;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Employee> getTeam() {
        return team;
    }

    public void setTeam(List<Employee> team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "ManagerDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", team=" + team +
                '}';
    }
}
