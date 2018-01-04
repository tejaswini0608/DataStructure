package portfolio;
//needed packages
import java.util.Scanner;

//class declaration
public class Permutation
{

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		//use scanner read the given input
		System.out.println("Enter array1 String: ");
		String string_inputted = sc.next();

		permuteString( "", string_inputted);
	  }

	//method to do the permutation
	  public static void permuteString(String Start_of_string, String End) {
		  //if the length of string is less than 1
	    if (End.length() <= 1)
	      System.out.println(Start_of_string + End);


	    else
	      for (int i = 0; i < End.length(); i++) {

	          String Str = End.substring(0, i) + End.substring(i + 1);
	          //recursion
	          permuteString(Start_of_string + End.charAt(i), Str);

	      }
	  }
}
