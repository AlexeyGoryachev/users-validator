package ag.registrationusers.myhomework1234.usersvalidator;

//  создал интерфейс для проверки данных введенных пользователем
public interface UserValidator {
    //  проверка корректности введенного логина
    void validateLogin(String login) throws ValidationException;

    //  проверка корректности введенного пароля
    void validatePassword(String password) throws ValidationException;

    //  проверка корректности введенного подтвержденного пароля (идентичности пароля и подтвержения пароля)
    void checkPasswordMatch(String password, String confirmPassword) throws ValidationException;

    //  проверка уникальности логина
    void checkLoginUnique(String login) throws ValidationException;
}
