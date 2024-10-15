package hangman;

import java.util.Scanner;

public class HangmanGame {

    private static final String[] WORDS_POOL = {"сенла", "карбюратор", "разработчик", "курс", "сидр"};

    private static final String[] GAME_STAGES = {
            "Виселица\n---------\n          \n          \n          \n          \n  |       \n---------",
            "Виселица\n---------\n          \n          \n          \n  |       \n  |       \n---------",
            "Виселица\n---------\n          \n          \n  |       \n  |       \n  |       \n---------",
            "Виселица\n---------\n          \n  |       \n  |       \n  |       \n  |       \n---------",
            "Виселица\n---------\n  +--     \n  |       \n  |       \n  |       \n  |       \n---------",
            "Виселица\n---------\n  +----+  \n  |       \n  |       \n  |       \n  |       \n---------",
            "Виселица\n---------\n  +----+  \n  |    |  \n  |       \n  |       \n  |       \n---------",
            "Виселица\n---------\n  +----+  \n  |    |  \n  |       \n  |       \n  |       \n---------",
            "Виселица\n---------\n  +----+  \n  |    |  \n  |    O  \n  |       \n  |       \n---------",
            "Виселица\n---------\n  +----+  \n  |    |  \n  |    O  \n  |    |  \n  |       \n---------",
            "Виселица\n---------\n  +----+  \n  |    |  \n  |    O  \n  |   /|  \n  |       \n---------",
            "Виселица\n---------\n  +----+  \n  |    |  \n  |    O  \n  |   /|\\ \n  |       \n---------",
            "Виселица\n---------\n  +----+  \n  |    |  \n  |    O  \n  |   /|\\ \n  |   /   \n---------",
            "Виселица\n---------\n  +----+  \n  |    |  \n  |    O  \n  |   /|\\ \n  |   / \\ \n---------"
    };

    private String hiddenWord;
    private char[] guessedLetters;
    private int wrongAttempts;

    public HangmanGame() {
        hiddenWord = WORDS_POOL[(int) (Math.random() * WORDS_POOL.length)];
        guessedLetters = new char[hiddenWord.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }
        wrongAttempts = 0;
    }

    private void displayGameStage() {
        System.out.println(GAME_STAGES[wrongAttempts]);
        System.out.println("Слово: " + String.valueOf(guessedLetters));
    }

    private boolean IsLetterInWord(char letter) {
        return hiddenWord.indexOf(letter) >= 0;
    }

    private void showGuessedLetters(char letter) {
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letter) {
                guessedLetters[i] = letter;
            }
        }
    }

    private boolean isWordGuessed() {
        return String.valueOf(guessedLetters).equals(hiddenWord);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = GAME_STAGES.length + 1;

        while (wrongAttempts < maxAttempts) {
            displayGameStage();
            System.out.print("Твой ход! Вводи букву: ");
            char letter = scanner.next().charAt(0);

            if (IsLetterInWord(letter)) {
                showGuessedLetters(letter);
            } else {
                wrongAttempts++;
            }

            if (isWordGuessed()) {
                System.out.println("Поздравляем! Вы угадали слово: " + hiddenWord);
                break;
            }
        }

        if (wrongAttempts == maxAttempts) {
            displayGameStage();
            System.out.println("Вы проиграли! Загаданное слово: " + hiddenWord);
        }

        scanner.close();
    }
}
