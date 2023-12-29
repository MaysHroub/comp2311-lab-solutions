package lab4.ex17;

public class Complex implements Comparable<Complex>, Cloneable{
	
	private double realPart;
	private double imaginaryPart;

	public Complex(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	public Complex(double realPart) {
		this.realPart = realPart;
		this.imaginaryPart = 0;
	}
	
	public Complex() {
		realPart = 0;
		imaginaryPart = 0;
	}

	public double getRealPart() {
		return realPart;
	}
	
	public double getImaginaryPart() {
		return imaginaryPart;
	}
	
	public Complex add(Complex other) {
		return new Complex(realPart + other.realPart, imaginaryPart + other.imaginaryPart);
	}
	
	public Complex subtract(Complex other) {
		return new Complex(realPart - other.realPart, imaginaryPart - other.imaginaryPart);
	}
	
	public Complex multiply(Complex other) {
		double a = realPart, b = imaginaryPart,
				c = other.realPart, d = other.imaginaryPart;
		
		return new Complex(a*c - b*d, b*c + a*d);
	}
	
	public Complex divide(Complex other) {
		double a = realPart, b = imaginaryPart,
				c = other.realPart, d = other.imaginaryPart;
		
		double realResult = (a*c + b*d) / (c*c + d*d),
				imaginaryResult = (b*c - a*d) / (c*c + d*d);
		
		return new Complex(realResult, imaginaryResult);
	}
	
	public double abs() {
		return Math.sqrt(realPart*realPart + imaginaryPart*imaginaryPart);
	}
	
	@Override
	public String toString() {
		return realPart + ((imaginaryPart == 0) ? "" : " + " + imaginaryPart + "i");
	}

	@Override
	public int compareTo(Complex o) {
		return (int) (abs() - o.abs());
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


















