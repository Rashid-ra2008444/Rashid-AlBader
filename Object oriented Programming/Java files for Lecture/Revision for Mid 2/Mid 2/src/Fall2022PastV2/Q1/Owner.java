package Fall2022PastV2.Q1;

public class Owner {
    private String name;
    private String id;


    public Owner(){}

    public Owner(String name){
        setName(name);
    }
    public Owner(String name, String id){
        this(name);
        setId(id);
    }



    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }
}
