package co.develhope.Calendar.services;

import co.develhope.Calendar.model.User;
import co.develhope.Calendar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUserWithParams(String name, String email, String password) throws Exception {

        if (userRepository.existsByEmail(email)) {
            throw new Exception(String.format("Email %s already exists", email));
        }

        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        return userRepository.save(newUser);
    }

    public User createUserWithBody(User user) throws Exception {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new Exception(String.format("Email %s already exists", user.getEmail()));
        }

        return userRepository.save(user);
    }

}
