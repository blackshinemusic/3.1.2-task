package kata_test_boot.springbootdemo.service;

import kata_test_boot.springbootdemo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    User getUserId(long id);

    User removeUser(long id);

}