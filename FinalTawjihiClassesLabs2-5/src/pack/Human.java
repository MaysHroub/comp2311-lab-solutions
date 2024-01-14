package labs1_5;

import java.io.Serializable;

public abstract class Human implements HumanBeing, Serializable {
	private String name;
	private char gender;

	public Human(String name, char gender) {
		setName(name);
		setGender(gender);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() > 2)
			this.name = name;
		else
			System.out.println("The name must be at least 3 characters long");
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		if (gender == MALE || gender == FEMALE)
			this.gender = gender;
		else {
			this.gender = FEMALE;
			System.out.println("Invalid input. Hence, the gender is set to 'F'");
		}
	}
}








