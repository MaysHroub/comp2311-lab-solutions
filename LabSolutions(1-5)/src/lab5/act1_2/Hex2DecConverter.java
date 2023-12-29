package lab5.act1_2;
import java.util.Scanner;

public class Hex2DecConverter {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a hex number: ");
		String hexString = in.next();

		try {
			System.out.println(hex2Dec(hexString));
			System.out.println("To check: " + Integer.parseInt(hexString, 16));

		} catch (HexFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	static int hex2Dec(String hexString) throws HexFormatException {
		if (!hexString.matches("[0-9A-F]+"))
			throw new HexFormatException("Invalid hex format...");

		int result = 0;
		int power = 1;
		for (int i = hexString.length() - 1; i >= 0; i--) {
			char digit = hexString.charAt(i);
			result += decimalValue(digit) * power;
			power *= 16; 
		}

		return result;
	}

	private static int decimalValue(char hexDigit) {
		if (hexDigit >= '0' && hexDigit <= '9')
			return hexDigit - '0';
		else if (hexDigit >= 'A' && hexDigit <= 'F')
			return (hexDigit - 'A') + 10;
		else
			return -1; // or throw the exception here...
	}

}
