package org.example.q6;

public class DO {
    String name;
    String ID;
    TYPE userType;

    public DO( String name, String ID,TYPE userType) {
        setName(name);
        setID(ID);
        setUserType(userType);
    }

    public TYPE getUserType() {
        return userType;
    }

    public void setUserType(TYPE userType) {
        this.userType = userType;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
