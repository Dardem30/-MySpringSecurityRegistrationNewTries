package by.DAO;

import by.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Роман on 21.07.2017.
 */
public class DAOUserImpl implements DAOUser {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findByUsername(String username) {
        Query query=this.sessionFactory.getCurrentSession().createQuery("from User where username=:username");
        query.setString("username",username);
        User user= (User) query.uniqueResult();
        return user;
    }

@Override
public void updateUser(User user) {
  this.sessionFactory.getCurrentSession().update(user);
}

    @Override
    public User findById(int id) {
        User user= (User) this.sessionFactory.getCurrentSession().get(User.class,id);
        return user;
    }

    public void saveUser(User user){
        this.sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public List<User> getListUser() {
      Session session=this.sessionFactory.getCurrentSession();
      List<User> userList=session.createQuery("from User").list();
        return userList;
    }

    @Override
    public User getById(int id) {
        User user= (User) this.sessionFactory.getCurrentSession().get(User.class,id);
        return user;
    }
    @Override
    public void deleteUser(User user){
        this.sessionFactory.getCurrentSession().delete(user);
    }
}
