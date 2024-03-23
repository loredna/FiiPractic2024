package ro.fiipractic.service;

import ro.fiipractic.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    void registerUser(User user);

    User getUserById(Integer id);

    List<User> getAllUsers();

    void updateUser(Integer id, User user);

    void patchUser(Integer id, Map<String, String> user);

    void deleteUser(Integer id);

}
