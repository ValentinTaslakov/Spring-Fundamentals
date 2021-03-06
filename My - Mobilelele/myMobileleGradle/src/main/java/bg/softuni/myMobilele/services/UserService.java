package bg.softuni.myMobilele.services;

import bg.softuni.myMobilele.models.entities.UserEntity;
import bg.softuni.myMobilele.models.dto.UserLoginDTO;
import bg.softuni.myMobilele.models.dto.UserRegisterDTO;
import bg.softuni.myMobilele.models.mapper.UserMapper;
import bg.softuni.myMobilele.repositories.UserRepository;
import bg.softuni.myMobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;
// инжектираме мапъра
    public UserService(UserRepository userRepository,
                       CurrentUser currentUser,
                       PasswordEncoder passwordEncoder,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
// мапваме Дто към ентити
        UserEntity newUser = userMapper.userDtoToUserEntity(userRegisterDTO);
//  преработваме паролата в хеш, и така я пазим в базата
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));


        newUser = userRepository.save(newUser);
        login(newUser);
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<UserEntity> userOpt = userRepository.
                findByEmail(loginDTO.getUsername());

        if (userOpt.isEmpty()) {
            LOGGER.info("User with not found. User name: {}",
                    loginDTO.getUsername());
            return false;
        }


        String rawPassword = loginDTO.getPassword();
        String encodedPassword = userOpt.get().getPassword();

        boolean success = passwordEncoder.
                matches(rawPassword, encodedPassword);
//използваме мачването на енкодера за да сравни двете пароли
        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }

        return success;
    }

    private void login(UserEntity userEntity) {
//  За момента използваме currentUser за да
//  проследяваме кой потребител е логнат
//  и тук сетваме данните на логнатия потребител
//  този логин е private, в първия проверяваме входните данни
//  дали съответстват на съществуващ потребител в базата и ако
//  е така подаваме потребителя тук.
        currentUser.
                setLoggedIn(true).
                setName(userEntity.getFirstName() + " " + userEntity.getLastName()).
                setEmail(userEntity.getEmail());
    }

    public void logout() {
        currentUser.clear();
    }
}
