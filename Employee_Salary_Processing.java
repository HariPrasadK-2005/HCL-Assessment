import java.util.Scanner;

public class Employee_Salary_Processing {

    public static abstract class Employee {
        int employeeId;
        String employeeName;

        Employee(int employeeId, String employeeName){
            this.employeeId = employeeId;
            this.employeeName = employeeName;
        }

        public int getEmployeeId(){
            return employeeId;
        }

        public String getEmployeeName(){
            return employeeName;
        }

        abstract double calculateSalary();
    }

    static class FullTimeEmployee extends Employee{
        private double monthlySalary;

        FullTimeEmployee(int employeeId, String employeeName, double monthlySalary){
            super(employeeId, employeeName);
            this.monthlySalary = monthlySalary;
        }

        public double calculateSalary(){
            return monthlySalary;
        }
    }

    static class ContractEmployee extends Employee{
        private int workingDays;
        private double dailyRate;

        ContractEmployee(int employeeId, String employeeName, int workingDays, double dailyRate){
            super(employeeId, employeeName);
            this.workingDays = workingDays;
            this.dailyRate = dailyRate;
        }

        public double calculateSalary(){
            return workingDays*dailyRate;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int employeeType = sc.nextInt();
        int employeeId = sc.nextInt();
        String employeeName = sc.next();

        Employee emp;
        if(employeeType == 1){
            double monthlySalary = sc.nextDouble();
            
            emp = new FullTimeEmployee(employeeId, employeeName, monthlySalary);
        }
        else{
            int workingDays = sc.nextInt();
            double dailyRate = sc.nextDouble();

            emp = new ContractEmployee(employeeId, employeeName, workingDays, dailyRate);
        }

        System.out.println("Employee ID: "+emp.getEmployeeId());
        System.out.println("Employee Name: "+emp.getEmployeeName());
        System.out.printf("Salary: %.2f%n",emp.calculateSalary());
    
        sc.close();
    }
}
