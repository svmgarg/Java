package temp.geeks.Practice4;

import java.util.Scanner;

public class Practice4 {

    public static void main(String args[]) {

        int n = 3;
        int[][] matrix = new int[n][n];

        matrix[0][0] = 1;        matrix[0][1] = 2;        matrix[0][2] = 3;
        matrix[1][0] = 12;        matrix[1][1] = 13;        matrix[1][2] = 14;
        matrix[2][0] = 11;        matrix[2][1] = 16;        matrix[2][2] = 15;



        for (int i = 0; i < n / 2; i++) {

            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n-1-i][n - 1 - j];
                matrix[n-1-i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;

            }


        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }

    }


}
