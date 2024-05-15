package ag.registrationusers.myhomework1234.usersvalidator;
//общие ошибки корректности ввода данных.
public class ValidationException extends Exception{
    public ValidationException(String message) {
        super(message);
    }
}
