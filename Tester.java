package portfolio;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Tester {

	//question 4
	public static void testPalindrome() {
		String [] elements = {"array1", "m", "array1", "no_of_total_disks", "array1", "p", "l", "array1", "no_of_total_disks", "array1", "c", "array1", "no_of_total_disks", "array1", "l", "p", "array1", "no_of_total_disks", "array1", "m", "array1"};
		DoublyLinkedList<String> ll = new DoublyLinkedList<String>();
		
		for(String s : elements) {
			ll.addLast(s);
		}
		System.out.println("isPalindrome(): " + ll.isPalindrome());
}
	
	//getKth element
	
	public static void testKth() {
		String [] elements = {"one", "two", "three", "four", "five", "six"};
	DoublyLinkedList<String> ll = new DoublyLinkedList<String>();
	
	for(String s : elements) {
		ll.addLast(s);
	}
	for(int k = 0; k < elements.length; ++k) {
		System.out.println("k: " + k + " " + elements[k] + " =" + ll.getKth(k));
	}
	
	
	  Scanner scan = new Scanner(System.in);

      System.out.println("Enter the index of the element :");
      int index = scan.nextInt();
    if( index>ll.size() ) {
    	 System.out.println("Re-enter the value of index");
    }
    
    else {
    	
    	 System.out.println("the element at the entered index " +index +" = "+ll.getKth(index));
    }
    }
    	
	
	//reverse
	
	public static void reverse() {
		String [] elements = {"one", "two", "three", "four", "five", "six"};
		DoublyLinkedList<String> ll = new DoublyLinkedList<String>();
	
		for(String s : elements) {
			ll.addLast(s);
		}
		Iterator<String> iter = ll.iterator();
		System.out.println("Before Reverse:");
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		ll.reverse();

		iter.next();
		System.out.println("\nAfter Reverse:");
		try {
		while(iter.hasNext()){
			System.out.println(iter.next());
    }	
		}
		catch(Exception e) {
		}
	}
	
	
	
	//selection sort test
	
	public static void selectionSort() {
		Random random = new Random(20010);
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
		
		int no_of_total_disks = 100;
			for (int i = 0; i < no_of_total_disks; i++) {
				ll.addLast(new Integer(random.nextInt(1000)));
			}
			
		
			System.out.println("before sorting : " + ll);
		

		DoublyLinkedList<Integer> sorted_ll = new DoublyLinkedList<Integer>();

		System.out.println("findMinimum  " + ll.findMinimum().getElement());
		System.out.println("Done finding the minimum ............................");

		System.out.println("popMinimum()" + ll.popMinimum());
		while (!ll.isEmpty()) {
			sorted_ll.addLast(ll.popMinimum());
		}
		System.out.println("after sorting : " + sorted_ll);
	}


	//main function
	
	public static void main(String args[]) {
		
		System.out.println("........Palindrome test..........");
		testPalindrome();
		System.out.println("....... getKth element...........");
		testKth();
		System.out.println("....... reverse list...........");

		reverse();

		System.out.println("........selection Sort............");
		selectionSort();
	}
}
