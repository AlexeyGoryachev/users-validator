package ag.registrationusers.myhomework1234.usersvalidator;

import java.util.HashSet;
import java.util.Set;
//  задаю критерии для вводимых данных (длина, используемые символы, подтверждение пароля, уникальность логина)
public class UserValidatorImpl implements UserValidator {
    private static final int LOGIN_MIN_LENGTH = 3;
    private static final int LOGIN_MAX_LENGTH = 20;
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final int PASSWORD_MAX_LENGTH = 20;
    private final Set<String> registeredLogins = new HashSet<>();

    @Override
    public void validateLogin(String login) throws ValidationException {
        if (login == null || login.length() < LOGIN_MIN_LENGTH || login.length() > LOGIN_MAX_LENGTH) {
            throw new ValidationException("Логин может содержать только латинские буквы, цифры и знак подчеркивания, от 3 до 20 символов.");
        }
        for (char c : login.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || c == '_')) {
                throw new ValidationException("Логин может содержать только латинские буквы, цифры и знак подчеркивания, от 3 до 20 символов.");
            }
        }
    }


    @Override
    public void validatePassword(String password) throws ValidationException {
        if (password == null || password.length() < PASSWORD_MIN_LENGTH || password.length() > PASSWORD_MAX_LENGTH) {
            throw new ValidationException("Пароль может содержать только латинские буквы, цифры и знак подчеркивания, от 8 до 20 символов.");
        }
        for (char c : password.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || c == '_')) {
                throw new ValidationException("Пароль может содержать только латинские буквы, цифры и знак подчеркивания, от 8 до 20 символов.");
            }
        }
    }


    @Override
    public void checkPasswordMatch(String password, String confirmPassword) throws ValidationException {
        if (!password.equals(confirmPassword)) {
            throw new ValidationException("Введённые пароли не совпадают!");
        }
    }


    @Override
    public void checkLoginUnique(String login) throws ValidationException {
        if (registeredLogins.contains(login)) {
            throw new DuplicateLoginException("Пользователь с таким логином уже зарегестрирован.");
        }
    }

    public void registerLogin(String login) {
        registeredLogins.add(login);
    }
}
