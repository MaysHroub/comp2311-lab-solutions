package lab4.act2;

public class Point implements Comparable<Point>, Cloneable {
	private int x;
	private int y;
	
	public Point() {
		x = 0;
		y = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object p) {
		if (!(p instanceof Point))
			return false;
		return x == ((Point)p).x && y == ((Point)p).y;
	}

	@Override
	public int compareTo(Point p) {
		return (x == p.x) ? y - p.y : x - p.x;
	}
	
	@Override
	public String toString() {
		return String.format("[%d, %d]", x, y);
	}
	
	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
}










