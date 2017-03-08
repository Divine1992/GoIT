package Module6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        reverseAndEvenElements();
        User[] users = createUsers();
        userActivity(users, 3000);
    }

    private static void userActivity(User[] users, int balance) {
        System.out.println("Not exist null users "+Arrays.toString(users = UserUtils.deleteEmptyUsers(users)));
        System.out.println("User's id "+Arrays.toString(UserUtils.getUsersId(users)));
        System.out.println("Pay salary "+Arrays.toString(UserUtils.paySalaryToUsers(users)));
        System.out.println("unique Users are: "+Arrays.toString(UserUtils.uniqueUsers(users)));
        System.out.println("Users that balance is are: "+balance+" "+Arrays.toString(UserUtils.usersWithContitionalBalance(users, balance)));
    }

    static User[] createUsers(){
        User userAndy = new User(1, "Andy", "Sparrow", 1000, 3000);
        User userAndyTwin = new User(1, "Andy", "Sparrow", 1000, 3000);
        User userBradley = new User(2, "Bradley", "Cooper", 1000, 2000);
        User userDonald = new User(3, "Donald", "Trump", 1000, 2000);
        User userAndyAnotherTwin = new User(1, "Andy", "Sparrow", 1000, 3000);
        User nullMan = null;
        return new User[]{nullMan, userAndy, userAndyTwin, userBradley, userDonald, userAndyAnotherTwin};
    }

    static void reverseAndEvenElements(){
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Sample array "+Arrays.toString(array));
        System.out.println("Reverse "+Arrays.toString(ArraysUtils.reverse(array)));
        System.out.println("Even elements "+Arrays.toString(ArraysUtils.findEvenElements(array)));

        System.out.println("---------------------------------------------------------------------");
    }
}
