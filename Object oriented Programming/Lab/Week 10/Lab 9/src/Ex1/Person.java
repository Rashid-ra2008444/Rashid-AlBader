package Ex1;

import java.time.LocalDate;

public class Person {
	private String name;
	private LocalDate birthDate;
	private Gender gender;

	public Person() {
	}

	public Person(String name, LocalDate birthDate, Gender gender) {
		setName(name);
		setBirthDate(birthDate);
		setGender(gender);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
