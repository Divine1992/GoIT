package Module24;

import java.util.Arrays;
import java.util.Scanner;

public class Fund {

    private static int[] balances;
    private static String[] owners;

    public static void main(String[] args) {
        balances = new int[5];
        for (int i = 0; i < balances.length; i++) {
            balances[i] = (int) (Math.random() * 1000);
        }
        System.out.println(Arrays.toString(balances));
        owners = new String[]{"Jane", "Ann", "Jack", "Oww", "Lane"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Owner name = ");
        String owner = scanner.next();
        System.out.print("withdrawal = ");
        double withdrawal = scanner.nextDouble();
        scanner.close();
        fund(owner, withdrawal);

    }

    private static void fund(String owner, double withdrawal) {
        Integer idOwner = null;
        for (int i = 0; i < owners.length; i++) {
            if (owner.equals(owners[i])) {
                idOwner = i;
                break;
            }
        }
        if (idOwner == null) throw new IllegalArgumentException();
        double fund = balances[idOwner] + withdrawal;
        System.out.println(owners[idOwner]+" "+(int)fund);
    }
}
