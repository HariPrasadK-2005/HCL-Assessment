import java.util.Scanner;

class Employee{
    String employeeName;

    Employee(String employeeName){
        this.employeeName = employeeName;
    }

    double calculateBonus(){
        return 0.0;
    }
    double calculateBonus(double amount){
        return 0.0;
    }
}

class TechnicalEmployee extends Employee{
    double basicSalary;
    int rating;

    TechnicalEmployee(String employeeName, double basicSalary, int rating){
        super(employeeName);
        this.basicSalary = basicSalary;
        this.rating = rating;
    }

    @Override
    double calculateBonus(){
        return basicSalary * rating * 0.02;
    }

    double calculateBonus(double salary, int employeeRating){
        return salary * employeeRating * 0.02;
    }
}

class SalesEmployee extends Employee{
    double salesAmount;

    SalesEmployee(String employeeName, double salesAmount){
        super(employeeName);
        this.salesAmount = salesAmount;
    }

    @Override
    double calculateBonus(){
        return salesAmount * 0.03;
    }

    @Override 
    double calculateBonus(double amount){
        return amount * 0.03;
    }
}
public class Employee_Performance_Bonus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int employeeType = sc.nextInt();

        Employee employee;

        double bonus;
        double totalEarnings;

        if(employeeType == 1){
            String employeeName = sc.next();
            double basicSalary = sc.nextDouble();
            int rating = sc.nextInt();

            employee = new TechnicalEmployee(employeeName, basicSalary, rating);
            bonus = employee.calculateBonus();
            totalEarnings = basicSalary + bonus;
        } 
        else{
            String employeeName = sc.next();
            double salesAmount = sc.nextDouble();

            employee = new SalesEmployee(employeeName, salesAmount);
            bonus = employee.calculateBonus();
            totalEarnings = salesAmount + bonus;
        }

        System.out.println("Employee Name: "+ employee.employeeName);
        System.out.printf("Bonus: %.2f%n", bonus);
        System.out.printf("Total Earnings: %.2f%n", totalEarnings);

        sc.close();
    }
}
