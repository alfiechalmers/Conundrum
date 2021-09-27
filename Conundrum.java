import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Conundrum {

	public static void main(String[] args) {
		System.out.println("Welcome to Conundrum!\n");
		String originalWord = getWord();
		String scrambledWord = getScrambledWord(originalWord);

		System.out.println("You have three attempts to unscramble the following word:\n" + scrambledWord);

		Scanner scanner = new Scanner(System.in);
		int lives = 3;
		int attempts = 0;

		while (lives > 0) {
			String guess = scanner.nextLine();

			if (guess.equals(originalWord)) {
				attempts++;
				System.out.println("Correct!");
				break;
			} else {
				attempts++;
				lives -= 1;
				System.out.println("Not this time, you have " + lives + " lives left...");
			}
		}
		if (lives == 0) {
			System.out.println("Better luck next time...");
			System.exit(1);
		} else {
			System.out.println("Well done! You did it on your " + (attempts) + " guess");
			System.exit(1);
		}
		scanner.close();

	}

	public static String getScrambledWord(String word) {
		ArrayList<String> wordCharacters = new ArrayList<String>(Arrays.asList(word.split("")));
		Collections.shuffle(wordCharacters);
		String shuffledWord = String.join("", wordCharacters);

		return shuffledWord;
	}

	public static String getWord() {
		FileReader fileReader = new FileReader("./words.txt");
		ArrayList<String> words = new ArrayList<String>();
		while (fileReader.hasNext()) {
			words.add(fileReader.next());
		}
		fileReader.close();
		String word = words.get((int) Math.floor(Math.random() * words.size()));
		return word;
	}

}
