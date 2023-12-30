package labs1_5;

import java.io.Serializable;

public class Subject implements Comparable<Subject>, Serializable {

	public static final String MANDATORY = "Mandatory";
	public static final String ELECTIVE_1 = "Elective1";
	public static final String ELECTIVE_2 = "Elective2";

	private static final int MAND = 1;
	private static final int ELEC = 0;

	private String title;
	private String type;
	private int mark;
	private int maxMark;

	public Subject(String title, String type, int mark) {
		setTitle(title);
		setType(type);
		setMark(mark);
		maxMark = 100;
	}

	public Subject(String title, String type, int mark, int maxMark) {
		setTitle(title);
		setType(type);
		setMark(mark);
		setMaxMark(maxMark);
	}
	
	@Override
	public String toString() {
		return "Subject [title: " + title + ", type: " + type + ", mark: " + mark + "]";
	}

	public int getMaxMark() {
		return maxMark;
	}

	public void setMaxMark(int maxMark) {
		if (maxMark == 100 || maxMark == 200 || maxMark == 150)
			this.maxMark = maxMark;
		else {
			maxMark = 100;
			System.out.println("Invalid input. Hence, MaxMark is set to 100");
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (type.equals(MANDATORY) || type.equals(ELECTIVE_1) || type.equals((ELECTIVE_2)))
			this.type = type;
		else
			System.out.printf("The type must be either %s, %s, or %s\n", MANDATORY, ELECTIVE_1, ELECTIVE_2);
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		if (mark >= 0 && mark <= 200)
			this.mark = mark;
		else
			System.out.println("The mark must be between [0-200] (depending on the type of the subject)");
	}

	// ordered according to the type.
	// we were requested to implement this method differently...
	@Override
	public int compareTo(Subject o) {
		int type1 = (type.equalsIgnoreCase(MANDATORY)) ? MAND : ELEC;
		int type2 = (o.type.equalsIgnoreCase(MANDATORY)) ? MAND : ELEC;
		return type1 - type2;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Subject))
			return false;
		return title.equalsIgnoreCase(((Subject) obj).title);
	}

}
