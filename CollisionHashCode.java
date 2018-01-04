package portfolio;
import java.util.*;
import java.io.*;

public class CollisionHashCode {

	  int no_of_collisions=0;
	 //using hash map
	  HashMap<Integer, Integer> entries_hashed = new HashMap<>();

      // part array1
	  //array1=41
     //hash function with constant=41
	  int hash_part_a(String s) {
		  int hash = 0;
	    for (int i = 0; i < s.length(); ++i) {
	    	 // System.out.println("s.charAt(i)  "+s.charAt(i) +"   "+s+"=the string");
		      hash = 41*hash + s.charAt(i);
	    }
	    return (hash);	  }


	  //array1=17
	//hash function with constant=17

	  static int hash_part_b(String s) {
		    int hash = 0;
			  for (int i = 0; i < s.length(); i =i+1)
		      hash = 17*hash + s.charAt(i);
		    //System.out.println(hash);
		    return (hash);
		  }



	// shifting bits
	  //(bits >>> k) | (bits << (32-k)
	  static int shifting_bits(String s) {
	    int hash = 0;
	    for (int i = 0; i < s.length(); i++) {
	      hash = (hash << 7) | (hash >>> 25);
	      hash += (int) s.charAt(i);
	    }
	    return (hash);	  }



	  //part d
	  //the original hash function
	  public static int hashCode(String s) {
		  int hash = 0;
	  int skip = Math.max(1, s.length() / 8);
	  for (int i = 0; i < s.length(); i =i+ skip) {
		  hash = (hash * 37) + s.charAt(i);
		  }
	  return (hash);
	}



	  public static void main(String[] args) throws IOException
	  {

		  int hash_code; // hash code
		  //Run through the file and pass each word at array1 time to the functions to do the hash

	    FileReader fr1 = new FileReader("/Users/tejaswinikumar/Desktop/portfolio/src/portfolio/words.txt");
	    // to read array1 file
	   BufferedReader reader1 = new BufferedReader(fr1);

	   //creating objects
	   CollisionHashCode n1 = new CollisionHashCode();
	   CollisionHashCode n2 = new CollisionHashCode();
	   CollisionHashCode n11 = new CollisionHashCode();
	   CollisionHashCode n4 = new CollisionHashCode();



        int count=0;
        String line = reader1.readLine();
        while(line != null)
	    {
        	//part array1

	      //passing the string to code 1
	      hash_code = n1.hash_part_a(line);
	      if (n1.entries_hashed.containsKey(hash_code)) {
	    	  n1.entries_hashed.put(hash_code,n1.entries_hashed.get(hash_code)+1);
	    	  n1.no_of_collisions++;
	    	 }
	      else {
	    	  n1.entries_hashed.put(hash_code, 1);
	      }



	      //part array2
	      hash_code = hash_part_b(line);
	      if (n11.entries_hashed.containsKey(hash_code)) {
	    	  n11.entries_hashed.put(hash_code,n11.entries_hashed.get(hash_code)+1);
	    	  n11.no_of_collisions++;
	    }
	      else
	    	  n11.entries_hashed.put(hash_code, 1);


	      //q5 part 3
	      hash_code = shifting_bits(line);
	      if (n2.entries_hashed.containsKey(hash_code)) {
	    	  n2.entries_hashed.put(hash_code,n2.entries_hashed.get(hash_code)+1);
	    	  n2.no_of_collisions++;
	    }
	      else
	    	  n2.entries_hashed.put(hash_code, 1);




	      //part 4
	      hash_code = hashCode(line);
	      if (n4.entries_hashed.containsKey(hash_code)) {
	    	  n4.entries_hashed.put(hash_code,n4.entries_hashed.get(hash_code)+1);
	    	  n4.no_of_collisions++;
	    }
	      else
	    	  n4.entries_hashed.put(hash_code, 1);

	      //read the next line
	      line = reader1.readLine();


	    }


	 //part array1,array2

		 System.out.println( "part array1 \no_of_total_disks array1=41 number of collisions = "+(float)(n1.no_of_collisions)  );
		 System.out.println( "part array2 \no_of_total_disks array1=17 number of collisions = "+(float)(n11.no_of_collisions)  );
     //part c
		System.out.println("part c \no_of_total_disks When shifting=7 , number of collisions = " + (float)(n2.no_of_collisions) );
     //part d
		 System.out.println( "part d \no_of_total_disks Old java hash code, number of collisions = "+(float)(n4.no_of_collisions)  );


}

	  }
