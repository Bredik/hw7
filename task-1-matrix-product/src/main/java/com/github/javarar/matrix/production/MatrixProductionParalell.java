package com.github.javarar.matrix.production;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class MatrixProductionParalell {

    public static String productParalell(Matrix a, Matrix b) {
        var s = Arrays.deepToString(multiply(a.getMatrix(), b.getMatrix()));
        System.out.println("Посчитали");
        return s;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            System.err.println("Эти матрицы нельзя перемножить");
            return null;
        }

        final var rezult = new int[a.length][b[0].length];

        for (var i = 0; i < rezult.length; i++) {
            for (var j = 0; j < rezult[0].length; j++) {
                int finalI = i;
                int finalJ = j;
                CompletableFuture.runAsync(() -> {
                    rezult[finalI][finalJ] = 0;
                    var tmp = getTmpMatrix(b, finalJ);
                    for (var k = 0; k < a[0].length; k++) {
                        rezult[finalI][finalJ] += a[finalI][k] * tmp[k];
                    }
                });

            }
        }
        return rezult;
    }

    static int[] getTmpMatrix(int[][] b, int j) {
        int[] tmp = new int[b.length];
        for (var i = 0; i < tmp.length; i++) {
            tmp[i] = b[i][j];
        }
        return tmp;
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
