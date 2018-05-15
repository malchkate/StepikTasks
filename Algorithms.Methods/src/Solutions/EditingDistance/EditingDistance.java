package Solutions.EditingDistance;

import java.util.Scanner;

/**
 * Created by Katerina on 16.04.2018.
 */
public class EditingDistance {
    static int[][] matrix;

    static int distanceCalculation(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        matrix[0][0] = 0;
        for (int i = 1; i <= n; i++){
            matrix[i][0] = i;
        }
        for (int j = 1; j <= m; j++){
            matrix[0][j] = j;
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                int diff = 0;
                if (str1.charAt(i-1) != str2.charAt(j-1)){
                    diff = 1;
                }
                int temp = Math.min(matrix[i-1][j] + 1, matrix[i][j-1] + 1);
                matrix[i][j] = Math.min(temp, matrix[i-1][j-1] + diff);
            }
        }
        return matrix[n][m];
    }

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        String str1 = scIn.next();
        String str2 = scIn.next();
        matrix = new int[str1.length() + 1][str2.length() + 1];
        System.out.println(distanceCalculation(str1,str2));
    }
}
