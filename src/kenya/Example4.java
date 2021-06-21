package kenya;

import java.util.Scanner;

public class Example4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int total = 0;
		int count = 1;
	
		System.out.println("Inform a number: ");
		
		while(keyboard.hasNext()) {
			System.out.println("Inform a number: (Stop if you input Zero)");
			int number = keyboard.nextInt();
			
			if(number == 0) {
				break;
			}
			total +=number;
			count++;
		}
		
		System.out.println("Count: " + count);
		System.out.println("TOTAL: " + total);
		
		keyboard.close();
	}

}
