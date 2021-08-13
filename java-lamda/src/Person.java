import java.util.List;

public class Person {

    String name;
    int age;
    Sex gender;
    String emailAddress;
	public Person(String name, int age, Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Sex getGender() {
		return gender;
	}
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", emailAddress=" + emailAddress + "]";
	}
	
	public void printPerson() {
		System.out.println("Person [name=" + name + ", age=" + age + ", gender=" + gender + ", emailAddress=" + emailAddress + "]");
	}

}
