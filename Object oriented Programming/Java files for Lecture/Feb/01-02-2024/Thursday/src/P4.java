public class P4 {

    public static int switchStat1(int x){
        int y = 0;
        switch(x) {
            case 1,2,3 -> y=5+x;
            case 4 -> y=10;
            default -> y=-2;
        }
        return y;
    }

    public static void main(String[] args){

    }

}
