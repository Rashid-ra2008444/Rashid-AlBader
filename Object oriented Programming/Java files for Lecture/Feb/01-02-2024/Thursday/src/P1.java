public class P1 {
    public static int sum(int x){
        int sum =0;
        for(int i=1 ; i <= x ; i++){
            sum+=i;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(sum(10));
    }
}
