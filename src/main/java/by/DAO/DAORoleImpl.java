package by.DAO;

import by.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Роман on 23.07.2017.
 */
public class DAORoleImpl implements DAORole {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Role getRoleById(int id){
        Role role= (Role) this.sessionFactory.getCurrentSession().get(Role.class,id);
        return role;
    }

//    @Override
//    public void updateRole(Role role) {
//        Session session=this.sessionFactory.getCurrentSession();
//        Role role1=new Role();
//        role1.setName(role.getName());
//        role1.setUsers(role.getUsers());
//        session.saveOrUpdate(role1);
//        session.flush();
//        session.close();
//    }
@Override
public void updateRole(Role role) {
    this.sessionFactory.getCurrentSession().update(role);
}

    @Override
    public void saveRole(Role role) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(role);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    @Override
    public List<Role> getListRole() {
        Session session=this.sessionFactory.getCurrentSession();
        List<Role> roleList=session.createQuery("from Role ").list();
        return roleList;
    }

    @Override
    public void deleteRole(Role role) {
        this.sessionFactory.getCurrentSession().delete(role);
    }
}
