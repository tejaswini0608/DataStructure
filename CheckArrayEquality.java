package portfolio;

// To check if 2 arrays are equal
//need to check that both arrays have same length
//need to check if the arrays have the same elements
public class CheckArrayEquality {


	public static boolean check_equal(int[] array1, int[] array2) {

		//ensure that the arrays are'nt empty
	    if (array1==null || array2==null)
	        return false;

	    //check if the length and the contents of the array are same
	    int length = array1.length;
	    if (array2.length != length)
	        return false;

	    for (int i=0; i<length; i++)
	        if (array1[i] != array2[i])
	            return false;

	    //check if the reference is same
	    if (array1==array2)
	        return true;

	    return true;
	}

	public static void main(String[] args) {


		int[] array1 = { 1,2,3,4,5 };
		int[] array2 = { 2,4,3,1,8,9 };
		int[] array3 = {9};
		int[] array4 = {1,2,3,4,5 };

		System.out.println("check if arrays are equal\no_of_total_disks ....................................");
		System.out.println("check if array array1==array1 : "+check_equal(array1, array1));
		System.out.println("check if array array1==array2 : "+check_equal(array1, array2));
		System.out.println("check if array array1==array3 : "+check_equal(array1, array3));
		System.out.println("check if array array1==array4 : "+check_equal(array1, array4));
	}
}
