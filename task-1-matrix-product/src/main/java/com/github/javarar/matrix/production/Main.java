package com.github.javarar.matrix.production;

public class Main {
    public static void main(String[] args) {
//        var t = System.currentTimeMillis();
//        MatrixProductionParalell.Matrix m1 = new MatrixProductionParalell.Matrix(1000,1000);
//        MatrixProductionParalell.Matrix m2 = new MatrixProductionParalell.Matrix(1000,1000);
//
//        System.out.println("Начало " + t);
//        MatrixProductionParalell.productParalell(m1, m2);
//        System.out.println("конец " + (System.currentTimeMillis() - t));

        var t = System.currentTimeMillis();
        MatrixProduction.Matrix m1 = new MatrixProduction.Matrix(1000,1000);
        MatrixProduction.Matrix m2 = new MatrixProduction.Matrix(1000,1000);

        System.out.println("Начало " + t);
        MatrixProduction.product(m1, m2);
        System.out.println("конец " + (System.currentTimeMillis() - t));
    }
}
