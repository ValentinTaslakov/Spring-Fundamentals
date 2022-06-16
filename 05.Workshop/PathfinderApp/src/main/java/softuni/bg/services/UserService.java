package softuni.bg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.bg.model.dto.UserLoginDTO;
import softuni.bg.model.dto.UserRegisterDTO;
import softuni.bg.model.entities.User;
import softuni.bg.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void registerAndLogin(UserRegisterDTO userModel) {

        User newUser =
                new User()
                        .setUsername(userModel.getUsername())
                        .setFullName(userModel.getFullname())
                        .setAge(userModel.getAge())
                        .setEmail(userModel.getEmail())
                        .setPassword(userModel.getPassword());
        newUser = userRepository.save(newUser);


    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> userOpt =
                userRepository.findByUsername(loginDTO.getUsername());


        return false;
    }
}
