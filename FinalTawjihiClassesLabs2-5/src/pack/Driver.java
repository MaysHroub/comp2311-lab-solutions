package labs1_5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Driver {

	public static void main(String[] args) throws IOException {
		ArrayList<Tawjihi> students = new ArrayList<>(6);

		Tawjihi student1 = new Scientific(101, 100000000, "John Doe", 'M', "Example High School");
		Tawjihi student2 = new Scientific(102, 200000000, "Jane Doe", 'F', "Sample High School");
		Tawjihi student3 = new Scientific(103, 300000000, "Alex Smith", 'M', "Test High School");
		Tawjihi student4 = new Literary(104, 400000000, "Emily Johnson", 'F', "Demo High School");
		Tawjihi student5 = new Literary(105, 500000000, "Chris Williams", 'M', "School of Excellence");
		Tawjihi student6 = new Literary(106, 600000000, "Emma Brown", 'F', "Learning Academy");
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);

		String[] sciSubjects = { "Arabic", "English", "Physics", "Math", "Biology", "Chemistry", "Religious Education",
				"Technology" };
		String[] litSubjects = { "Arabic", "English", "Physics", "History", "Geography", "Religious Education",
				"Scientific Culture", "Technology" };

		String[] subjectTypes = { Subject.MANDATORY, Subject.MANDATORY, Subject.MANDATORY, Subject.MANDATORY,
				Subject.ELECTIVE_1, Subject.ELECTIVE_1, Subject.ELECTIVE_2, Subject.ELECTIVE_2 };

		int a = 50, b = 100;
		for (int i = 0; i < students.size(); i++) {
			for (int j = 0; j < subjectTypes.length; j++) {
				int mark = a + (int) (Math.random() * (b - a + 1));
				String subjName = (i < 2) ? sciSubjects[j] : litSubjects[j];
				students.get(i).addSubject(new Subject(subjName, subjectTypes[j], mark));
			}
		}
		
		displayAllAvg(students);
		System.out.println("#####################");
		displayTopStdInEachBranch(students);
		System.out.println("#####################");
		displayStdsInDescendingOrder(students);
		System.out.println("#####################");
		System.out.println("Subjects for the first student ordered:"); // ordered based on the type...
		displaySubjectsInAscendingOrder(students.get(0).getSubjects());
	}

	private static void displaySubjectsInAscendingOrder(ArrayList<Subject> subjects) {
		ArrayList<Subject> subs = (ArrayList<Subject>) subjects.clone();
		Collections.sort(subs);
		for (Subject subj : subs) 
			System.out.println(subj);
	}

	private static void displayStdsInDescendingOrder(ArrayList<Tawjihi> students) {
		System.out.println("Students in descending order:");
		ArrayList<Tawjihi> stds = (ArrayList<Tawjihi>) students.clone();
		Collections.sort(stds);
		for (int i = stds.size() - 1; i >= 0; i--)
			System.out.println(stds.get(i));
	}

	private static void displayAllAvg(ArrayList<Tawjihi> students) {
		for (Tawjihi std : students)
			System.out.println(std);
//			System.out.printf("%-10s : %-15s : %.2f\n", std.getClass().getSimpleName(), std.getName(),
//					std.calculateAverage());
	}

	private static void displayTopStdInEachBranch(ArrayList<Tawjihi> students) {
		double topSciAvg = 0, topLitAvg = 0;
		String sciTopName = "", litTopName = "";
		for (Tawjihi std : students) {
			double avg = std.calculateAverage();
			if (std instanceof Scientific) {
				if (topSciAvg < avg) {
					topSciAvg = avg;
					sciTopName = std.getName();
				}
			} else if (topLitAvg < avg) {
				topLitAvg = avg;
				litTopName = std.getName();
			}
		}
		System.out.printf("Top student in Scientific Branch: %s with an avg of %.2f\n", sciTopName, topSciAvg);
		System.out.printf("Top student in Literary Branch: %s with an avg of %.2f\n", litTopName, topLitAvg);
	}

}
