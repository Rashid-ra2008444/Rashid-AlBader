package Shipments;

import Clients.Client;
import Payments.Payment;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shipment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String shipmentCode;
    private LocalDate registrationDate;
    private double weight;
    private double shippingCost;
    private Client shipper;
    private Destination destination;
    private ShippingWays shippingWay;
    static int AUTOID = 1000;
    private double paid;

    public Shipment(){
        initializeAutoID();
    }

    public Shipment(double weight,double shippingCost ,ShippingWays shippingWay,Client shipper,Destination destination, double paid) {
        this();
        setShipmentCode("Ship"+(++AUTOID));
        setRegistrationDate(LocalDate.now());
        setWeight(weight);
        setShipper(shipper);
        setShippingCost(shippingCost);
        setDestination(destination);
        setShippingWay(shippingWay);
        List<Payment> paymentWay = new ArrayList<>(); // it is useless by the way since it is not used here only in the main app
        setPaid(paid);
        saveAutoID();
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public String toString() {
        return String.format("Shipment Code: %s , Registration Date: %s , Weight: %.2f , Shipping Cost: %.2f , Shipper: %s , Destination: %s , Shipping way: %s ",
                getShipmentCode(),getRegistrationDate(),getWeight(),getShippingCost(),getShipper(),getDestination(),getShippingWay() );
    }



    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        if(destination != null) {
            this.destination = destination;
        }
    }
    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        if(shipmentCode != null) {
            this.shipmentCode = shipmentCode;
        }
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        if(registrationDate != null ) {
            this.registrationDate = registrationDate;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight > 0) {
            this.weight = weight;
        }
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        if(shippingCost > 0) {
            this.shippingCost = shippingCost;
        }
    }

    public Client getShipper() {
        return shipper;
    }

    public void setShipper(Client shipper) {
        if(shipper != null) {
            this.shipper = shipper;
        }
    }

    public ShippingWays getShippingWay() {
        return shippingWay;
    }

    public void setShippingWay(ShippingWays shippingWay) {
        if(shippingWay != null) {
            this.shippingWay = shippingWay;
        }
    }

    public boolean isFullyPaid(){
        return getPaid() == getShippingCost();
    }
    public double getTotalPaid(){
        return getPaid();
    }

    private static void initializeAutoID(){
        try(BufferedReader reader = new BufferedReader(new FileReader("ShipmentsID.txt"))){
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
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("ShipmentsID.txt"))){
            writer.write(String.valueOf(AUTOID));
        } catch (IOException e){
            System.err.println("Failed to save autoID: "+e.getMessage());
        }
    }
}
