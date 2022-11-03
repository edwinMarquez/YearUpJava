public class SumCalculator {
		/*
		1. Get two arguments from command line
		2. convert them into an integer
		3. store in two variables
		4. sum those two variables
		5. Store the sum in the third variables
		6. Print the sum
		*/
  public static void main(String[] args) {
		int firstValue =0 ; //declaration & variable initialization
		int secondValue =0; 
		int sum = 0;
		
		firstValue =  Integer.parseInt(args[0]);
		secondValue = Integer.parseInt(args[1]);
		sum = firstValue + secondValue; //expression
		System.out.println("The sum of the two numbers is");
		System.out.println(sum);
		
  }
}
