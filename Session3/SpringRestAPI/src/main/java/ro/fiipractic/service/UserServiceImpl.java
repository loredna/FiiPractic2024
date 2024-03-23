package ro.fiipractic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fiipractic.model.User;
import ro.fiipractic.repository.UserDAO;
import ro.fiipractic.util.UserUtil;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userRepository;
    private final UserUtil userUtil;

    @Autowired
    public UserServiceImpl(UserDAO userRepository, UserUtil userUtil) {
        this.userRepository = userRepository;
        this.userUtil = userUtil;
    }

    @Override
    public void registerUser(User user) {
        userRepository.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void updateUser(Integer id, User user) {
        userRepository.updateUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), id);
    }

    @Override
    public void patchUser(Integer id, Map<String, String> partialUser) {
        User user = userRepository.getUserById(id);

        userUtil.patchUser(user, partialUser);

        userRepository.updateUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteUser(id);
    }

}
