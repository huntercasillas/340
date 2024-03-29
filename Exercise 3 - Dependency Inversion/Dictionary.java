
package spellcheck;

import java.io.*;
import java.util.*;


public class Dictionary implements DictionaryInterface {

	private Set<String> words;

	public Dictionary(String fileName) throws IOException {
		Scanner scanner = new Scanner(new File(fileName));
		try {
			words = new TreeSet<String>();
			while (scanner.hasNextLine()) {
				String word = scanner.nextLine().trim();
				words.add(word);
			}
		}
		finally {
			scanner.close();
		}
	}

	@Override public boolean isValidWord(Object word) {
		word = (String) word;
		return words.contains(word);
	}
}
