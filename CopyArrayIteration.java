package portfolio;

import java.util.Arrays;

public class CopyArrayIteration {

	public static void main(String[] args) {
		int[] given_array = {1,2,3,4,5,6,7,8,9};
		
	//create an array copied_array and add the respective elements of given_array to copied_array
		int copied_array[] = new int[given_array.length];
		for (int i = 0; i < given_array.length; ++i) {
			copied_array[i] = given_array[i];
		}

		//to ensure that array is not given_array clone
		given_array[0] = -1;
		
		System.out.println("Array given_array = {1,2,3,4,5,6,7,8,9}");
		System.out.println("copied array"+Arrays.toString(copied_array));
	}

}
