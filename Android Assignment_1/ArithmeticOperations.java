import java.util.Scanner;

class Operations {
        /* *
        *To Display Numbers From 1 to 100
        */
        private void displayNumber(){
            // number variable is used to iterate and print the result 
            int number;
            System.out.println("Number from 1 to 100");
            for(number=1;number<=100;number++)
                 System.out.print(+number +"\t");
        }
        /**
        *To Display Number which Are Divisible by 3 and 7
        */
        private void numberDivisibleBy(){
             // number variable is used to iterate and print the result 
            int number;
            System.out.println("\nNumber which are divisible by 3 and 7  from 1 to 100 are:");
            for(number=1;number<100;number++){
                    if(number % 3==0 && number % 7==0){
                        System.out.print("\nNumber is:\t" +number);   
                    }
            }
        }
        /**
        *To Calculate Factorial of the Number
        */
         private int calculateFactorial(int number ){
                // int factorial_result use to store the factroial result and no used to iterate the loop and factorial caculations 
              int factorial_result=1;
              int no;
              for(no=number;no>0;no--){
                 factorial_result=factorial_result*no;
              }
              return(factorial_result);
         }
        /*
         *To find Number is Prime Number
         */
         private boolean isPrime(int number){
            int check_prime=0;
            int no;
                check_prime=number/2;      
                if(number==0||number==1){  
                    return false;      
                 }
                 else{  
                    for(no=2;no<=check_prime; no++){      
                            if(number%no==0)    
                                 return false;      
                    }
                }      
            return true;
         }
         /**
         *To find number is Palindrome
         */
          private void isPalindrome(int number ){
            int temp=0; 
            int reminder=0;
            int sum=0;
                temp=number;
                while(number>0)
                {
                    reminder=number%10;
                    sum=(sum*10)+reminder;
                    number=number/10;
                }
                if(sum==temp)
                System.out.println("\nThe number is Palindrome");
                else
                System.out.println("\nThe number is not Palindrome");

          }

          /**
          *To find fibonaccii Series
          */
             private int fibonacciiSeries(int number){
             int fibonaccii_result=0;
             int number1=0;
             int number2=1;                 
             int no;
                for(no=0;no<=number;no++){
                        fibonaccii_result =number1+number2;
                        number1=number2;
                        number2=fibonaccii_result;
                }
                return(fibonaccii_result);
          }
        
}
/**
 *       Main Functions 
 */

public class ArithmeticOperations{
    
     public static void main(String args[]){ 

        int choice;
        int number; 
        int factorial_result;
        int fibonaccii_result;
        char answer;
        Scanner input=new Scanner(System.in);
        Operations operations=new Operations();
             do{
                    System.out.println("\n1=>>To Display Numbers From 1 to 100\n2=>>Numbers which Are Divisible by 3 and 7"); 
                    System.out.println("3=>>To Calculate Factorial of the Number\n4=>>To find Number is Prime Number");
                    System.out.println("5=>>To find number is Palindrome\n6==>To find fibonaccii Series");
                    System.out.println("7=>> Exit ");
                    System.out.println("********ENTER YOUR OPTIONS WHERE********");
                    choice=input.nextInt();
            
                     switch(choice){
                        case 1:
                                 operations.displayNumber();
                         break;
                        case 2:
                                 operations.numberDivisibleBy();
                         break;
                         case 3:
                                 System.out.println("Enter the number to calcuate Factorial :");
                                 number=input.nextInt();
                                 factorial_result= operations.calculateFactorial(number);
                                 System.out.println("Factorial of " +number + " is :" +factorial_result);
                         break;
                         case 4:
                                 System.out.println("Enter the Number of choice  :");
                                 number=input.nextInt();
                                 if(operations.isPrime(number))
                                         System.out.println(""+number+"-->is a prime number");
                                 else
                                         System.out.println(""+number+"-->Not a primer number");
                        break;
                        case 5:
                                 System.out.println("Enter the Number of choice  :");
                                 number=input.nextInt();
                                 operations.isPalindrome(number);
                        break;
                        case 6:
                                System.out.println("Enter the range of Fiabonaccii series  :");
                                number=input.nextInt();
                                fibonaccii_result=operations.fibonacciiSeries(number);
                                System.out.println("Result of Fibonacci Series is :" +fibonaccii_result);
                         break;
                        case 7:
                                System.out.println("Thank You :)\n Exiting...");
                                System.exit(1); 
                        break;
                        default:
                                System.out.println("\n***********************PLEASE ENTER VAILD CHOICE***************************\n");
                         break;
            }
            System.out.println("\n**************Do YOU WANT TO COUNTINUE (Y/N)*******************");
            answer=input.next().charAt(0);
        }while(answer=='Y'||answer=='y');
     }
    
}
