package by.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Роман on 06.08.2017.
 */
@Entity
public class EmployeeDate {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "Time")
    private Time time;
    @Basic
    @Type(type = "date")
    @Column(name = "Date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeDate that = (EmployeeDate) o;

        if (id != that.id) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
