package lab1;

// Activity 1
public class Seat {

	private int seatNumber;
	private String passengerName;

	public Seat(int seatNumber) {
		setSeatNumber(seatNumber);
	}

	public boolean isEmpty() {
		return passengerName == null;
	}

	public String toString() {
		return String.format("%d: %s", seatNumber, passengerName);
	}

	public static boolean isValid(int seatNumber) {
		return seatNumber >= 1 && seatNumber <= 92
				&& seatNumber != 3 && seatNumber != 4 
				&& seatNumber != 89 && seatNumber != 90;
	}
	
	public static int getRow(int seatNumber) { // 0-based
		return (seatNumber - 1) / 4;
	}
	
	public static int getColumn(int seatNumber) { // 0-based
		return (seatNumber - 1) % 4;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		if (!isValid(seatNumber))
			throw new IllegalArgumentException("Invalid seat number");
		this.seatNumber = seatNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

}
