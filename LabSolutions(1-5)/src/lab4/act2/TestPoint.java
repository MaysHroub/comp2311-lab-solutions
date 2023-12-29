package lab4.act2;

public class TestPoint {

	public static void main(String[] args) {
		Point p1 = new Point();
		Point p2 = new Point(0, 6);
		Point p3 = (Point) p2.clone();
		
		System.out.printf("P1: %s, P2: %s, P3: %s\n", p1, p2, p3);
		System.out.println(p2.compareTo(p1));
		System.out.println(p3.compareTo(p2));
		System.out.println(p2.equals(p3));
	}

}
