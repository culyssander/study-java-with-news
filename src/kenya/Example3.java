package kenya;

import java.util.Scanner;

public class Example3 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		CarLinkedList carllist = new CarLinkedList();
		
		for(int i = 0; i < 5; i++ ) {
			Car car = new Car();
			
			System.out.print("Car "+ (i+1) + ": Inform Registration: ");
			car.Registration = keyboard.next();
			
			System.out.print("Car "+ (i+1) + ": Inform Brand: ");
			car.brand = keyboard.next();
			
			System.out.print("Car "+ (i+1) + ": Inform model: ");
			car.model = keyboard.next();
			
//			carllist.add(car);
		}
		
		
		System.out.println("FIRST: " + carllist.first());
		System.out.println("LASTEST: " + carllist.latest());
		System.out.println("HIGH: " + carllist.higher());
		System.out.println("LESS: " + carllist.less());
		
		keyboard.close();

	}

}
