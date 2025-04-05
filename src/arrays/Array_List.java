package src.arrays;
import java.util.*;

public class Array_List {
    public static void main(String[] args) {
        ArrayList<Integer> L1 = new ArrayList<>();
        ArrayList<Integer> L2 = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            L1.add(i);
        }
        for(int i = 0; i < 10; i++) {
            System.out.print(L1.get(i) + " ");
        }
        //clear the whole array
        L1.clear();
        //this code will throw exception
        try {
            for(int i = 0; i < 10; i++) {
                System.out.print(L1.get(i) + " ");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Something went wrong " + e);
        }

        for(int i = 0; i < 10; i++) {
            L1.add(i);
        }
        for(int i = 11; i < 20; i++) {
            L2.add(i);
        }

        //Some more methods
        L1.addAll(L2);

        System.out.println("Program has ended");

    }

}
