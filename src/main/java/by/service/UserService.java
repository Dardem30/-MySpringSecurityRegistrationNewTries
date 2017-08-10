package by.service;

import by.DAO.DAORoleImpl;
import by.DAO.DAOUserImpl;
import by.model.Role;
import by.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Роман on 21.07.2017.
 */
@Service
public class UserService {
    @Autowired
    @Qualifier("daoUser")
    private DAOUserImpl daoUser;

    public void setDaoUser(DAOUserImpl daoUser) {
        this.daoUser = daoUser;
    }

    @Autowired
    private DAORoleImpl daoRole;
    @Transactional
    public User findByUsername(String username){
        return this.daoUser.findByUsername(username);
    }
    @Transactional
    public void saveUser(User user) {
        List<Role> roles=new ArrayList<>();
        roles.add(daoRole.getRoleById(2));
        user.setRoles(roles);
    this.daoUser.saveUser(user);
    }
  @Transactional
    public void updateUser(User user){
        this.daoUser.updateUser(user);
  }
  @Transactional
    public List<User> getListUser() {
       return this.daoUser.getListUser();
    }
    @Transactional
    public User getById(int id) {
       return this.daoUser.getById(id);
    }
    @Transactional
    public void deleteUser(User user){
        this.daoUser.deleteUser(user);
    }
    }
