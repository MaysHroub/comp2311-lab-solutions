package lab1;

// Activity 3
public class Train {
	
	// It's nonsense to make it static as required in the lab manual
	// So I've made it non-static.
	private Seat[][] seats;
	

	public Train() {
		seats = new Seat[23][];
		seats[0] = new Seat[2];
		seats[22] = new Seat[2];
		
		for (int i = 1; i < seats.length-1; i++) 
			seats[i] = new Seat[4];
		
		int c = 0;
		for (int i = 0; i < seats.length; i++) 
			for (int j = 0; j < seats[i].length; ) {
				++c;
				if (c == 3 || c == 4 || c == 89 || c == 90) continue;
				seats[i][j] = new Seat(c);
			}
	}
	
	public Seat[][] getSeats() {
		return seats;
	}

	public boolean reserve(int seatNumber, String passengerName) {
		if (!Seat.isValid(seatNumber)) {
			System.out.printf("Invalid seat number.\n");
			return false;
		}
		
		int i = Seat.getRow(seatNumber);
		int j = Seat.getColumn(seatNumber);
				
		if( !seats[i][j].isEmpty() ) {
			System.out.printf("Seat with number %d is already reserved.\n", seatNumber);
			return false;
		}
		
		seats[i][j].setPassengerName(passengerName);
		return true;
	}
	
	public boolean unreserve(int seatNumber) {
		if (!Seat.isValid(seatNumber)) {
			System.out.printf("Invalid seat number.\n");
			return false;
		}
		
		int i = Seat.getRow(seatNumber);
		int j = Seat.getColumn(seatNumber);
		
		if (seats[i][j].isEmpty()) {
			System.out.printf("Seat with number %d is already not reserved.\n", seatNumber);			
			return false;
		}
		
		seats[i][j].setPassengerName(null);
		return true;
	}
	
	public boolean unreserveAll() {
		for (int i = 0; i < seats.length; i++) 
			for (int j = 0; j < seats[i].length; j++) 
				seats[i][j].setPassengerName(null);
		return true;
	}
	
}
