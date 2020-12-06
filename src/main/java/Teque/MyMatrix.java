package Teque;

import java.util.Arrays;

public class MyMatrix {
    public static void main(String[] args) {
        Integer[][] myMatrix = {
                {1, null, null, null},
                {0, 1, null, null},
                {0, 1, 1, null},
                {1, 0, 1, 1}
        };
        Integer[][] sol = matrixToThePower(myMatrix, 2);
        toOnes(sol);

        printMatrix(sol);
    }

    public static Integer[][] matrixToThePower(Integer[][] matrix, int n) {
        Integer[][] sol = copyMatrix(matrix);
        for (int power = 0; power < n - 1; power++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j <= i; j++) {
                    sol[i][j] = maxtrixMultiplicityEntry(matrix, sol, i, j);
                }
            }
        }
        return sol;
    }

    public static int maxtrixMultiplicityEntry(Integer[][] matrix, Integer[][] matrix2, int row, int col) {
        int sol = 0;
        for (int i = 0; i < matrix.length; i++) {
                int[] firstEntry = simpleSort(row, i);
                int[] secondEntry = simpleSort(col, i);
                sol += matrix[firstEntry[1]][firstEntry[0]] * matrix2[secondEntry[1]][secondEntry[0]];
        }
        return sol;
    }

    public static void toOnes(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j <= i; j++) {
                if (matrix[i][j] > 0) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    public static void printMatrix(Integer[][] matrix) {
        for (int i = 0; i<  matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    public static Integer[][] copyMatrix(Integer[][] matrix) {
        Integer[][] sol = new Integer[matrix.length][matrix.length];
        for(int i = 0;i < matrix.length; i++) {
            for(int j = 0; j< matrix[0].length; j++) {
                sol[i][j] = matrix[i][j];
            }
        }
        return sol;
    }

    public static int[] simpleSort(int i, int j) {
        if (i > j) {
            return new int[]{j ,i};
        } else {
            return new int[]{i ,j};
        }
    }

}
