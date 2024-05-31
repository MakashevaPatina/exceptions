public class Main {
    public static void main(String[] args) {
        System.out.println("exceptions");

        String login = "sky_pro";
        String password = "Dnfddsf_5";
        String confirmPassword = "Dnfddsf_";

        Credential credential = new Credential(login, password);
        try {
            CredentialValidator.validateCredentials(credential, confirmPassword);
            System.out.println("Логин и пароль успешно прошли проверку.");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка проверки логина и пароля: " + e.getMessage());
        }
    }
}
