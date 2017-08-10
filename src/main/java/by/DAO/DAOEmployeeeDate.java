package by.DAO;

import by.model.EmployeeDate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Роман on 06.08.2017.
 */
@Repository
public class DAOEmployeeeDate {
    @Autowired
    private SessionFactory sessionFactory;
    public void saveEmployeeDate(EmployeeDate employeeDate){
        this.sessionFactory.getCurrentSession().persist(employeeDate);
    }
}
