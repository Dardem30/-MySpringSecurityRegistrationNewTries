package by.service;

import by.DAO.DAORole;
import by.model.Role;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Роман on 08.08.2017.
 */
@Transactional
public class RoleService {
    @Autowired
    private DAORole daoRole;
    @Transactional
    public Role getRoleById(int id){
        return this.daoRole.getRoleById(id);
    }
    @Transactional
    public void updateRole(Role role){
        this.daoRole.updateRole(role);
    }
    @Transactional
    public void saveRole(Role role){
        this.daoRole.saveRole(role);
    }
    @Transactional
    public List<Role> getListRole(){
        return this.daoRole.getListRole();
    }
    @Transactional
    public void deleteRole(Role role){
        this.daoRole.deleteRole(role);
    }
}
