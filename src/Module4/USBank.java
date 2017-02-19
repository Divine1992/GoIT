package Module4;

public class USBank extends Bank{

    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if (super.getCurrency() == Currency.EUR) {
            return 1200;
        }
        return 1000;
    }

    @Override
    public int getLimitOfFunding() {
        if (super.getCurrency() == Currency.EUR){
            return 10_000;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public int getMonthlyRate() {
        if (super.getCurrency() == Currency.EUR){
            return 2;
        }
        return 1;
    }

    @Override
    public int getCommission(int summ) {
        if (super.getCurrency() == Currency.EUR){
            if (summ > 1000){
                return 8;
            } else return 6;
        } else {
            if (summ > 1000) return 7;
        }
        return 5;
    }
}
