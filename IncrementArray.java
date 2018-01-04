package portfolio;

// Practical 1 question 7 
import java.util.Arrays;
import java.util.Random;

//method where every element of the array is incremented
public class IncrementArray {

	public static void increment(int [] given_array) {
		for (int i = 0; i < given_array.length ; i++) {
			given_array[i] += 1;
		}
	}

	public static void main(String[] args) {

		int N = 15;
		// array is declared and filled with random integers
		int[] given_array = new int[N];
		Random random = new Random();

		for(int i = 0; i < N; i++)
		{
			given_array[i] = random.nextInt(100);
		}

		//print the outputs
		System.out.println("Given array : " + Arrays.toString(given_array));
		increment(given_array);
		System.out.println("After increment : " + Arrays.toString(given_array));
	}
}
