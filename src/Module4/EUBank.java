package Module4;

public class EUBank extends  Bank{

    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if (super.getCurrency() == Currency.EUR) {
            return 2200;
        }
        return 2000;
    }

    @Override
    public int getLimitOfFunding() {
        if (super.getCurrency() == Currency.EUR){
            return 20_000;
        }
        return 10_000;
    }

    @Override
    public int getMonthlyRate() {
        if (super.getCurrency() == Currency.EUR){
            return 1;
        }
        return 0;
    }

    @Override
    public int getCommission(int summ) {
        if (super.getCurrency() == Currency.EUR){
            if (summ > 1000){
                return 4;
            } else return 2;
        } else {
            if (summ > 1000) return 7;
        }
        return 5;
    }
}
