package com.jawidm;

public class DEFATest {
    private final int[] array;
    private final int length;
    private final int [][] twoDimensionalArray;

    public DEFATest(int[] array, int length, int[][] twoDimensionalArray) {
        this.array = array;
        this.length = length;
        this.twoDimensionalArray = twoDimensionalArray;
    }

    public int findMaxProductInRow() {
        //checks the size of array, must be more minimum four
        if (length < 4) {
            return -1;
        }
        //finds max product in row
        int product;
        int maxProduct = 0;
        for (int i = 0; i < array.length - 3; i++) {
            product = array[i] * array[i + 1] * array[i + 2] * array[i + 3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }

    public int findMaxProductInColumns() {
        //checks the size of array, must be more minimum four
        if (length < 4) {
            return -1;
        }
        //finds max product in columns
        int product;
        int maxProduct = 0;
        for (int r = 0; r < length - 3; r++) {
            for (int c = 0; c < length; c++) {
                product = twoDimensionalArray[r][c] * twoDimensionalArray[r + 1][c] *
                        twoDimensionalArray[r + 2][c] * twoDimensionalArray[r + 3][c];
                if (maxProduct < product) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    public int findMaxProductInAllPrincipalDiagonals() {
        if (length < 4) {
            return -1;
        }
        //find max product in diagonals med en for loop
        int product;
        int maxProduct = 0;
        int totalLengthFirstHalf = length - 3;
        int colLengthTotal = 0;
        int colLengthForLoop = colLengthTotal;
        //finds maximum product of all first half principal diagonals
        while (totalLengthFirstHalf > 0) {
            for (int r = 0; r < totalLengthFirstHalf; r++) {
                product = twoDimensionalArray[r][colLengthForLoop] * twoDimensionalArray[r + 1][colLengthForLoop + 1] *
                        twoDimensionalArray[r + 2][colLengthForLoop + 2] * twoDimensionalArray[r + 3][colLengthForLoop + 3];
                colLengthForLoop++;
                if (maxProduct < product) {
                    maxProduct = product;
                }
            }
            totalLengthFirstHalf--;
            colLengthTotal++;
            colLengthForLoop = colLengthTotal;
        }
        int totalLengthSecondHalf = length - 3;
        int rowLengthTotal = 0;
        int rowLengthForLoop = rowLengthTotal;
        //finds maximum product of all second half principal diagonals
        while (totalLengthSecondHalf > 0) {
            for (int c = 0; c < totalLengthSecondHalf; c++) {
                product = twoDimensionalArray[rowLengthForLoop][c] * twoDimensionalArray[rowLengthForLoop + 1][c + 1] *
                        twoDimensionalArray[rowLengthForLoop + 2][c + 2] * twoDimensionalArray[rowLengthForLoop + 3][c + 3];
                rowLengthForLoop++;
                if (maxProduct < product) {
                    maxProduct = product;
                }
            }
            totalLengthSecondHalf--;
            rowLengthTotal++;
            rowLengthForLoop = rowLengthTotal;
        }
        return maxProduct;
    }

    public int findMaxProductInAllSecondaryDiagonals() {
        if (length < 4) {
            return -1;
        }
        //find max product in diagonals med en for loop
        int product;
        int maxProduct = 0;
        int totalLengthFirstHalf = length - 3;
        int colLengthTotal = 0;
        int colLengthForLoop = colLengthTotal;
        //finds maximum product of all first half principal diagonals
        while (totalLengthFirstHalf > 0) {
            for (int r = 0; r < totalLengthFirstHalf; r++) {
                product = twoDimensionalArray[r][length - colLengthForLoop - 1] * twoDimensionalArray[r + 1][length - colLengthForLoop - 2] *
                        twoDimensionalArray[r + 2][length - colLengthForLoop - 3] * twoDimensionalArray[r + 3][length - colLengthForLoop - 4];
                colLengthForLoop++;
                if (maxProduct < product) {
                    maxProduct = product;
                }
            }
            totalLengthFirstHalf--;
            colLengthTotal++;
            colLengthForLoop = colLengthTotal;
        }
        int totalLengthSecondHalf = length - 3;
        int rowLengthTotal = 0;
        int rowLengthForLoop = rowLengthTotal;
        //finds maximum product of all second half secondary diagonals
        while (totalLengthSecondHalf > 0) {
            for (int c = 0; c < totalLengthSecondHalf; c++) {
                product = twoDimensionalArray[length - rowLengthForLoop - 1][c] * twoDimensionalArray[length - rowLengthForLoop - 2][c + 1] *
                        twoDimensionalArray[length - rowLengthForLoop - 3][c + 2] * twoDimensionalArray[length - rowLengthForLoop - 4][c + 3];
                rowLengthForLoop++;
                if (maxProduct < product) {
                    maxProduct = product;
                }
            }
            totalLengthSecondHalf--;
            rowLengthTotal++;
            rowLengthForLoop = rowLengthTotal;
        }
        return maxProduct;
    }
}
