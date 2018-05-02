import java.util.*;

public class DistinctListOfWords {

	private String[] wordSplitter;
	private int[] occurrenceCounter;

	/*
	 * @param String - represents the sentence to be parsed
	 *
	 */
	public void countWordsInSentence(String text) {

		// replace any '\n' characters that may occur
		String temporaryString = text.replaceAll("[\\n]", " ");

		// replace any grammatical characters and split the String into an array
		wordSplitter = temporaryString.replaceAll("[,?!:.;/]", "").split(" ");

		// intialize an int array to hold count of each word
		occurrenceCounter = new int[wordSplitter.length];

		// loop through the sentence
		for (int i = 0; i < wordSplitter.length; i++) {

			// hold current word in the sentence in temporaryString variable
			temporaryString = wordSplitter[i];

			// inner loop to compare current word with those in the sentence
			// incrementing the occurrenceCounter of the adjacent int array for
			// each match
			for (int k = 0; k < wordSplitter.length; k++) {

				if (temporaryString.equalsIgnoreCase(wordSplitter[k])) {
					occurrenceCounter[k]++;
				}
			}
		}

		printResults();
	}

	private void printResults() {

		// create a LinkedHashMap to store unique combination of words and their
		// occurrenceCounter
		// the word being the key and the number of occurences is the value
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

		// populate the map
		for (int i = 0; i < wordSplitter.length; i++) {
			map.put(wordSplitter[i].toLowerCase(), occurrenceCounter[i]);
		}

		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " - " + m.getValue());
		}
	}

	// main method to test the class
	public static void main(String[] args) {

		String sentence = null;
		Scanner inputReader = new Scanner(System.in);
		System.out.println("please enter sentence: ");
		// here is how you take the input from keyboard
		sentence = inputReader.nextLine();

		DistinctListOfWords distinctListOfWords = new DistinctListOfWords();

		distinctListOfWords.countWordsInSentence(sentence);

	}

}
