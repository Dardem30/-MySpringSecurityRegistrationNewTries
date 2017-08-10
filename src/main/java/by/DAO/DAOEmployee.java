package by.DAO;

import by.model.Department;
import by.model.Employee;
import by.model.Role;
import by.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Роман on 08.08.2017.
 */
@Repository
public class DAOEmployee {
    @Autowired
    private SessionFactory sessionFactory;
    public List<Employee> listEmployee(){
       List<Employee> employeeList=this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
       return employeeList;
    }
    public void updateEmployee(Employee employee){
        this.sessionFactory.getCurrentSession().update(employee);
    }
    public Employee getById(int id){
        Employee employee= (Employee) this.sessionFactory.getCurrentSession().get(Employee.class,id);
        return employee;
    }
    public List<Department> getListDepartment(){
        List<Department> departmentList=this.sessionFactory.getCurrentSession().createQuery("from Department ").list();
        return departmentList;
    }
    public List<Employee> getEmployeeListAdmin(){
        List<User> userList2=this.sessionFactory.getCurrentSession().createQuery("from User ").list();
            List<Employee> employeeList=new ArrayList<>();
            for(User user: userList2){
                for(Role role1: user.getRoles()){
                    if((role1.getName()).equals("ROLE_ADMIN")){
                       employeeList.add(user.getEmployee());
                    }else {
                        System.out.println("user");
                    }
                }
            }
            return employeeList;
    }
    public void saveEmployee(Employee employee) {
        this.sessionFactory.getCurrentSession().persist(employee);
    }
    public List<Employee> getListEmployee(){
        List<Employee> employeeList=this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
        return employeeList;
    }
}
