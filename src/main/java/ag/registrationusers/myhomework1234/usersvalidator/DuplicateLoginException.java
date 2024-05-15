package ag.registrationusers.myhomework1234.usersvalidator;
//ошибка регистрации существующего логина.
public class DuplicateLoginException extends ValidationException {
    public DuplicateLoginException(String message) {
        super(message);
    }
}
