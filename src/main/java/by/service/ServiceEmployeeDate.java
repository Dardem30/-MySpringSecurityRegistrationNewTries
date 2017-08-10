package by.service;

import by.DAO.DAOEmployeeeDate;
import by.model.EmployeeDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Роман on 06.08.2017.
 */
@Service
public class ServiceEmployeeDate {
    @Autowired
    private DAOEmployeeeDate employeeeDate;
    @Transactional
    public void saveEmployeeDate(EmployeeDate employeeDate){
        this.employeeeDate.saveEmployeeDate(employeeDate);
    }
    }
