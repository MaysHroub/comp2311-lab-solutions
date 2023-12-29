package lab1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

// Activity 4
public class Test {
	
	private static Scanner in = new Scanner(System.in);
	private static Train train = new Train();
	private static final String fileName = "passengers.txt";

	public static void main(String[] args) {
		
		int n = 99;
		do {
			try {
				displayMenu();
				System.out.print(">> ");
				n = in.nextInt();
				executeOption(n);

			} catch (InputMismatchException e) {
				System.err.println("Invalid input");
				in.nextLine();
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}

		} while (n != 6);

		in.close();		
	}
	
	private static void displayMenu() {
		System.out.println(
				"-------------------------------\n"
				+ "1. Read passengers file.\n"
				+ "2. Reserve a seat.\n"
				+ "3. Unreserve a seat.\n"
				+ "4. Unreserve all seats.\n"
				+ "5. Update passengers file.\n"
				+ "6. Quit.");
	}

	private static void executeOption(int option) throws IOException {
		switch (option) {
		case 1: 
			readPassengerFile(); break;
		case 2:
			reserveSeat(); break;
		case 3:
			unreserveSeat(); break;
		case 4:
			unreserveAllSeats(); break;
		case 5:
			updatePassengerFile(); break;
		case 6:
			System.out.println("Quiting the system...");
			return;
		default:
			throw new IllegalArgumentException("Invalid option: " + option);
		}
	}

	private static void updatePassengerFile() throws FileNotFoundException {
		try (PrintWriter output = new PrintWriter(fileName)) {
			for (Seat[] seats : train.getSeats())
				for (Seat seat : seats)
					output.println(seat);
		}
	}

	private static void unreserveAllSeats() {
		train.unreserveAll();
	}

	private static void unreserveSeat() {
		System.out.print("Enter the seat number: ");
		int num = in.nextInt();
		train.unreserve(num);
	}

	private static void reserveSeat() {
		System.out.print("Enter the seat number: ");
		int num = in.nextInt();
		System.out.print("Enter the passenger name: ");
		String name = in.next();
		train.reserve(num, name);
	}

	private static void readPassengerFile() throws FileNotFoundException {
		unreserveAllSeats();
		try (Scanner input = new Scanner(new File(fileName));) {
			while (input.hasNext()) {
				String[] info = input.nextLine().split(":");
				int seatNum = Integer.parseInt(info[0]);
				String name = info[1].trim();
				if (name != null && !name.equals("null"))
					train.reserve(seatNum, name);
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
}



















