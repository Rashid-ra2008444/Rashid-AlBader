package Payments;

public class Check implements Payment{
    private double paidAmount;

    public Check(double paidAmount) {
        setPaymentAmount(paidAmount);
    }

    @Override
    public double calcPaymentAmount() {
        return getPaymentAmount();
    }

    public double getPaymentAmount() {
        return paidAmount;
    }

    public void setPaymentAmount(double paidAmount) {
        if(paidAmount>0) {
            this.paidAmount = paidAmount;
        }
    }
}
