package Solutions.DynamicBackpack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Katerina on 17.04.2018.
 */
public class BackpackWithoutRepsBU {

    public static int optimalBackpack(int W, List<Integer> listW){
        int n = listW.size();
        int[][] D = new int[W+1][n+1];
        for (int w = 0; w <= W; w++){
            D[w][0] = 0;
        }
        for (int i = 0; i <= n; i++){
            D[0][i] = 0;
        }
        for (int i = 1; i <= n; i++){
            for (int w = 1; w <= W; w++){
                D[w][i] = D[w][i-1];
                if (listW.get(i-1) <= w){
                    D[w][i] = Math.max(D[w][i],D[w - listW.get(i-1)][i-1] + listW.get(i-1));
                }
            }
        }
        return D[W][n];
    }

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int W = scIn.nextInt();
        int n = scIn.nextInt();
        List<Integer> listW = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            listW.add(scIn.nextInt());
        }
        System.out.println(optimalBackpack(W, listW));
    }
}
