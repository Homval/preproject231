package web.service;

import web.entity.User;

import java.util.List;


public interface UserService {
    List<User> getUsers();
    User getUserById(long id);
    void createUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
}
