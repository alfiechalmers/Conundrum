import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	private Scanner wordStream;
	
	public FileReader(String filePath) {
		try {
			this.wordStream = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		}
		
	}
	
	public void close() {
		this.wordStream.close();
	}
	
	public String next() {
		if (this.wordStream.hasNext()) {
			return this.wordStream.next();
		}
		return "";
	}
	
	public boolean hasNext() {
		return this.wordStream.hasNext();
	}
}
