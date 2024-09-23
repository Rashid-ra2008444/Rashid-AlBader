package P1;

public class Employee extends Person{
	private int noOfChildren;
	
	public Employee(String name, int id,int noOfChildren) {
		super(name, id);
        this.noOfChildren = noOfChildren;
	}
	
	public Employee() {}
	
	public int getNoOfChildren() {
        return noOfChildren;
    }
	
	public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }
	
	@Override
	public String toString() {
		return String.format("%s\nnoOfChildren = %d", super.toString(), noOfChildren);
	}
}
