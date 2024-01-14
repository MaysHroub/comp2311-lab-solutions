package labs1_5;


public abstract class Student extends Human {
	private int ID;
	private String school;

	public Student(int id, String name, char gender, String school) {
		super(name, gender);
		setId(id);
		setSchool(school);
	}
	
	@Override
	public String toString() {
		return "ID=" + ID + ", name=" + getName() + ", gender=" + getGender() + ", school=" + school;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		if (String.valueOf(id).length() == 9)
			this.ID = id;
		else
			System.out.println("The ID must consisit of 9 digits");
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}
