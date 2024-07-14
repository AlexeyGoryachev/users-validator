package ag.registrationusers.myhomework1234.usersvalidator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

//  задаю критерии для вводимых данных (длина, используемые символы, подтверждение пароля, уникальность логина)
public class UserValidatorImpl implements UserValidator {

    private static final Pattern LOGIN_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{3,20}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{8,20}$");
    private final Set<String> registeredLogins = new HashSet<>();

    @Override
    public void validateLogin(String login) throws ValidationException {
        if (!LOGIN_PATTERN.matcher(login).matches()) {
            throw new ValidationException("Логин может содержать только латинские буквы, цифры и знак подчеркивания, от 3 до 20 символов.");
        }
    }

    @Override
    public void validatePassword(String password) throws ValidationException {
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new ValidationException("Пароль может содержать только латинские буквы, цифры и знак подчеркивания, от 8 до 20 символов.");
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
