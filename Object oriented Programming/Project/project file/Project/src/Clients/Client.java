package Clients;

import java.io.*;

public  class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    static int AUTOID = 1000;

    public Client() {
        initializeAutoID();
    }

    public Client(String name) {
        this();
        setId(++AUTOID);
        setName(name);
        saveAutoID();
    }

    public String toString() {
        return String.format("ID: %d , Name: %s", id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if( id != 0 ) {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if( name != null ) {
            this.name = name;
        }
    }

    private static void initializeAutoID(){
        try(BufferedReader reader = new BufferedReader(new FileReader("ClientsID.txt"))){
            String line = reader.readLine();
            if(line != null){
                AUTOID = Integer.parseInt(line);
            }
        } catch (IOException | NumberFormatException e){
            System.err.println("Failed to read autoID: "+e.getMessage());
            AUTOID = 1000;
        }
    }
    private void saveAutoID(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("ClientsID.txt"))){
            writer.write(String.valueOf(AUTOID));
        } catch (IOException e){
            System.err.println("Failed to save autoID: "+e.getMessage());
        }
    }
}
