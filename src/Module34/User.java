package Module34;

public class User {
    private String name;
    private int balance;
    private int monthsOfEmployment;
    private String companyName;
    private int salary;
    private String currency;

    public User(String name, int balance, int monthsOfEmployment, String companyName, int salary, String currency) {
        this.name = name;
        this.balance = balance;
        this.monthsOfEmployment = monthsOfEmployment;
        this.companyName = companyName;
        this.salary = salary;
        this.currency = currency;
    }

    public void paySalary(){
        balance += salary;
        System.out.println("New balance after salary: "+balance);
    }

    public void withdraw(int money){
        if (money < 1000){
            money += money * 0.05;
        } else {
            money += money * 0.1;
        }
        if (balance >= money) {
            balance -= money;
            System.out.println("Withdrawal: "+money+" Balance: "+balance);
        } else System.out.println("You haven't enough money");
    }

    public void companyLenghtName(){
        if (companyName != null) {
            System.out.println("Length name of your company is "+companyName.length());
        } else System.out.println("You haven't company");
    }

    public void monthIncreaser(int addMonth){
        monthsOfEmployment += addMonth;
        System.out.println("Employment months: "+monthsOfEmployment);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMonthsOfEmployment() {
        return monthsOfEmployment;
    }

    public void setMonthsOfEmployment(int monthsOfEmployment) {
        this.monthsOfEmployment = monthsOfEmployment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
