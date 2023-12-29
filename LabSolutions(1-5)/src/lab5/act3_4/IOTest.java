package lab5.act3_4;

import java.io.*;

public class IOTest {

	public static void main(String[] args) throws IOException {
		File file = new File("data.dat");

		int numberOfInts = 100;

		writeTo(file, numberOfInts);
		printSumAvg(file);
	}

	private static void printSumAvg(File file) throws IOException {
		int sum = 0, count = 0;
		try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
			while (in.available() > 0) {
				sum += in.readInt();
				count++;
			}

		}
		if (count == 0) {
			System.out.println("There's no data...");
			return;
		}
		System.out.printf("Sum of integers: %d\nAvg: %.2f\n", sum, (double) sum / count);
	}

	private static void writeTo(File file, int n) throws IOException {
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file, true))) {
			for (int i = 0; i < n; i++)
				out.writeInt(55 + (int) (Math.random() * 45));
		}
	}

}
