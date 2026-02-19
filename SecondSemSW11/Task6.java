import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

      
        ArrayList<String> words = new ArrayList<>();
        words.add("java");
        words.add("hangman");
        words.add("computer");
        words.add("programming");

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();

        int wrongGuesses = 0;

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("Welcome to Java Hangman!");

        while (wrongGuesses < 6) {

            System.out.println(getHangmanArt(wrongGuesses));
            System.out.print("Word: ");

            for (char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct guess!");

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }

                if (!wordState.contains('_')) {
                    System.out.println(getHangmanArt(wrongGuesses));
                    System.out.println("YOU WIN!");
                    System.out.println("The word was: " + word);
                    break;
                }

            } else {
                wrongGuesses++;
                System.out.println("Wrong guess!");
            }

            if (wrongGuesses >= 6) {
                System.out.println(getHangmanArt(wrongGuesses));
                System.out.println("GAME OVER!");
                System.out.println("The word was: " + word);
            }
        }

        scanner.close();
    }

    static String getHangmanArt(int wrongGuesses) {

        if (wrongGuesses == 1) {
            return " O\n";
        } else if (wrongGuesses == 2) {
            return " O\n |\n";
        } else if (wrongGuesses == 3) {
            return " O\n/|\n";
        } else if (wrongGuesses == 4) {
            return " O\n/|\\\n";
        } else if (wrongGuesses == 5) {
            return " O\n/|\\\n/\n";
        } else if (wrongGuesses == 6) {
            return " O\n/|\\\n/ \\\n";
        } else {
            return "";
        }
    }
}
