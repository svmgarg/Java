package algo.eggDroppingProblem;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        int N = 100;
        int X = 3;

        // To debug: System.err.println("Debug messages...");
        int[][] mat = new int[X + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            mat[1][i] = i;
            mat[0][i] = 0;
        }

        for (int i = 0; i <= X; i++) {
            mat[i][1] = 1;
            mat[i][0] = 0;
        }

        int temp =0;
        for (int i = 2; i <= X; i++) {
            for (int j = 2; j <= N; j++) {
                mat[i][j]= Integer.MAX_VALUE;
                for(int k=1;k<=j;k++){
                    temp = 1+ Math.max(mat[i-1][k-1], mat[i][j-k]);
                    if (temp < mat[i][j]){
                        mat[i][j] =  temp;
                    }
                }

            }
        }


        System.out.println(mat[3][100]);
    }
}