package Ex1;

import java.util.ArrayList;

public class Util {

    public static void quiz4L03(ArrayList<EDevice> devices) {
        int countAc = 0 , countSmartPhone = 0;
        for(EDevice ed : devices) {
            ed.switchOn();

            if(ed instanceof AC){
                AC ac = (AC) ed;
                ac.temp = 20;
                countAc++;
            }
            else {
                SmartPhone sph = (SmartPhone) ed;
                sph.radioOn = true;
                sph.switchChannel(102.6);
                countSmartPhone++;
            }
        }
        System.out.println("AC: "+countAc+" SmartPhone: "+countSmartPhone);
    }
}
