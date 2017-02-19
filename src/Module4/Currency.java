package Module4;

public enum Currency {
    USD(1.06), EUR(0.94);

    public double value;

    private Currency(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
