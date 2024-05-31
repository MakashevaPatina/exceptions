public class CredentialValidator {
    public static void validateCredentials(Credential credential, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        validateLogin(credential.getLogin());
        validatePassword(credential.getPassword(), confirmPassword);
    }

    private static void validateLogin(String login) throws WrongLoginException {
        if (login == null || login.length() < 4 || login.length() > 20 || !login.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongLoginException("Логин должен содержать от 4 до 20 символов и может содержать только латинские буквы, цифры и знак подчеркивания.");
        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password == null || password.length() < 8 || password.length() > 20 || !password.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongPasswordException("Пароль должен содержать от 8 до 20 символов и может содержать только латинские буквы, цифры и знак подчеркивания.");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают.");
        }
    }
}
