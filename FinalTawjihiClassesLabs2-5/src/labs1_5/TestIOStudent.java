package labs1_5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestIOStudent {

	public static void main(String[] args) throws IOException {
		Tawjihi student1 = new Scientific(101, 100000000, "Baraa", 'M', "Majed Abu Sharar School");
		Tawjihi student2 = new Literary(102, 200000000, "Mays Alreem", 'F', "Dura Secondary School");

		String[] sciSubjects = { "Arabic", "English", "Physics", "Math", 
				"Biology", "Chemistry", "Religious Education", "Technology" };
		String[] litSubjects = { "Arabic", "English", "Physics", "History",
				"Geography", "Religious Education",
				"Scientific Culture", "Technology" };

		String[] subjectTypes = { Subject.MANDATORY, Subject.MANDATORY, 
				Subject.MANDATORY, Subject.MANDATORY,
				Subject.ELECTIVE_1, Subject.ELECTIVE_1, 
				Subject.ELECTIVE_2, Subject.ELECTIVE_2 };

		int a = 50, b = 100;
		for (int j = 0; j < subjectTypes.length; j++) {
			int mark = a + (int) (Math.random() * (b - a + 1));
			student1.addSubject(new Subject(sciSubjects[j], subjectTypes[j], mark));
			student2.addSubject(new Subject(litSubjects[j], subjectTypes[j], mark));
		}

		File file = new File("Tawjihi.dat");
		
		try (StudentOutputStream out = new StudentOutputStream(file);
			StudentInputStream in = new StudentInputStream(file);) {
			// write the two students' info to the file
			out.writeInfo(student1);
			out.writeInfo(student2);
			
			// read the two students' info from the file and print them on the console
			ArrayList<Tawjihi> stds = in.readInfo();
			System.out.println(stds.get(0));
			System.out.println(stds.get(1));
		} 
		
		// use Object Out/In Stream to perform IO operations on a student object
		File file2 = new File("Tawjihi2.dat");
		try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2));
			    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file2)); )
		{
			System.out.println("\nUsing Object Output/Input Stream:");
			oos.writeObject(student1);		
			Tawjihi std = (Scientific) ois.readObject();
			System.out.println(std);
			System.out.println(std.getSubjects());
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		
	}

}







