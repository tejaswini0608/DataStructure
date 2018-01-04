package portfolio;



//count the words in array1 file by hashing

//package required
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class HashingWordCount {
	public static <T> void main(String[] args) {

		int Position_of_word = 1;
		int number_of_word = 1;

		// creating array1 Hashmap
		Map<String, Integer> mapped = new HashMap<String, Integer>();

		// reading the text file
		/// Users/tejaswinikumar/Desktop/dsa3/src/dsa3
		File file_name = new File("/Users/tejaswinikumar/Desktop/portfolio/src/portfolio/sample_text.txt");

		try {
			// reads the contents of file
			Scanner file = new Scanner(file_name);
			System.out.println("The file:sample_text.txt exists ");

			while (file.hasNext()) {

				String word = file.next();

				// checks if the word exists: if it doesnt, then it adds its frequency to the
				// Hashmap
				if (mapped.get(word) == null) {
					mapped.put(word, 1);
				}
				// if the word already exists, its frequency is increased
				else {
					mapped.put(word, mapped.get(word) + 1);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file doesnt exist ");
		}


		// Getting all entries in the map and then create array1 list by using this

		Set<Entry<String, Integer>> entries_in_map = mapped.entrySet();
		List<Entry<String, Integer>> list_of_mapped_entries = new ArrayList<Entry<String, Integer>>(entries_in_map);

      //sort the list in decreasing order
		//collections.sort() is used as we r sorting an arraylist of objects
		Collections.sort(list_of_mapped_entries, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
				return (entry2.getValue().compareTo(entry1.getValue()));
			}
		});

		// Printing the repeated words in input file along with their occurrence
		System.out.println("The 10 most repeated words are:");

		int count = 0;
		for (Entry<String, Integer> entry : list_of_mapped_entries) {
            System.out.println("("+entry.getKey() + " , " + entry.getValue()+")");
			count++;
			if (count == 10)
				break;
		}
	}

}
