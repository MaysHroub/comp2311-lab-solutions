package labs1_5;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Tawjihi extends Student implements Comparable<Tawjihi> {
	private int seatingNum;
	private int year;
	private ArrayList<Subject> subjects;

	public Tawjihi(int seatingNum, int id, String name, char gender, String school) {
		super(id, name, gender, school);
		setSeatingNum(seatingNum);
		year = 2022;
		subjects = new ArrayList<>();
	}

	public Tawjihi() {
		this(0, 0, "", FEMALE, "");
	}
	
	public abstract double calculateAverage();

	public void addSubject(Subject subject) {
		subjects.add(subject);
	}

	public Subject getSubject(String title) {
		for (Subject subject : subjects)
			if (subject.getTitle().equalsIgnoreCase(title))
				return subject;
		return null;
	}

	public int getSeatingNum() {
		return seatingNum;
	}

	public void setSeatingNum(int seatingNum) {
		this.seatingNum = seatingNum;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year >= 1950)
			this.year = year;
		else
			System.out.println("Invalid year");
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		Collections.addAll(this.subjects, (Subject[]) subjects.toArray());
	}

	@Override
	public int compareTo(Tawjihi o) {
		return (int) (calculateAverage() - o.calculateAverage());
	}

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract String toString();
}
