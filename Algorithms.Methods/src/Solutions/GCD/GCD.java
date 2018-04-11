package Solutions.GCD;

import java.util.Scanner;
/**
 * Created by Katerina on 09.04.2018.
 */
public class GCD {

    public static int NOD(int a, int b){
        if (b == 0){
            return a;
        }else {
            return NOD(b, a % b);
        }
    }
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int a = scIn.nextInt();
        int b = scIn.nextInt();
        int res = 0;
        if (a >=  b){
            res = NOD(a,b);
        }else {
            res = NOD(b,a);
        }
        System.out.print(res);
    }
}

