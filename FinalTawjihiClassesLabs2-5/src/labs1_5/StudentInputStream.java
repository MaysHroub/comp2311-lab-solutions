package labs1_5;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class StudentInputStream {

	private DataInputStream inputStream;

	public StudentInputStream(File file) throws FileNotFoundException {
		inputStream = new DataInputStream(new FileInputStream(file));
	}

	public ArrayList<Tawjihi> readInfo() throws IOException {
		ArrayList<Tawjihi> students = new ArrayList<>();
		while (inputStream.available() > 0) {
			int id = inputStream.readInt();
			String name = inputStream.readUTF();
			char gender = inputStream.readChar();
			String school = inputStream.readUTF();
			String branch = inputStream.readUTF();
			int seatingNum = inputStream.readInt();
			int year = inputStream.readInt();
			int numOfSubjects = inputStream.readInt();
			Tawjihi student;
			if (branch.equalsIgnoreCase(Scientific.class.getSimpleName()))
				student = new Scientific(seatingNum, id, name, gender, school);
			else
				student = new Literary(seatingNum, id, name, gender, school);

			student.setYear(year);

			while (numOfSubjects-- > 0) {
				String title = inputStream.readUTF();
				String type = inputStream.readUTF();
				int mark = inputStream.readInt();
				int maxMark = inputStream.readInt();
				student.addSubject(new Subject(title, type, mark, maxMark));
			}
			students.add(student);
		}
		return students;
	}

	public void close() throws IOException {
		inputStream.close();
	}

}
