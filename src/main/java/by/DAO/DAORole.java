package by.DAO;

import by.model.Role;

import java.util.List;

/**
 * Created by Роман on 23.07.2017.
 */
public interface DAORole {
    public Role getRoleById(int id);
    public void updateRole(Role role);
    public void saveRole(Role role);
    public List<Role> getListRole();
    public void deleteRole(Role role);
}
