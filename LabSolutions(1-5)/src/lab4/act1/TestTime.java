package lab4.act1;

public class TestTime {

	public static void main(String[] args) {
		Time currentTime = new Time();
		Time time1 = new Time(2000000000);
		Time time2 = new Time(8, 44, 1);
		
		System.out.println("Current time: " + currentTime);
		System.out.println("Time1: " + time1);
		System.out.println("Time2: " + time2);
		System.out.println("Time2 in seconds: " + time2.getSeconds());
		
		Time clonedTime = (Time) time1.clone();
		System.out.println("Cloned time: " + clonedTime);
		
		System.out.println("Time1 compared to current time: " + time1.compareTo(currentTime));
		System.out.println("Time1 compared to cloned time: " + time1.compareTo(clonedTime));
		
	}

}
