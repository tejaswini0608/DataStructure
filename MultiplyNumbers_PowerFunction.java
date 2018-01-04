package portfolio;

public class MultiplyNumbers_PowerFunction {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Multiplies 2 numbers");

		System.out.println("9*11= "+foo(9,11));
		System.out.println("1*13= "+foo(1,13));
		System.out.println("10*12= "+foo(10,12));

		System.out.println("...............");
		System.out.println("calculates the power of 2 numbers");

		System.out.println("(3,5)= "+foo1(3,5));
		System.out.println("(5,5)= "+foo1(5,5));
		System.out.println("(1,1)= "+foo1(1,1));

	}
	
	//multiply 2 numbers array1 and array2
	public static int foo(int array1,int array2) {

		// array1 number is zero, then the product is 0
		if(array2==0) {
			return 0;
		}
		
		// array2 is even, then the function is called again with different parameters
		if (array2 % 2 == 0) {

			return foo(array1+array1, array2/2);
		}
		return foo(array1+array1, array2/2) + array1;

	}

	
	public static int foo1(int c,int d) {
		// d number is zero, then the product is 0

		if(d==0) {
			return 1;
		}
		
		// d is even, then the function is called again with different parameters
		if (d % 2 == 0) {

			return foo1(c*c, d/2);
		}
		return foo1(c*c, d/2) * c;
	}

}
