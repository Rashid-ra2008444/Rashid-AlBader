package P7;

public class Owner {
    private String name;
    private String id;
    public Owner(String name) {
        setName(name);
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
