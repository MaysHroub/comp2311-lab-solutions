package lab3;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Act2 {

	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();

		printHead(c);
		printBody(c);
	}

	static void printHead(Calendar c) {
		System.out.printf("          %s %d\n", 
				getMonthName(c.get(Calendar.MONTH)), c.get(Calendar.YEAR));
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	static void printBody(Calendar c) {
		int numOfFirstDay = firstDayInMonth(c);
		int numOfDays = numOfDaysInMonth(c);

		for (int i = 1; i <= numOfFirstDay + numOfDays - 1; i++) {
			if (i < numOfFirstDay) {
				System.out.printf("    ");
				continue;
			}

			System.out.printf("%4d", i - numOfFirstDay + 1);

			if (i % 7 == 0)
				System.out.println();
		}
	}

	static int firstDayInMonth(Calendar c) {
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.get(Calendar.DAY_OF_WEEK);
	}

	static int numOfDaysInMonth(Calendar c) {
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	static String getMonthName(int month) {
		switch (month) {
		case 0:
			return "Jan";
		case 1:
			return "Feb";
		case 2:
			return "Mar";
		case 3:
			return "Apr";
		case 4:
			return "May";
		case 5:
			return "Jun";
		case 6:
			return "Jul";
		case 7:
			return "Aug";
		case 8:
			return "Sep";
		case 9:
			return "Oct";
		case 10:
			return "Nov";
		case 11:
			return "Dec";
		default:
			return "null";
		}
	}
}
