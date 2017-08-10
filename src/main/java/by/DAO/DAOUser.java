package by.DAO;

import by.model.User;

import java.util.List;

/**
 * Created by Роман on 21.07.2017.
 */
public interface DAOUser {
    User findByUsername(String username);
    void updateUser(User user);
    User findById(int id);
    public void saveUser(User user);
    public List<User> getListUser();
    public User getById(int id);
    public void deleteUser(User user);
}
