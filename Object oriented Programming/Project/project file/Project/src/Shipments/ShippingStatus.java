package Shipments;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class ShippingStatus implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private LocalDate shippingDate;
    private LocalDate receivingDate;
    private Shipment shipment;

    public ShippingStatus(LocalDate shippingDate, LocalDate receivingDate , Shipment shipment) {
        setShippingDate(shippingDate);
        setReceivingDate(receivingDate);
        setShipment(shipment);
    }


    public String toString() {
        return String.format("Shipping Date : %s, Receiving Date : %s\nShipment: %s",getShippingDate(),getReceivingDate(),getShipment().toString());
    }


    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public LocalDate getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(LocalDate receivingDate) {
        this.receivingDate = receivingDate;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
