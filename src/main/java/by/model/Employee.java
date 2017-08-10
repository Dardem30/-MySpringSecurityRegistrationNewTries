package by.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Роман on 08.08.2017.
 */
@Entity
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "lastname_employee")
    private String lastname;
    @Basic
    @Column(name = "name_employee")
    private String name;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToMany(mappedBy = "employee")
    private Set<EmployeeDate> employeeDateSet;
    @OneToMany(mappedBy = "employee")
    private Set<User> users;
    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER)
    private Set<Message> messages;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<EmployeeDate> getEmployeeDateSet() {
        return employeeDateSet;
    }

    public void setEmployeeDateSet(Set<EmployeeDate> employeeDateSet) {
        this.employeeDateSet = employeeDateSet;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (lastname != null ? !lastname.equals(employee.lastname) : employee.lastname != null) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
