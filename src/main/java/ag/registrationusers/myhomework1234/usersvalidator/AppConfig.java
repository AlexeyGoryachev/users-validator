package ag.registrationusers.myhomework1234.usersvalidator;
//  определение бинов
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserValidator userValidator() {
        return new UserValidatorImpl();
    }
    @Bean
    public UserRegistration userRegistration() {
        return new UserRegistration(userValidator());
    }
}
