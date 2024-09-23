package Ex1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class fileWriterObject {
    Formatter formatter;
    FileWriter fileWriter;
    File file;
    Scanner scanner = new Scanner(System.in);

    public fileWriterObject(){
        try {
            file = new File("file.txt");
            fileWriter = new FileWriter(file, true);
            formatter = new Formatter(fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
