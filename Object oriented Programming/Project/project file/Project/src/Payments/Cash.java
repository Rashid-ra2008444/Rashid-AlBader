package Payments;

public class Cash  implements Payment{

    private double paidAmount;

    public Cash(double paidAmount) {
        setPaidAmount(paidAmount);
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        if(paidAmount > 0 ) {
            this.paidAmount = paidAmount;
        }
    }



    @Override
    public double calcPaymentAmount() {
        return getPaidAmount();
    }
}
