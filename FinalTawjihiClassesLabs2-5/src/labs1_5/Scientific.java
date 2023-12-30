package labs1_5;

import java.io.Serializable;

public class Scientific extends Tawjihi {

	public Scientific(int seatingNum, int id, String name, char gender, String school) {
		super(seatingNum, id, name, gender, school);
	}

	@Override
	public double calculateAverage() {
		int sum = 0;
		int maxElec1 = 0, maxElec2 = 0;
		for (Subject subject : getSubjects())
			if (subject.getType().equals(Subject.MANDATORY))
				sum += subject.getMark();
			else if (subject.getType().equals(Subject.ELECTIVE_1))
				maxElec1 = Math.max(maxElec1, subject.getMark());
			else if (subject.getType().equals(Subject.ELECTIVE_2))
				maxElec2 = Math.max(maxElec2, subject.getMark());

		sum += maxElec1;
		sum += maxElec2;

		return sum / 6.0;
	}

	@Override
	public String toString() {
		return String.format("SCIENTIFIC) seating number: %d, name: %s, avg: %.2f", getSeatingNum(), getName(),
				calculateAverage());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Scientific))
			return false;
		return calculateAverage() == ((Literary) obj).calculateAverage();
	}

}
