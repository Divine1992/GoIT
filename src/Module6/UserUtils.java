package Module6;

public final class UserUtils {

    private UserUtils() {
    }

    public static User[] uniqueUsers(User[] users) {
        User[] resultUsers = new User[0];
        boolean isUserPresent = false;
        for (int i = 0; i < users.length; i++) {
            if(users[i] != null) {
                if (resultUsers.length == 0) {
                    resultUsers = increaseLenght(resultUsers);
                    resultUsers[resultUsers.length - 1] = users[i];
            } else {
                    for (User resultUser : resultUsers) {
                        if (resultUser.equals(users[i])) isUserPresent = true;
                    }
                    if (!isUserPresent){
                        resultUsers = increaseLenght(resultUsers);
                        resultUsers[resultUsers.length - 1] = users[i];
                    } else isUserPresent = false;
                }
            }
        }
        return resultUsers;
    }

    public static User[] usersWithContitionalBalance(User[] users, int balance){
        User [] resultArray = new User[0];
        for (User user : users) {
            if(user != null) {
                if (user.getBalance() == balance) {
                    resultArray = increaseLenght(resultArray);
                    resultArray[resultArray.length - 1] = user;
                }
            }
        }
        return resultArray;
    }

    public static User[] paySalaryToUsers(User[] users){
        for (User user : users) {
            if(user != null) {
                user.setBalance(user.getBalance() + user.getSalary());
            }
        }
        return users;
    }

    public static long[] getUsersId(User[] users){
        long[] resultArray = new long[users.length];
        for (int i = 0; i < users.length; i++) {
            if(users[i] != null) {
                resultArray[i] = users[i].getId();
            }
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
        User[] resultArray = new User[users.length + 1];
        if(users != null) {
            System.arraycopy(users, 0, resultArray, 0, users.length);
        }
        return resultArray;
    }
}
