package Module4;

public class ChinaBank extends Bank{

    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if (super.getCurrency() == Currency.EUR) {
            return 150;
        }
        return 100;
    }

    @Override
    public int getLimitOfFunding() {
        if (super.getCurrency() == Currency.EUR){
            return 5_000;
        }
        return 10_000;
    }

    @Override
    public int getMonthlyRate() {
        if (super.getCurrency() == Currency.EUR){
            return 0;
        }
        return 1;
    }

    @Override
    public int getCommission(int summ) {
        if (super.getCurrency() == Currency.EUR){
            if (summ > 1000){
                return 11;
            } else return 10;
        } else {
            if (summ > 1000) return 5;
        }
        return 3;
    }
}
