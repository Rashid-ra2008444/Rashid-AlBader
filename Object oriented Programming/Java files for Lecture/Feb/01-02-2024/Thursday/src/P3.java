public class P3 {

    public static int sumArray(int[] x){
        int s = 0;
        for(int i = 0; i < x.length; i++){
            s+=x[i];
        }
        return s;
    }

    public static int sumArray2(int[] x){
        int s = 0;
        for(int i : x){
            s+=i;
        }
        return s;
    }


    public static void main(String[] args){

    }


}
