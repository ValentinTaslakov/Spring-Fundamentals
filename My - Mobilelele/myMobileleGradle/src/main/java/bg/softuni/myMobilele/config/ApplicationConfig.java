package bg.softuni.myMobilele.config;

import bg.softuni.myMobilele.models.mapper.UserMapper;
import bg.softuni.myMobilele.models.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl() {

        };
    }
}

// използвания PasswordEncoder - Pbkdf2 е бавен алгоритъм за криптиране на паролата
// което не позволява на Brute force атаки(В криптографията атаката с груба сила се състои в това, 
// че нападателят подава много пароли или пароли с надеждата в крайна сметка да отгатне правилно. 
// Нападателят систематично проверява всички възможни пароли и пароли, докато не намери правилната)
// да разгадаят паролите.
// Pbkdf2 добавя фраза,дума или част от себе си към паролата и така полученото словосъчетание се хешира
// и когато правим проверка за мачване на две пароли той знае коя част е добавена от него и я премахва за да направи сравнение.
// Всеки път тази добавка е различна и една и съща парола получава различен хеш всеки път.
