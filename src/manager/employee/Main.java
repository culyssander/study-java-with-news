package manager.employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
	
	private static Employee[] employees = new Employee[3];
	private static Scanner keyboard = new Scanner(System.in);
	private static int size;

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		System.out.print(" Welcome Manager employee\n\n"
				+ "1 - Add\n"
				+ "2 - Update\n"
				+ "3 - List all\n"
				+ "4 - Find by id\n"
				+ "5 - Delete by id\n"
				+ "6 - Record in File\n"
				+ "7 - Read File\n"
				+ "0 - Exit\n"
				+ "Chose a option: ");
		String optionString = keyboard.nextLine();
		
		int option = Integer.valueOf(optionString);
		
		do {
			switch(option) {
			case 1: add();
				break;
			case 2: update();
				break;
			case 3: listAll();
				break;
			case 4: findOne();
				break;
			case 5: deleteById();
				break;
			case 6: record();
				break;
			case 7: readFile();
				break;
			case 0: exit();
				break;
			default: System.out.println("######## Invalid option ########");
				menu();
			}
		}while(option != 0);
	}

	private static int knowPositionFree() {
		for(int i = 0; i < employees.length; i++) {
			if(employees[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public static void add() {
		int position = knowPositionFree();
		
		if(position >= 0) {
			
			System.out.print("Inform your name: ");
			String name = keyboard.nextLine();
			
			System.out.print("Inform your email: ");
			String email = keyboard.nextLine();
			
			System.out.print("Inform your role: ");
			String role = keyboard.nextLine();
			
			System.out.print("Inform your birth (year/month/day of month): ");
			String birthString = keyboard.nextLine();
			String[] birthArray = birthString.split("/");
			
			int year = Integer.valueOf(birthArray[0]);
			int month = Integer.valueOf(birthArray[1]);
			int dayOfMonth = Integer.valueOf(birthArray[2]);
			
			LocalDate birth = LocalDate.of(year, month, dayOfMonth);
			
			size++;
			Employee employee = new Employee(size, name, role, email, birth);
			
			employees[position] = employee;
			
			System.out.println("Employee added successfully...");
			
		} else {
			System.out.println("Full database");
		}
		menu();
	}
	
	public static void update() {
		if(size != 0) {
			System.out.println("Informe id of the employee: ");
			String idString = keyboard.nextLine();
			int id = Integer.valueOf(idString);
			
			int employeeFindPosition = employeeFindByPosition(id);
			
			if(employeeFindPosition != -1) {
				System.out.print("Inform your name: ");
				String name = keyboard.nextLine();
				
				System.out.print("Inform your email: ");
				String email = keyboard.nextLine();
				
				System.out.print("Inform your role: ");
				String role = keyboard.nextLine();
				
				System.out.print("Inform your birth (year/month/day of month): ");
				String birthString = keyboard.nextLine();
				String[] birthArray = birthString.split("/");
				
				int year = Integer.valueOf(birthArray[0]);
				int month = Integer.valueOf(birthArray[1]);
				int dayOfMonth = Integer.valueOf(birthArray[2]);
				
				LocalDate birth = LocalDate.of(year, month, dayOfMonth);
				
				Employee employee = new Employee(size, name, role, email, birth);
				
				employees[employeeFindPosition] = employee;
				
				System.out.println("Employee updated successfully...");				
				
			}else {
				System.out.printf(String.format("Employee with id %d not found\n", id));
			}
			
		} else {
			System.out.println("EMPTY - NO EMPLOYEE IN DATABASE");
		}
		menu();
	}
	
	public static void listAll() {
		if(size != 0) {
			System.out.println("List of employees: ");
			for(int i = 0; i < size; i++) {
				System.out.println(employees[i].toString());
			}
		} else {
			System.out.println("EMPTY - NO EMPLOYEE IN DATABASE");
		}
		menu();
	}
	
	private static Employee employeeFindById(int id) {
		for(int i = 0; i < size; i++) {
			if(employees[i].getId().equals(id))	{
				return employees[i];
			}
		}
		return null;
	}
	
	private static int employeeFindByPosition(int id) {
		for(int i = 0; i < size; i++) {
			if(employees[i].getId().equals(id))	{
				return i;
			}
		}
		return -1;
	}

	public static void findOne() {
		if(size != 0) {
			System.out.println("Informe id of the employee: ");
			String idString = keyboard.nextLine();
			int id = Integer.valueOf(idString);
			
			Employee employeeFind = employeeFindById(id);
			
			
			if(employeeFind != null) {
				System.out.println(employeeFind.toString());
			}else {
				System.out.printf(String.format("Employee with id %d not found\n", id));
			}
			
		} else {
			System.out.println("EMPTY - NO EMPLOYEE IN DATABASE");
		}
		menu();
	}

	public static void deleteById() {
		if(size != 0) {
			System.out.println("Informe id of the employee: ");
			String idString = keyboard.nextLine();
			int id = Integer.valueOf(idString);
			
			int employeeFindPosition = employeeFindByPosition(id);
			
			if(employeeFindPosition != -1) {
				employees[employeeFindPosition] = null;
				size--;
				System.out.println("Deleted successfully...");
			}else {
				System.out.printf(String.format("Employee with id %d not found\n", id));
			}
			
		} else {
			System.out.println("EMPTY - NO EMPLOYEE IN DATABASE");
		}
		menu();
	}
	
	public static void exit() {
		System.out.println("Bye!");
		System.exit(0);
	}
	
	private static void readFile() {
		System.out.print("Informe name of file you want to open: ");
		String nameOfFile = keyboard.nextLine();
		
		try {
			FileReader fileReader = new FileReader(nameOfFile);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			int i = 0;
			
			String line;
			while((line = bufferReader.readLine()) != null) {
				int position = knowPositionFree();
				String [] employeeString = line.split(",");
				
				Employee employee = new Employee(Integer.valueOf(employeeString[0]), employeeString[1], employeeString[2], employeeString[3], LocalDate.parse(employeeString[4]));
				
				employees[position] = employee;
				
				i++;
				size++;
			}		
			
			if(i != 0) System.out.println("Data uploaded.");
			else System.out.println("File not found");
			
			bufferReader.close();
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}				
		menu();
	}

	private static void record() {
		if(size != 0) {
			try {
				String nameOfFile =  String.format("employees%s.txt", LocalDateTime.now());
				FileWriter fileWriter = new FileWriter(nameOfFile);
				PrintWriter printWriter = new PrintWriter(fileWriter);
				
				for(int i = 0; i < size; i++) {
					printWriter.print(employees[i].toString() +"\n");
				}
				printWriter.close();
				System.out.println("Save with successfully... Name of file: " + nameOfFile);
			} catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage());
			}
			
		} else {
			System.out.println("EMPTY - NO EMPLOYEE IN DATABASE");
		}
		menu();
	}
}
