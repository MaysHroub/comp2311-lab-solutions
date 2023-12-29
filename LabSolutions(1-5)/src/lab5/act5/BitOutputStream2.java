package lab5.act5;

import java.io.*;

public class BitOutputStream2 {

	private static final int MSB_VALUE = 128;
	private DataOutputStream outputStream;
	private byte currentByte;
	private int currentBitVal;

	public BitOutputStream2(File file) {
		currentBitVal = 1;
		try {
			outputStream = new DataOutputStream(new FileOutputStream(file));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void writeBit(char bit) throws IllegalArgumentException {
		switch (bit) {
			case '1':
				currentByte += currentBitVal;
			case '0':
				currentBitVal *= 2;
				break;
			default:
				throw new IllegalArgumentException("The bit must be either 0 or 1");
		}
		if (currentBitVal > MSB_VALUE) flush();
	}

	public void writeBit(String bits) {
		for (int i = 0; i < bits.length(); i++)
			writeBit(bits.charAt(i));
	}

	private void flush() {
		try {
			outputStream.writeByte(currentByte);
			currentBitVal = 1;
			currentByte = 0;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		int temp = currentBitVal;
		while (temp <= MSB_VALUE) {
			writeBit('1');
			temp *= 2;
		}
		try {
			outputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
