import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class P3 {


// Will code this Later "From Quiz 3 practice"

    public static void main(String[] args)  {

        try {
            FileInputStream fileReader = new FileInputStream("stdinfo.txt");

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found dummy");
        }

    }
}
