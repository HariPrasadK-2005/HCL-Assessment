import java.util.Scanner;

interface Payment {
    double calculateFee(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public double calculateFee(double amount) {
        return amount * 0.02;
    }
}

class UpiPayment implements Payment {
    @Override
    public double calculateFee(double amount) {
        return amount * 0.005;
    }
}

class WalletPayment implements Payment {
    @Override
    public double calculateFee(double amount) {
        return amount * 0.01;
    }
}

public class Online_Payment_Processing {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int paymentType = sc.nextInt();
        double amount = sc.nextDouble();

        Payment payment;

        if (paymentType == 1) {
            payment = new CreditCardPayment();
        } else if (paymentType == 2) {
            payment = new UpiPayment();
        } else{
            payment = new WalletPayment();
        }

        double fee = payment.calculateFee(amount);

        System.out.printf("Payment Amount: %.2f\n", amount);
        System.out.printf("Transaction Fee: %.2f\n", fee);
        System.out.printf("Final Amount: %.2f\n", amount + fee);

        sc.close();
    }
}
