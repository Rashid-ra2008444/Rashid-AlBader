package P1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex1 {

    public String getDataInSpecificYear(int year){
        String data = "";
        try {
            File f = new File("Hello.txt");
            Scanner sc = new Scanner(f);
            String line= "";
            while(sc.hasNext()) {
                line = sc.nextLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return data ;
    }
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Hello.txt");
        Scanner in = new Scanner(f);
        String line = "";
        while (in.hasNext()) {
            line = in.nextLine();
        }
    }

}
