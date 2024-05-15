package ag.registrationusers.myhomework1234.usersvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//код для запуска
@SpringBootApplication(scanBasePackages = "ag.registrationusers.myhomework1234.usersvalidator")
public class UsersValidatorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UsersValidatorApplication.class, args);

        UserRegistration registration = context.getBean(UserRegistration.class);
//создаю несколько проверочных запросов на регистрацию
        registration.register("login1", "P_password1", "P_password1");
        registration.register("login2", "P_password2", "P_password2");
        registration.register("login3", "short", "short");
        registration.register("lo", "short_not", "short_not");
        registration.register("login4", "P_password3", "wrong_password");
        registration.register("login1", "P_password4", "P_password4"); // Дубликат логина
    }
}
