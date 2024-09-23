package P1;

public class Person {

	private String name;
	private int id;
	
	public Person(String name, int id) {
		setName(name);
		setId(id);
		//System.out.println("Person Constructoe Being Called");
	}
	
	public Person() {
       super();
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return String.format("id=%d\nname=%s", id,name);
	}
	
	
}
