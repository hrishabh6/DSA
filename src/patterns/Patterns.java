package src.patterns;

public class Patterns {
    static void pattern1(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j+1 + " ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i+1 + " ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for (int i = n-1; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print( "* ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2*i+1; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
        System.out.println();
        }
    }
    static void pattern7(int n){
        for (int i = n; i > 0; i--) {
            // Print leading spaces
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            // Move to the next line
            System.out.println();
        }
    }

    static void pattern8(int n) {
        pattern6(n);
        pattern7(n);
    }

    static void pattern9(int n) {
        for (int i = 0; i < 2*n; i++) {
            int stars = i;
            if (i > n) stars = 2*n-i;
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern10(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i%2 == j%2){
                    System.out.print(1);
                } else{
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//            pattern1(4);
//        System.out.println();
//        System.out.println();
//            pattern2(4);
//        System.out.println();
//        System.out.println();
//            pattern3(4);
//        System.out.println();
//        System.out.println();
//            pattern4(4);
//        System.out.println();
//        System.out.println();
//            pattern5(4);
//        System.out.println();
//        System.out.println();
//            pattern6(4);
//        System.out.println();
//        System.out.println();
//            pattern7(4);
//        System.out.println();
//        System.out.println();
//            pattern8(4);
//        System.out.println();
//        System.out.println();
//            pattern9(4);
//        System.out.println();
//        System.out.println();
//            pattern10(5);
//        System.out.println();
//        System.out.println();



    }


}
