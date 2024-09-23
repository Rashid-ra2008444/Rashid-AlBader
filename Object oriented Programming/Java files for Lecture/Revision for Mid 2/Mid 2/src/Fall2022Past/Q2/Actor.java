package Fall2022Past.Q2;

public class Actor {
    private String name;
    private String gender; //"Male" or "Female"
    public Actor() { }
    public Actor(String name, String gender) {
        setName(name);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
