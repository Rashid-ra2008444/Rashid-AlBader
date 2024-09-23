package Shipments;

import java.io.*;

public class Destination implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String destCode;
    private String destName;
    private double airCost1stKilo;
    private double airCostEachAddHalf;
    private double groundShippingDiscount;
    private double seaShippingDiscount;
    static int AUTOID = 1000;

    static {
        initializeAutoID();
    }

    public Destination(String destCode, String destName, double airCost1stKilo, double airCostEachAddHalf, double groundShippingDiscount, double seaShippingDiscount) {
        AUTOID++;
        setDestCode(destCode+(AUTOID));
        setDestName(destName);
        setAirCost1stKilo(airCost1stKilo);
        setAirCostEachAddHalf(airCostEachAddHalf);
        setGroundShippingDiscount(groundShippingDiscount);
        setSeaShippingDiscount(seaShippingDiscount);
        saveAutoID();
    }

    public String toString() {
        return String.format("Destination Code: %s , Destination Name: %s , Air Cost at first kilometer: %.2f , Air Cost Each Add Half: %.2f , Ground shipping discount: %.2f , Sea shipping discount: %.2f",
                getDestCode(), getDestName(), getAirCost1stKilo(), getAirCostEachAddHalf(), getGroundShippingDiscount(), getSeaShippingDiscount());
    }

    public String getDestCode() {
        return destCode;
    }

    public void setDestCode(String destCode) {
        if(destCode != null){
            this.destCode = destCode;
        }
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        if(destName != null) {
            this.destName = destName;
        }
    }

    public double getAirCost1stKilo() {
        return airCost1stKilo;
    }

    public void setAirCost1stKilo(double airCost1stKilo) {
        if(airCost1stKilo > 0) {
            this.airCost1stKilo = airCost1stKilo;
        }
    }

    public double getAirCostEachAddHalf() {
        return airCostEachAddHalf;
    }

    public void setAirCostEachAddHalf(double airCostEachAddHalf) {
        if(airCostEachAddHalf > 0) {
            this.airCostEachAddHalf = airCostEachAddHalf;
        }
    }

    public double getGroundShippingDiscount() {
        return groundShippingDiscount;
    }

    public void setGroundShippingDiscount(double groundShippingDiscount) {
        if(groundShippingDiscount > 0) {
            this.groundShippingDiscount = groundShippingDiscount;
        }
    }

    public double getSeaShippingDiscount() {
        return seaShippingDiscount;
    }

    public void setSeaShippingDiscount(double seaShippingDiscount) {
        if(seaShippingDiscount > 0) {
            this.seaShippingDiscount = seaShippingDiscount;
        }
    }


    private static void initializeAutoID(){
        try(BufferedReader reader = new BufferedReader(new FileReader("DestinationsID.txt"))){
            String line = reader.readLine();
            if(line != null){
                AUTOID = Integer.parseInt(line);
            }
        } catch (IOException | NumberFormatException e){
            System.err.println("Failed to read autoID: "+e.getMessage());
            AUTOID = 1000;
        }
    }
    private void saveAutoID(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("DestinationsID.txt"))){
            writer.write(String.valueOf(AUTOID));
        } catch (IOException e){
            System.err.println("Failed to save autoID: "+e.getMessage());
        }
    }

}
