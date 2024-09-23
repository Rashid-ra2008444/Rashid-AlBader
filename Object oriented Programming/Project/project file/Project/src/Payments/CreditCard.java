package Payments;

public class CreditCard implements Payment{
    private double paidAmount;

    public CreditCard(double paidAmount) {
        setPaidAmount(paidAmount);
    }


    @Override
    public double calcPaymentAmount() {
        return getPaymentAmount() * 1.025;
    }


    public void setPaidAmount(double payAmount) {
        if(payAmount > 0) {
            this.paidAmount = payAmount;
        }
    }

    public double getPaymentAmount() {
        return paidAmount ;
    }
}
