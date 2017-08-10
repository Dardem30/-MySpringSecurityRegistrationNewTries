package by.service;

import by.DAO.DAOEmployee;
import by.DAO.DAOMessage;
import by.model.Employee;
import by.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Роман on 02.08.2017.
 */
@Service
public class MessageService {
    @Autowired
    private DAOMessage daoMessage;
    @Autowired
    private DAOEmployee daoEmployee;
    @Transactional
    public void saveMessage(Message message){
        List<Employee> employeeList=daoEmployee.listEmployee();
        for(Employee employee: employeeList) {
            Message message1=new Message();
            message1.setText(message.getText());
            message1.setEmployee(employee);
            daoMessage.saveMessage(message1);
        }
    }
    @Transactional
    public void saveMessagePersonal(Message message, Employee employee){
        message.setEmployee(employee);
        daoMessage.saveMessage(message);
    }
    @Transactional
    public void sendMessageById(Message message){
       daoMessage.sendMessageById(message);
    }
    @Transactional
    public List<Message> getMessageListEmployee(Employee employee) {
    return this.daoMessage.getMessageListEmployee(employee);
    }
    }
