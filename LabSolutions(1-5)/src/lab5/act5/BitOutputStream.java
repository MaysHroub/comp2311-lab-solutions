package lab5.act5;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitOutputStream {
	private static final int MAX_BIT_INDEX = 7;
	private DataOutputStream outputStream;
	private byte currentByte;
	private int currentBitIndex;

	public BitOutputStream(File file) throws FileNotFoundException {
		outputStream = new DataOutputStream(new FileOutputStream(file));
	}
	
	public void writeBit(char bit) throws IllegalArgumentException, IOException {
		if (bit != '0' && bit != '1')
			throw new IllegalArgumentException("The bit must be either 0 or 1");
		
		currentByte <<= 1;
		currentByte |= (bit - '0');
		currentBitIndex++;
		if (currentBitIndex > MAX_BIT_INDEX) flush();
	}

	public void writeBit(String bits) throws IllegalArgumentException, IOException {
		for (int i = 0; i < bits.length(); i++)
			writeBit(bits.charAt(i));
	}

	private void flush() throws IOException {
		outputStream.writeByte(currentByte);
		currentBitIndex = 0;
		// currentByte = 0; or currentByte &= 0; (BUT there's NO need to do that...)
	}

	public void close() throws IOException {
		if (currentBitIndex > 0) {
			currentByte <<= (MAX_BIT_INDEX - currentBitIndex + 1);
			flush();			
		}
		outputStream.close();
	}
	
}
