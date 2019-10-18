import java.security.SecureRandom;
import java.util.Scanner;

public class damiano_p1 {
    public static int CAI(int num1, int num2,int arithmetic1){
        Scanner scnr = new Scanner(System.in);
        SecureRandom randNum = new SecureRandom();
        double ans=0;
        int type = arithmetic1-1;
        if (arithmetic1==5){
            type = randNum.nextInt(4);
        }
        switch(type+1){
        case 1 :
            System.out.println("How much is "+num1+" plus "+num2);
            ans = num1+num2;
        break;
        case 2 :
            System.out.println("How much is "+num1+" times "+num2);
            ans = num1*num2;
        break;
        case 3 :
            System.out.println("How much is "+num1+" minus "+num2);
            ans = num1-num2;
        break;
        case 4 :
            System.out.println("How much is "+num1+" divided by "+num2);
            ans = num1/num2;
        break;
        }
        String phrase = "";
        double studentAns = scnr.nextDouble();
        int response = randNum.nextInt(4);
        if (Double.compare(studentAns,ans)==0){
            switch (response){
                case 0 :
                    phrase = "Very Good!";
                break;
                case 1 :
                    phrase =  "Perfect";
                break;
                case 2 :
                    phrase = "Way To Go!";
                break;
                case 3 :
                    phrase = "Nice Job!";
                break;
            }//end switch
            System.out.println(phrase);
            return 0;//true
        } //end if
        else {
            switch (response){
                case 1 :
                    phrase = "No. Please try again.";
                    break;
                case 2 :
                    phrase = "Don't give up!";
                break;
                case 3 :
                    phrase = "Try another one.";
                break;
                case 0 :
                    phrase = "Wrong. Try again";
                break;
            }//end switch
            System.out.println(phrase);
            return 1;//false
        }//end else
    }//end CAI
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        SecureRandom randNum = new SecureRandom();
        int num1 ;
        int num2 ;
        int val ; //returned value
        int count =0; //count right answeres
        int difficulty, digits =1,arithmetic;
        System.out.println("Please enter the arithmetic  type.");
        System.out.println("1.\tAddition\n2.\tMultiplication\n3.\tSubtraction\n4.\tDivision\n5.\tRandom");
        arithmetic = scnr.nextInt();
        System.out.println("Please enter a difficulty level, 1-4.");
        difficulty = scnr.nextInt();
        while(difficulty!=0){   //determines amount of digits based off of difficulty
            digits = digits*10;
            difficulty = difficulty-1;
        }//end while
        for (int i=0;i<10;i++) {
            num1 =randNum.nextInt(digits);
            num2 =randNum.nextInt(digits);
            val = CAI(num1, num2,arithmetic);
                if (val == 0){
                    count++;
                }//end if
        }//end for
        if( (double)count/10.0 < .75){
            System.out.println("Please ask your teacher for extra help.");
        }//end if
        else if((double)count/10.0 >= .75){
            System.out.println("Congratulations, you are ready to go to the next level!");
        }//end else if
    }//end main
}//end class
