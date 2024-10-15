package passwordgenerator;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "@#$!%^&_=*()-+[]{}|;:,.<>?";
    private static final String ALL_CHARACTERS = UPPER_CASE_LETTERS + LOWER_CASE_LETTERS + DIGITS + SPECIAL_CHARACTERS;

     private int passwordLength;

    public PasswordGenerator(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public Password generatePassword() {
        if (passwordLength < 8 || passwordLength > 12) {
            throw new IllegalArgumentException("Неправильная длина пароля");
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(UPPER_CASE_LETTERS.charAt(random.nextInt(UPPER_CASE_LETTERS.length())));
        password.append(LOWER_CASE_LETTERS.charAt(random.nextInt(LOWER_CASE_LETTERS.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < passwordLength; i++) {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }
        return new Password(shufflePassword(password.toString()));
    }

    private String shufflePassword(String password) {
        char[] characters = password.toCharArray();
        Random random = new Random();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }

    public static int getPasswordLength() {
        Scanner scanner = new Scanner(System.in);
        int passwordLength = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Введите длину пароля от 8 до 12 включительно");
            passwordLength = scanner.nextInt();

            if (passwordLength >= 8 && passwordLength <= 12) {
                validInput = true;
            } else {
                System.out.println("Неправильная длина пароля. Пожалуйста, введите число от 8 до 12.");
            }
        }
        return passwordLength;
    }
}
