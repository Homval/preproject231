package web.service;

import org.springframework.stereotype.Service;
import web.entity.User;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();
    User getUserById(int id);
    void createUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
}
