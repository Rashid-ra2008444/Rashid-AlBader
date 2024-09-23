package org.example.q6;

public abstract class SystemUser {
    String userName;
    String password;

    public abstract String getUserID();

    public boolean validate(String username_temp, String password_temp){
        return username_temp.equals(userName) && password_temp.equals(password);
    }

    public String getID(SystemUser other){
        return other.getUserID();
    }
}
