import java.util.Scanner;

class Delivery{
    double orderAmount;

    Delivery(double orderAmount){
        this.orderAmount = orderAmount;
    }

    double calculateDeliveryCharge(){
        return orderAmount;
    }
}

class RegularDelivery extends Delivery{
    RegularDelivery(double orderAmount){
        super(orderAmount);
    }

    @Override
    double calculateDeliveryCharge(){
        return orderAmount+ 40.0;
    }
}

class ExpressDelivery extends Delivery{
    ExpressDelivery(double orderAmount){
        super(orderAmount);
    }

    @Override
    double calculateDeliveryCharge(){
        return orderAmount + 80.0 + (orderAmount * 0.05);
    }
}

public class Food_Delivery_Order {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int deliveryType = sc.nextInt();
        double orderAmount = sc.nextDouble();

        Delivery delivery;

        if(deliveryType == 1){
            delivery = new RegularDelivery(orderAmount);
        } else {
            delivery = new ExpressDelivery(orderAmount);
        }

        double finalCharge = delivery.calculateDeliveryCharge();

        System.out.printf("%.2f%n", finalCharge);

        sc.close();
    }
}
