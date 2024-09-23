package Ex1;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Scanner;

public class Ex2 {
    String code;
    String category;
    int quantity;
    double unitPrice;
    LocalDate expiredDate;
    public Ex2() {}

    public Ex2(String code, String category, int quantity, double unitPrice, LocalDate expiredDate) {
        this.code = code;
        this.category = category;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.expiredDate = expiredDate;
    }

    public void readLines() throws Exception{
        File file = new File("product.txt");
        Scanner sc = new Scanner(file);
        String line = sc.nextLine();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("expired.dat"));
        Object o = ois.readObject();

        while(o != null) {

        }
    }

}
