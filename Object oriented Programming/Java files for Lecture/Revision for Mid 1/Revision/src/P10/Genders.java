package P10;

public enum Genders {
    Male(0.15),
    Female(0.10);
    private double tax;
    Genders(double tax) {
        setTax(tax);
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
}
