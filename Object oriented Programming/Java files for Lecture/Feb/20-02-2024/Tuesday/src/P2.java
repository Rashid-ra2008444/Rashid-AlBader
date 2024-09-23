import java.util.Arrays;

public class P2 {

    public static void main(String[] args){

        //2d array
        //int[][] b = new int[3][4];

        int[][] b= {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};


        for(var insideOf : b){
            int column=0;
            for(var deepInsideOf : insideOf){
                System.out.printf("[%d,%d]\t", column, deepInsideOf);
                column++;
            }
            System.out.println(" ");
        }
    }


}
