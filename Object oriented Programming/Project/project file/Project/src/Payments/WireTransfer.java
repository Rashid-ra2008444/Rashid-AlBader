package Payments;

public class WireTransfer implements Payment{

    private double paidAmount;

    public WireTransfer(double paidAmount) {
        setPaymentAmount(paidAmount);
    }

    @Override
    public double calcPaymentAmount() {
        return getPaymentAmount()+100;
    }


    public void setPaymentAmount(double paidAmount) {
        if(paidAmount > 0) {
            this.paidAmount = paidAmount;
        }
    }

    public double getPaymentAmount() {
        return paidAmount ;
    }

}
