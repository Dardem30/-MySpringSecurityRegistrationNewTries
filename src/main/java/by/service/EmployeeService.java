package by.service;

import by.DAO.DAOEmployee;
import by.model.Department;
import by.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Роман on 01.08.2017.
 */
@Service
public class EmployeeService {
    @Autowired
    private DAOEmployee daoEmployee;
    @Transactional
    public List<Employee> listEmployee(){
        return this.daoEmployee.listEmployee();
    }
    @Transactional
    public void updateEmployee(Employee employee){
        this.daoEmployee.updateEmployee(employee);
    }
    @Transactional
    public Employee getById(int id){
        return this.daoEmployee.getById(id);
    }
    @Transactional
    public List<Department> getListDepartment(){
        return this.daoEmployee.getListDepartment();
    }
    @Transactional
    public List<Employee> getEmployeeListAdmin(){
        return this.daoEmployee.getEmployeeListAdmin();
    }
    @Transactional
    public List<Employee> getListEmployee(){
        return this.daoEmployee.getListEmployee();
    }
    @Transactional
    public void saveEmployee(Employee employee) {
    this.daoEmployee.saveEmployee(employee);
    }
    }
