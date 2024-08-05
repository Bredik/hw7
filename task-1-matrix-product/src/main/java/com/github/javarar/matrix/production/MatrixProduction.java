package com.github.javarar.matrix.production;

import java.util.Arrays;

public class MatrixProduction {

    public static String product(Matrix a, Matrix b) {
        var s = Arrays.deepToString(multiply(a.getMatrix(), b.getMatrix()));
        System.out.println("Посчитали");
        return s;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        //a[0].length - кол-во столбцов (длина строки)
        //b.length - кол-во строк  (длина столбца)
        if (a[0].length != b.length) {
            System.err.println("Эти матрицы нельзя перемножить");
            return null;
        }

        final var matrixM = new int[a.length][b[0].length];
        for (var i = 0; i < matrixM.length; i++) {
            for (var j = 0; j < matrixM[0].length; j++) {
                matrixM[i][j] = 0;
                for (var k = 0; k < a[0].length; k++) {
                    matrixM[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return matrixM;
    }

    public static class Matrix {
        private final int[][] matrix;

        public Matrix(int sizeL, int sizeM) {
            this.matrix = new int[sizeL][sizeM];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = (int) (Math.random() * 100 + 1);
                }
            }
        }

        public Matrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int[][] getMatrix() {
            return matrix;
        }

        @Override
        public String toString() {
            return "Matrix{" +
                    "matrix=" + Arrays.deepToString(matrix) +
                    '}';
        }
    }
}
