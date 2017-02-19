package Module4;

public class Main {
    private static BankSystem visa;

    public static void main(String[] args) {
        Bank bankOfAmerica = new USBank(1, "USA", Currency.USD, 3000, 1400, 25, 3_000_000);
        Bank bankFrankfurtAliaz = new EUBank(2, "Germany", Currency.EUR, 2000, 1200, 27, 5_000_000);
        Bank bankOfChina = new ChinaBank(3, "China", Currency.USD, 20000, 500, 56, 15_000_000);
        User johnUser = new User(1, "John", 1000, 4, "New Post", 1500, bankOfAmerica);
        User patrickUser = new User(2, "Patrick", 2000, 11, "McDonald's", 1200, bankOfAmerica);
        User mikeUser = new User(3, "Mike", 1000, 1, "Hospital by St. George", 1000, bankFrankfurtAliaz);
        User paulUser = new User(4, "Paul", 5000, 9, "Police of Berlin", 1500, bankFrankfurtAliaz);
        User songUser = new User(5, "Song", 1200, 5, "Sailor Corp.", 100, bankOfChina);
        User tachikaraUser = new User(6, "Tachikara", 2000, 12, "Dev. System", 200, bankOfChina);
        visa = new BankSystemImpl();
        Activity(johnUser, patrickUser, 1000);
        Activity(patrickUser, mikeUser, 500);
        Activity(mikeUser, johnUser, 700);
        Activity(paulUser, songUser, 1200);
        Activity(songUser, patrickUser, 150);
        Activity(tachikaraUser, johnUser, 150);
    }

    private static void Activity(User userName, User userFriend, int amount) {
        visa.fundUser(userName, amount);
        visa.paySalary(userName);
        visa.withdrawOfUser(userName, amount - 100);
        visa.transferMoney(userName, userFriend, amount + 150);
        System.out.println(userName);
    }


}
