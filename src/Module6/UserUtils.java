package Module6;

public final class UserUtils {

    private UserUtils() {
    }

    public static User[] uniqueUsers(User[] users) {
        User[] resultUsers = new User[0];
        for (int i = 0; i < users.length; i++) {
            if(users[i] == null){
                return null;
            }
            int uniqueCount = 0;
            for (int j = 0; j < users.length; j++) {
                if (users[i].equals(users[j])) {
                    uniqueCount++;
                }
            }
            if (uniqueCount == 1) {
                resultUsers = increaseLenght(resultUsers);
                resultUsers[resultUsers.length - 1] = users[i];
            }
        }
        return resultUsers;
    }

    public static User[] usersWithContitionalBalance(User[] users, int balance){
        User [] resultArray = new User[0];
        for (User user : users) {
            if(user == null){
                return null;
            }
            if (user.getBalance() == balance){
                resultArray = increaseLenght(resultArray);
                resultArray[resultArray.length-1] = user;
            }
        }
        return resultArray;
    }

    public static User[] paySalaryToUsers(User[] users){
        for (User user : users) {
            if(user == null){
                return null;
            }
            user.setBalance(user.getBalance()+user.getSalary());
        }
        return users;
    }

    public static long[] getUsersId(User[] users){
        long[] resultArray = new long[users.length];
        for (int i = 0; i < users.length; i++) {
            if(users[i] == null){
                return null;
            }
            resultArray[i] = users[i].getId();
        }
        return resultArray;
    }

    public static User[] deleteEmptyUsers(User[] users){
        User [] resultArray = new User[0];
        for (User user : users) {
            if (user != null){
                resultArray = increaseLenght(resultArray);
                resultArray[resultArray.length-1] = user;
            }
        }
        return resultArray;
    }

    private static User[] increaseLenght(User[] users) {
        if(users == null){
            return null;
        }
        User[] resultArray = new User[users.length+1];
        System.arraycopy(users, 0, resultArray, 0, users.length);
        return resultArray;
    }
}
