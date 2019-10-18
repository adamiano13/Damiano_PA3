import java.util.Scanner;
class SavingsAccount {
    public static double annualInterestRate =0.0; //initialize interest rate to 0
    private double savingsBalance; //creates balances
    public SavingsAccount(double money){
        this.savingsBalance = money;//use this as a pointer
    }
    public void calculateMonthlyInterest(){
        double earnedInterest;
        earnedInterest =(this.savingsBalance*annualInterestRate)/12;
        this.savingsBalance+= earnedInterest;
    }
    public static void modifyInterestRate(double modRate){
        annualInterestRate = modRate;
    }
    public void showBalance(){
        System.out.printf("%.1f",this.savingsBalance);//prints to screen
    }
}//end class savings account

public class Application {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please enter initial balance of saver1");
        double amount1 = scnr.nextLong();
        System.out.println("Please enter initial balance of saver2");
        double amount2 = scnr.nextLong();
        System.out.println("Please enter the interest rate in decimal form");
        double percent = scnr.nextFloat();

        SavingsAccount saver1 = new SavingsAccount(amount1);//sets balance
        SavingsAccount saver2 = new SavingsAccount(amount2);//sets balance
        SavingsAccount.modifyInterestRate(percent);//sets rate use decimal of percent


        System.out.println("Below is the new balance for ");
        System.out.println("Month\tSaver1\tSaver2");

        for (int i = 0; i < 12; i++) {// run 12 times fir 12 months
            saver1.calculateMonthlyInterest();
            System.out.print(i+1+"\t\t");
            saver1.showBalance();
            System.out.print("\t");
            saver2.calculateMonthlyInterest();
            saver2.showBalance();
            System.out.println();
        }


    }











}
