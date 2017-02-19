package Module4;


public class BankSystemImpl implements BankSystem{

    @Override
    public void withdrawOfUser(User user, int amount) {
        if (amount > user.getBank().getLimitOfWithdrawal()){
            System.out.println("Sorry you can't withdraw this totality because your limit is "+user.getBank().getLimitOfWithdrawal()+" "+user.getBank().getCurrency());
            return;
        }
        if (user.getBalance() < amount + user.getBank().getCommission(amount)) {
            System.out.println("Not enough money for this operation");
            return;
        }
        user.getBank().setTotalCapital(user.getBank().getTotalCapital() + (long)(amount * ((double)user.getBank().getCommission(amount) / 100)));
        user.setBalance(user.getBalance() - (amount + amount * ((double)user.getBank().getCommission(amount) / 100)));
    }

    @Override
    public void fundUser(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()){
            System.out.println("Sorry you can't add your balance because your limit is "+user.getBank().getLimitOfFunding()+" "+user.getBank().getCurrency());
            return;
        }

        user.getBank().setTotalCapital(user.getBank().getTotalCapital() + (long)(amount * ((double)user.getBank().getCommission(amount) / 100)));
        user.setBalance(user.getBalance() + (amount - amount * ((double)user.getBank().getCommission(amount) / 100)));
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {  // Current rate USD ~ EUR / (1.06 ~ 0.94) :19/02/2017
        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()){
            if (fromUser.getBank().getCurrency() == Currency.USD){
                if (fromUser.getBalance() < (amount + Currency.USD.getValue() * amount * ((double)fromUser.getBank().getCommission(amount) / 100))) {
                    System.out.println("Not enough money for this operation");
                    return;
                }
                fromUser.setBalance(fromUser.getBalance() - (amount + Currency.USD.getValue() * amount * ((double)fromUser.getBank().getCommission(amount) / 100)));
                fromUser.getBank().setTotalCapital(fromUser.getBank().getTotalCapital() + (long)(Currency.USD.getValue() * amount * ((double)fromUser.getBank().getCommission(amount) / 100)));
                toUser.setBalance(toUser.getBalance() + amount);
            } else {
                if (fromUser.getBalance() < (amount + Currency.EUR.getValue() * amount * ((double)fromUser.getBank().getCommission(amount) / 100))) {
                    System.out.println("Not enough money for this operation");
                    return;
                }
                fromUser.setBalance(fromUser.getBalance() - (amount + Currency.EUR.getValue() * amount * ((double)fromUser.getBank().getCommission(amount) / 100)));
                fromUser.getBank().setTotalCapital(fromUser.getBank().getTotalCapital() + (long)(Currency.EUR.getValue() * amount * ((double)fromUser.getBank().getCommission(amount) / 100)));
                toUser.setBalance(toUser.getBalance() + amount);
            }
        } else {
            if (fromUser.getBalance() < (amount + amount * ((double)fromUser.getBank().getCommission(amount) / 100))) {
                System.out.println("Not enough money for this operation");
                return;
            }
            fromUser.setBalance(fromUser.getBalance() - (amount + amount * ((double)fromUser.getBank().getCommission(amount) / 100)));
            fromUser.getBank().setTotalCapital(fromUser.getBank().getTotalCapital() + (long)(amount * ((double)fromUser.getBank().getCommission(amount) / 100)));
            toUser.setBalance(toUser.getBalance() + amount);
        }
    }

    @Override
    public void paySalary(User user) {
        user.setBalance(user.getBalance() + (user.getBalance() * ((double) user.getBank().getMonthlyRate() / 100)));
        user.setBalance(user.getBalance() + user.getSalary());
    }
}
