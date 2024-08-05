package com.github.javarar.matrix.production;

import com.github.javarar.matrix.production.MatrixProduction.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.github.javarar.matrix.production.MatrixProductionParalell.productParalell;

public class MatrixProductionTest {

    @Test
    public void check() {
        int[][] a1 = {{5, 8, 6}, {7, 8, 5}, {4, 5, 6}};
        MatrixProduction.Matrix a = new MatrixProduction.Matrix(a1);

        int[][] b1 = {{7, 0, 8}, {6, 2, 2}, {7, 3, 5}};
        MatrixProduction.Matrix b = new MatrixProduction.Matrix(b1);

        int[][] expected = {{125, 34, 86}, {132, 31, 97}, {100, 28, 72}};
        Assertions.assertEquals(Arrays.deepToString(expected), MatrixProduction.product(a, b));
    }

    @Test
    public void checkParalell() {
        int[][] a1 = {{5, 8, 6}, {7, 8, 5}, {4, 5, 6}};
        MatrixProductionParalell.Matrix a = new MatrixProductionParalell.Matrix(a1);
        int[][] b1 = {{7, 0, 8}, {6, 2, 2}, {7, 3, 5}};
        MatrixProductionParalell.Matrix b = new MatrixProductionParalell.Matrix(b1);

        productParalell(a, b);
    }

    @Test
    public void checkTime() {
        //В один поток считаем матрицу 3на3 - 5ms, 100на100 - 10ms, 1000на1000 - 950ms
        //С пулом 3на3 - 10ms, 100на100 - 18ms, 1000на1000 - 220ms
        //То есть ускорене проиходит только на большом объеме
        var t = System.currentTimeMillis();
        MatrixProductionParalell.Matrix m1 = new MatrixProductionParalell.Matrix(1000,1000);
        MatrixProductionParalell.Matrix m2 = new MatrixProductionParalell.Matrix(1000,1000);

        System.out.println("Начало " + t);
        MatrixProductionParalell.productParalell(m1, m2);
        System.out.println("конец " + (System.currentTimeMillis() - t));
    }
}
