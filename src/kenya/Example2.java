package kenya;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example2 {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		List<Car> cars = new ArrayList<Car>();
		// Input
		for(int i = 0; i < 5; i++ ) {
			Car car = new Car();
			
			System.out.print("Car "+ (i+1) + ": Inform Registration: ");
			car.Registration = keyboard.next();
			
			System.out.print("Car "+ (i+1) + ": Inform Brand: ");
			car.brand = keyboard.next();
			
			System.out.print("Car "+ (i+1) + ": Inform model: ");
			car.model = keyboard.next();
			
			cars.add(car);
		}
		
		// List
		for(int i = 0; i < 5; i++ ) {
			System.out.println(i + ": " + cars.get(i).print());
		}
		keyboard.close();
	}

}
