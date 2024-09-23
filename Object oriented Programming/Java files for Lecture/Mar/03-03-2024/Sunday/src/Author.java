public class Author {
    private String name;
    private String address;

    public Author() { }

    public Author(String name, String address) {
        setName(name);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
