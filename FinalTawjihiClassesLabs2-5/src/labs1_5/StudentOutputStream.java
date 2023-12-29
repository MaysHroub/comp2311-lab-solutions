package labs1_5;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class StudentOutputStream {

	private DataOutputStream outputStream;

	public StudentOutputStream(File file) throws FileNotFoundException {
		outputStream = new DataOutputStream(new FileOutputStream(file, true));
	}

	public void wrtieInfo(Tawjihi student) throws IOException {
		outputStream.writeInt(student.getId());
		outputStream.writeUTF(student.getName());
		outputStream.writeChar(student.getGender());
		outputStream.writeUTF(student.getSchool());
		outputStream.writeUTF(student.getClass().getSimpleName());
		outputStream.writeInt(student.getSeatingNum());
		outputStream.writeInt(student.getYear());
		
		ArrayList<Subject> subjects = student.getSubjects();
		outputStream.writeInt(subjects.size());
		
		for (Subject subject : subjects) {
			outputStream.writeUTF(subject.getTitle());
			outputStream.writeUTF(subject.getType());
			outputStream.writeInt(subject.getMark());
			outputStream.writeInt(subject.getMaxMark());
		}

	}

	public void close() throws IOException {
		outputStream.close();
	}

}
