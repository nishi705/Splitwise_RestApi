package com.splitwise.splitwise.Services;

import com.splitwise.splitwise.Model.User;
import com.splitwise.splitwise.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User getRegister(User user) {
          User savedUser = userRepository.save(user);
          return savedUser;
    }

    public User getUser(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new Exception("user does not exist");
        }else{
            return user.get();
        }

    }
}
