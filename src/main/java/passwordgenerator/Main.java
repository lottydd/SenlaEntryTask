package passwordgenerator;

public class Main {
    public static void main(String[] args) {

        PasswordGenerator generator = new PasswordGenerator(PasswordGenerator.getPasswordLength());
        Password password = generator.generatePassword();
        System.out.println("Сгенерированный пароль: " + password.getValue());
    }
}