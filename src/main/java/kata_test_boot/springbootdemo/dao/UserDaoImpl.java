package kata_test_boot.springbootdemo.dao;


import org.springframework.stereotype.Repository;
import kata_test_boot.springbootdemo.model.User;

import jakarta.persistence.*;
import java.util.List;

@Repository

public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }

    @Override
    public User removeUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        return user;
    }

    @Override
    public User getUserId(long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id =:user_id", User.class);
        query.setParameter("user_id", id);
        return query.getResultList().stream().findAny().orElse(null);

    }
}