// Zachary Gibson
// 60975
// Lab3

import java.util.Scanner;

public class Program3 {

    public static void main(String[] args) {
        System.out.println("Credit Card program by Zachary Gibson");

        Scanner kb = new Scanner(System.in);

        System.out.println("Customer name:");
        String name = kb.nextLine();

        System.out.println("Customer member level:");
        String memberLevel = kb.nextLine().toLowerCase();
        if (memberLevel.equals("despicable") || memberLevel.equals("horrible") || memberLevel.equals("niceguy")) {
        } else {
            System.out.println("Invalid Level. Must be one of Despicable, Horrible, Niceguy.");
            System.exit(0);
        }

        System.out.println("Current balance:");
        double balance = kb.nextDouble();

        boolean late = false;
        System.out.println("Was the payment made late?");
        String lateText = kb.next().toUpperCase();
        if (lateText.equals("YES")) {
            late = true;
        } else if (lateText.equals("NO")) {
            late = false;
        } else {
            System.out.println("Error: Enter yes or no");
            System.exit(0);
        }

        System.out.printf("Bill for %s customer %s%n", memberLevel, name);
        System.out.printf("Card balance: $%.2f%n", balance);

        double lateFee = 0;
        double rate = 0;
        if (memberLevel.equals("despicable")) {
            rate = .8; //0.8% per month
            if (late) {
                rate = rate + 1;
            }
        } else if (memberLevel.equals("horrible")) {
            rate = 2; //2.0% per month
            if (late) {
                lateFee = 10;
                rate = rate + 1.1;
            }
        } else if (memberLevel.equals("niceguy")) {
            rate = 3.1; //3.1% per month
            if (late) {
                lateFee = 20;
                rate = rate + 1.2;
            }
        }

        double minimumPayment = (balance * .04);
        System.out.printf("Minimum payment to principle (4.0%% of principle): $%.2f%n", minimumPayment);

        double interestOnTime = balance * (rate / 100);
        if (late) {
            System.out.printf("Interest for late payment (%.1f%% of principle): $%.2f%n", rate, interestOnTime);
            System.out.printf("Late fee: $%.2f%n", lateFee);
        } else {
            System.out.printf("Interest for on-time payment (%.1f%% of principle): $%.2f%n", rate, interestOnTime);
        }

        double totalPayment = minimumPayment + interestOnTime;
        if (late) {
            totalPayment += lateFee;
        }
        System.out.printf("Minimum total payment (payment, interest, and fees): $%.2f%n", totalPayment);

        double percentToPrinciple = 100 * (minimumPayment / totalPayment);
        double percentToFees = 100 - percentToPrinciple;
        System.out.printf("Payment to principle: %.1f%%%n", percentToPrinciple);
        System.out.printf("Payment to interest and fees: %.1f%%%n", percentToFees);

    }
}
