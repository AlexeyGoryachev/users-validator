package ag.registrationusers.myhomework1234.usersvalidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//здесь код для регистрации новых пользователей.
public class UserRegistration {
//объявление поля "validator"
    private final UserValidator validator;

    @Autowired
//  создание конструктора
    public UserRegistration(UserValidator validator) {
        this.validator = validator;
    }
//  обработка ошибок
    public void register(String login, String password, String confirmPassword) {
        try {
            validator.validateLogin(login);
            validator.validatePassword(password);
            validator.checkPasswordMatch(password, confirmPassword);
            validator.checkLoginUnique(login);
            ((UserValidatorImpl) validator).registerLogin(login);
            System.out.println("Регистрация выполнена!");
        } catch (ValidationException e) {
            System.out.println("Ошибка регистрации: " + e.getMessage());
        }
    }
}
