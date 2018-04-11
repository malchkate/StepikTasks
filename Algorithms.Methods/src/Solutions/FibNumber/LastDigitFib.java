package Solutions.FibNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by Katerina on 09.04.2018.
 */
public class LastDigitFib {

    public static int lastDigitFib_D(int N_stop){
        int a = 1;
        int b = 1;
        for (int i = 1; i < N_stop; i++){
            int temp = a + b;
            a = b;
            b = temp % 10;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        int lastDig = lastDigitFib_D(n-1);
        System.out.println(lastDig);
    }
}


