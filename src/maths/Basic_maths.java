package src.maths;



public class Basic_maths {

    //Function to count the digits
    static int digitCount(int n) {
        int counter = 0;
        while (n > 0){
            n = n/10;
            counter++;
        }
        return counter;
    }

    //Reverse of a given number
    static int reverseDigit(int n) {
        int temp = 0;
        int reversedNumber = 0;
        while(n > 0){
            temp = n%10;
            reversedNumber = reversedNumber * 10 + temp;
            n /= 10;
        }
        return reversedNumber;
    }

    //Pallindrome Number
    static boolean checkPalindrome(int n){
        return n == reverseDigit(n);
    }

    //armstrong number check
    static boolean checkArmstrong(int n){
        int lastDigit;
        int sum = 0;
        int originalNumber = n;
        while(n > 0){
            lastDigit = n%10;
            sum += Math.pow(lastDigit, 3);
            n /= 10;
        }
        return sum == originalNumber;
    }



    //print all divisors
    static void printAllDivisors(int n){
        //run the loop till Sqrt of n
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n%i == 0) {
                //Print if i divides n
                System.out.println(i);
                if ((n/i) != i){
                    //check if other number is not equal to i, if not print it.
                    System.out.println(n/i);
                }
            }
        }
    }

    static boolean checkPrime(int n) {
        int counter = 0;
        for (int i = 1; i*i <= n; i++) {
            if (n%i == 0){
                counter++;
                if (n/i != i){
                    counter++;
                }
            }
        }
        return counter == 2;
    }



    public static void main(String[] args) {
//        System.out.println(digitCount(12345));
//        System.out.println(reverseDigit(12345));
//        System.out.println(checkPalindrome(12321));
//        System.out.println(checkArmstrong(153));
//        printAllDivisors(36);
//        System.out.println(checkPrime(4));

    }


}
