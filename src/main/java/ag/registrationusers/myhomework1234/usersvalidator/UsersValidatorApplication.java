package ag.registrationusers.myhomework1234.usersvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//код для запуска
@SpringBootApplication
public class UsersValidatorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UsersValidatorApplication.class, args);

        UserRegistration registration = context.getBean(UserRegistration.class);

        registration.register("valid_login", "valid_password1", "valid_password1");
        registration.register("invalid!login", "valid_password2", "valid_password2");
        registration.register("valid_login2", "short", "short");
        registration.register("valid_login3", "valid_password3", "wrong_password");
        registration.register("valid_login", "valid_password4", "valid_password4"); // Дубликат логина
    }
}
