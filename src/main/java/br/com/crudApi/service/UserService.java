package br.com.crudApi.service;

import br.com.crudApi.model.User;
import br.com.crudApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author maxjdev
 */

@Service
public class UserService {
    private final UserRepository repository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }
    public List<User> getAllUsers() {
        return repository.findAll();
    }
    public User getUserById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }
    public User createUser(User user) {
        return repository.save(user);
    }
    public User updateUser(Long id, User userUpdated) {
        User user = repository.findById(id)
                .orElse(null);
        if (user != null) {
            user.setUsername(userUpdated.getUsername());
            user.setEmail(userUpdated.getEmail());
            return repository.save(user);
        }
        return null;
    }
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
