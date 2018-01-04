package portfolio;
import java.util.Scanner;

//Recursive function to solution tower of hanoi
public class TowerOfHanoi {


	//3 poles=start_pole, middle, end_pole
   public void solution(int no_of_total_disks, String start_pole, String middle_pole, String end_pole) {
       if (no_of_total_disks == 1) {
           System.out.println(start_pole + " --> " + end_pole);
       } else {
           solution(no_of_total_disks - 1, start_pole, end_pole, middle_pole);
           System.out.println(start_pole + " --> " + end_pole);
           //calling the function again
           solution(no_of_total_disks - 1, middle_pole, start_pole, end_pole);
       }
   }


   public static void main(String[] args) {

	   //creating the object and then giving in the input
       TowerOfHanoi towersOfHanoi = new TowerOfHanoi();
       System.out.print("Enter: Total number of disks is = ");
       Scanner scanner = new Scanner(System.in);
       int Total_disks = scanner.nextInt();
       System.out.println("Path followed");
       towersOfHanoi.solution(Total_disks, "A", "B", "C");
   }
}
