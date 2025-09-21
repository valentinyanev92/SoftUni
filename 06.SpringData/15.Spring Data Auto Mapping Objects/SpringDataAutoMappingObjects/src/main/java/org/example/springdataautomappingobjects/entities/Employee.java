package org.example.springdataautomappingobjects.entities;

import java.math.BigDecimal;
import java.util.List;

//@Entity
//@Table(name = "employees")
public class Employee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column
    private long id;

//    @Column(name = "fist_name", nullable = false)
    private String firstName;

//    @Column(name = "last_name", nullable = false)
    private String lastName;

//    @Column(nullable = false)
    private BigDecimal salary;

//    @Column
    private String birthday; //LocalDate!

//    @Column(name = "is_on_holiday")
    private boolean isOnHoliday;

//    @Column
    private Employee manager;

//    @Column
    private List<Employee> team;

//    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    public boolean isOnHoliday() {
        return isOnHoliday;
    }

    public void setOnHoliday(boolean onHoliday) {
        isOnHoliday = onHoliday;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getTeam() {
        return team;
    }

    public void setTeam(List<Employee> team) {
        this.team = team;
    }

    public Employee() {

    }

    public Employee(String firstName, String lastName, BigDecimal salary, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.address = address;
    }

    public Employee(String firstName, String lastName, BigDecimal salary, String birthday, boolean isOnHoliday, Employee manager, List<Employee> team, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthday = birthday;
        this.isOnHoliday = isOnHoliday;
        this.manager = manager;
        this.team = team;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String  getBirthday() {
        return birthday;
    }

    public void setBirthday(String  birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", birthday='" + birthday + '\'' +
                ", address=" + address +
                '}';
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
