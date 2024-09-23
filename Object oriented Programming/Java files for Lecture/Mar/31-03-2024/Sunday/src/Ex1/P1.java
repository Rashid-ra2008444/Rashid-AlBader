package Ex1;
import java.io.*;

public class P1 implements Serializable{

    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.dat"));

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.dat"));

        Object o = ois.readObject();


    }



}
