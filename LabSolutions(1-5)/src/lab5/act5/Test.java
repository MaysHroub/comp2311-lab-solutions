package lab5.act5;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		File file = new File("mydata.dat");
		BitOutputStream out = new BitOutputStream(file);
		// 1110 1001   0101 1110   0010 0000
		// 233         94          32
		out.writeBit('1');
		out.writeBit("110100101011110001");
		out.close();

		// to check...
		try (DataInputStream in = new DataInputStream(new FileInputStream(file));) {
			while (in.available() > 0)
				System.out.println(in.read());

		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
