import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Conundrum {

	public static void main(String[] args) {
		System.out.println("Welcome to Conundrum!\n");
		String originalWord = getWord();
		String scrambledWord = getScrambledWord(originalWord);
	}

	
	public static String getScrambledWord(String word) {
		ArrayList<String> wordCharacters = new ArrayList<String>(Arrays.asList(word.split("")));
		Collections.shuffle(wordCharacters);
		String shuffledWord = String.join("", wordCharacters);
		
		return shuffledWord;
	}
	
	public static String getWord() {
			FileReader fileReader = new FileReader("src/words.txt");
			ArrayList<String> words = new ArrayList<String>();
			while (fileReader.hasNext()) {
				words.add(fileReader.next());
			}
			fileReader.close();
			String word = words.get((int) Math.floor(Math.random() * words.size()));
			return word;	
	}

}
