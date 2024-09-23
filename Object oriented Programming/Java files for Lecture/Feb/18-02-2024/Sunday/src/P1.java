import java.util.regex.Pattern;

public class P1 {


    public boolean isValidAddress(String address){
        // address should be "zone-houseNum-streetNum-postCode
        String[] add = address.split("-");

        if(add.length!=4){
            return false;
        }
        for(String item : add) {
            for(char c : item.toCharArray()){
                if(!Character.isDigit(c)){
                    return false;
                }
            }
        }
//        return true;
        return Pattern.matches("\\d+-\\d+-\\d+-\\d+",address);
    }

    private boolean isValid(String id){
        //notice private method. helper method for this calss only
        // id is 22 chars: first two are alphabets followed by "Q" followed by a digit that is
        // ether 0 or 1, followed by a digit that is ether 1 ,2 or 3, followed by
        // three alphabets followed by three zeros followed by ":" followed by 10 digits numbers.
        // check the validity for the id. return T or F
        return Pattern.matches("\\p{Alpha}{2}Q[01][123]\\p{Alpha}{3}000:\\d{10}",id);
    }

    public static void main(String[] args){



    }
}
