package Thursday_Practice;

public class User {
    private String name;
    private String username;
    private String password = "12345678";

    public User(String name, String username) {
        setName(name);
        setUsername(username);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return String.format("Name: %s, Username: %s\n", name, username);
    }
}
