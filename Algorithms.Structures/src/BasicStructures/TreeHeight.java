package BasicStructures;

import java.util.Scanner;

/**
 * Created by Katerina on 02.05.2018.
 */
public class TreeHeight {
    static int[] tree ;

    public static int countHeight(int index, int height){
        if (tree[index] == -1){
            return height;
        } else {
            return countHeight(tree[index], height + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        tree = new int[n];
        for (int i = 0; i < n; i++){
            tree[i] = scIn.nextInt();
        }
        int height = 0;

        for (int i = 0; i < n; i++){
            height = Math.max(height, countHeight(i, 1));
        }
        System.out.println(height);
    }
}
