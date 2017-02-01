package Module22;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("balance = ");
        double balance = scanner.nextDouble();
        System.out.print("withdrawal = ");
        double withdrawal = scanner.nextDouble();
        scanner.close();
        withdrawal(balance, withdrawal);
    }

    private static void withdrawal(double balance, double withdrawal){
        double result = balance - (withdrawal + (withdrawal * 0.05));
        if (result < 0.0) {
            System.out.println("NO");
        } else {
            System.out.println("OK "+ (withdrawal * 0.05) +" "+result);
        }
    }
}
