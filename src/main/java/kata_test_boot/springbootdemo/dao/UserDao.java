package kata_test_boot.springbootdemo.dao;

import kata_test_boot.springbootdemo.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    User getUserId(long id);

    User removeUser(long id);

}