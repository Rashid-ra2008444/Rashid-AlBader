package P10;

public class Person {
    private String name;
    private String id;
    private String BOD;
    private Genders gender;

    public Person(String name, String id, String BOD, Genders gender) {
        setName(name);
        setId(id);
        setGender(gender);
        setBOD(BOD);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBOD() {
        return BOD;
    }

    public void setBOD(String BOD) {
        this.BOD = BOD;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }
}
