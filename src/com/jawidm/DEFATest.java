package com.jawidm;

public class DEFATest {

    private int[] array;
    private int length;
    private int [][] twoDimensionalArray;

    public DEFATest(int[] array, int length, int[][] twoDimensionalArray) {
        this.array = array;
        this.length = length;
        this.twoDimensionalArray = twoDimensionalArray;
    }

    public int findMaxProductInRow() {

        this.array = array;
        this.length = length;
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

        this.length = length;
        this.twoDimensionalArray = twoDimensionalArray;
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

        this.array = array;
        this.length = length;
        if (length < 4) {
            return -1;
        }

        //find max product in diagonals med en for loop
        int product;
        int maxProduct = 0;
        int totalLengthFirstHalf = length - 3;
        int colLengthTotall = 0;
        int colLengthForLoop = colLengthTotall;
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
            colLengthTotall++;
            colLengthForLoop = colLengthTotall;

        }

        int totalLengthSecondHalf = length - 3;
        int rowLengthTotall = 0;
        int rowLengthForLoop = rowLengthTotall;
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
            rowLengthTotall++;
            rowLengthForLoop = rowLengthTotall;
        }

        return maxProduct;
    }

    public int findMaxProductInAllSecondaryDiagonals() {

        this.array = array;
        this.length = length;
        if (length < 4) {
            return -1;
        }
        //find max product in diagonals med en for loop
        int product;
        int maxProduct = 0;
        int totalLengthFirstHalf = length - 3;
        int colLengthTotall = 0;
        int colLengthForLoop = colLengthTotall;
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
            colLengthTotall++;
            colLengthForLoop = colLengthTotall;
        }

        int totalLengthSecondHalf = length - 3;
        int rowLengthTotall = 0;
        int rowLengthForLoop = rowLengthTotall;
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
            rowLengthTotall++;
            rowLengthForLoop = rowLengthTotall;
        }
        return maxProduct;
    }

    /*
    public static int findMaxProductInPrincipalDiagonal(int[][] twoDimensionalArray, int length) {
        //checks the size of array, must be more minimum four
        if(length < 4){
            return -1;
        }

        //find max product in diagonals
        int product = Integer.MIN_VALUE;
        int maxProduct = 0;
        for (int r = 0; r < length - 3; r++) {
            for (int c = 0; c < length; c++) {
                if (r == c) {
                    product = twoDimensionalArray[r][c] * twoDimensionalArray[r+1][c+1] *
                            twoDimensionalArray[r+2][c+2] * twoDimensionalArray[r+3][c+3];
                }
                if (maxProduct < product) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    //another method to find principal diagonal which one for loop used

    public static int findMaxProductInPrincipalDiagonalOneForLoop(int[][] twoDimensionalArray, int length) {
        //checks the size of array, must be more minimum four
        if(length < 4){
            return -1;
        }

        //find max product in diagonals med en for loop
        int product = Integer.MIN_VALUE;
        int maxProduct = 0;
        for (int r = 0; r < length - 3; r++) {
            product = twoDimensionalArray[r][r] * twoDimensionalArray[r+1][r+1] *
            twoDimensionalArray[r+2][r+2] * twoDimensionalArray[r+3][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }

    public static int findMaxProductInSecondaryDiagonal(int[][] twoDimensionalArray, int length) {
        //checks the size of array, must be more minimum four
        if(length < 4){
            return -1;
        }

        //find max product in diagonals med en for loop
        int product;
        int maxProduct = 0;
        for (int r = 0; r < length - 3; r++) {
            product = twoDimensionalArray[r][length-r-1] * twoDimensionalArray[r+1][length-r-2] *
                    twoDimensionalArray[r+2][length-r-3] * twoDimensionalArray[r+3][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }

    public static int findMaxProductInAllPrincipalDiagonalsOneByOne(int[][] twoDimensionalArray, int length) {
        if(length < 4){
            return -1;
        }

        //find max product in diagonals med en for loop
        int product;
        int maxProduct = 0;
        for (int r = 0; r < length - 3; r++) {
            product = twoDimensionalArray[r][r] * twoDimensionalArray[r+1][r+1] *
                    twoDimensionalArray[r+2][r+2] * twoDimensionalArray[r+3][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 4; r++) {
            product = twoDimensionalArray[r][r+1] * twoDimensionalArray[r+1][r+2] *
                    twoDimensionalArray[r+2][r+3] * twoDimensionalArray[r+3][r+4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 5; r++) {
            product = twoDimensionalArray[r][r+2] * twoDimensionalArray[r+1][r+3] *
                    twoDimensionalArray[r+2][r+4] * twoDimensionalArray[r+3][r+5];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 6; r++) {
            product = twoDimensionalArray[r][r+3] * twoDimensionalArray[r+1][r+4] *
                    twoDimensionalArray[r+2][r+5] * twoDimensionalArray[r+3][r+6];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 7; r++) {
            product = twoDimensionalArray[r][r+4] * twoDimensionalArray[r+1][r+5] *
                    twoDimensionalArray[r+2][r+6] * twoDimensionalArray[r+3][r+7];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 8; r++) {
            product = twoDimensionalArray[r][r+5] * twoDimensionalArray[r+1][r+6] *
                    twoDimensionalArray[r+2][r+7] * twoDimensionalArray[r+3][r+8];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 9; r++) {
            product = twoDimensionalArray[r][r+6] * twoDimensionalArray[r+1][r+7] *
                    twoDimensionalArray[r+2][r+8] * twoDimensionalArray[r+3][r+9];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 10; r++) {
            product = twoDimensionalArray[r][r+7] * twoDimensionalArray[r+1][r+8] *
                    twoDimensionalArray[r+2][r+9] * twoDimensionalArray[r+3][r+10];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 11; r++) {
            product = twoDimensionalArray[r][r+8] * twoDimensionalArray[r+1][r+9] *
                    twoDimensionalArray[r+2][r+10] * twoDimensionalArray[r+3][r+11];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 12; r++) {
            product = twoDimensionalArray[r][r+9] * twoDimensionalArray[r+1][r+10] *
                    twoDimensionalArray[r+2][r+11] * twoDimensionalArray[r+3][r+12];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 13; r++) {
            product = twoDimensionalArray[r][r+10] * twoDimensionalArray[r+1][r+11] *
                    twoDimensionalArray[r+2][r+12] * twoDimensionalArray[r+3][r+13];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 14; r++) {
            product = twoDimensionalArray[r][r+11] * twoDimensionalArray[r+1][r+12] *
                    twoDimensionalArray[r+2][r+13] * twoDimensionalArray[r+3][r+14];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 15; r++) {
            product = twoDimensionalArray[r][r+12] * twoDimensionalArray[r+1][r+13] *
                    twoDimensionalArray[r+2][r+14] * twoDimensionalArray[r+3][r+15];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 16; r++) {
            product = twoDimensionalArray[r][r+13] * twoDimensionalArray[r+1][r+14] *
                    twoDimensionalArray[r+2][r+15] * twoDimensionalArray[r+3][r+16];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 17; r++) {
            product = twoDimensionalArray[r][r+14] * twoDimensionalArray[r+1][r+15] *
                    twoDimensionalArray[r+2][r+16] * twoDimensionalArray[r+3][r+17];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 18; r++) {
            product = twoDimensionalArray[r][r+15] * twoDimensionalArray[r+1][r+16] *
                    twoDimensionalArray[r+2][r+17] * twoDimensionalArray[r+3][r+18];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 19; r++) {
            product = twoDimensionalArray[r][r+16] * twoDimensionalArray[r+1][r+17] *
                    twoDimensionalArray[r+2][r+18] * twoDimensionalArray[r+3][r+19];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 4; r++) {
            product = twoDimensionalArray[r+1][r] * twoDimensionalArray[r+2][r+1] *
                    twoDimensionalArray[r+3][r+2] * twoDimensionalArray[r+4][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 5; r++) {
            product = twoDimensionalArray[r+2][r] * twoDimensionalArray[r+3][r+1] *
                    twoDimensionalArray[r+4][r+2] * twoDimensionalArray[r+5][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 6; r++) {
            product = twoDimensionalArray[r+3][r] * twoDimensionalArray[r+4][r+1] *
                    twoDimensionalArray[r+5][r+2] * twoDimensionalArray[r+6][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 7; r++) {
            product = twoDimensionalArray[r+4][r] * twoDimensionalArray[r+5][r+1] *
                    twoDimensionalArray[r+6][r+2] * twoDimensionalArray[r+7][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 8; r++) {
            product = twoDimensionalArray[r+5][r] * twoDimensionalArray[r+6][r+1] *
                    twoDimensionalArray[r+7][r+2] * twoDimensionalArray[r+8][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 9; r++) {
            product = twoDimensionalArray[r+6][r] * twoDimensionalArray[r+7][r+1] *
                    twoDimensionalArray[r+8][r+2] * twoDimensionalArray[r+9][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 10; r++) {
            product = twoDimensionalArray[r+7][r] * twoDimensionalArray[r+8][r+1] *
                    twoDimensionalArray[r+9][r+2] * twoDimensionalArray[r+10][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 11; r++) {
            product = twoDimensionalArray[r+8][r] * twoDimensionalArray[r+9][r+1] *
                    twoDimensionalArray[r+10][r+2] * twoDimensionalArray[r+11][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 12; r++) {
            product = twoDimensionalArray[r+9][r] * twoDimensionalArray[r+10][r+1] *
                    twoDimensionalArray[r+11][r+2] * twoDimensionalArray[r+12][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 13; r++) {
            product = twoDimensionalArray[r+10][r] * twoDimensionalArray[r+11][r+1] *
                    twoDimensionalArray[r+12][r+2] * twoDimensionalArray[r+13][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 14; r++) {
            product = twoDimensionalArray[r+11][r] * twoDimensionalArray[r+12][r+1] *
                    twoDimensionalArray[r+13][r+2] * twoDimensionalArray[r+14][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 15; r++) {
            product = twoDimensionalArray[r+12][r] * twoDimensionalArray[r+13][r+1] *
                    twoDimensionalArray[r+14][r+2] * twoDimensionalArray[r+15][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 16; r++) {
            product = twoDimensionalArray[r+13][r] * twoDimensionalArray[r+14][r+1] *
                    twoDimensionalArray[r+15][r+2] * twoDimensionalArray[r+16][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 17; r++) {
            product = twoDimensionalArray[r+14][r] * twoDimensionalArray[r+15][r+1] *
                    twoDimensionalArray[r+16][r+2] * twoDimensionalArray[r+17][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 18; r++) {
            product = twoDimensionalArray[r+15][r] * twoDimensionalArray[r+16][r+1] *
                    twoDimensionalArray[r+17][r+2] * twoDimensionalArray[r+18][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 19; r++) {
            product = twoDimensionalArray[r+16][r] * twoDimensionalArray[r+17][r+1] *
                    twoDimensionalArray[r+18][r+2] * twoDimensionalArray[r+19][r+3];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }

    public static int findMaxProductInAllSecondaryDiagonalsOneByOne(int[][] twoDimensionalArray, int length) {
        //checks the size of array, most be more minimum four
        if(length < 4){
            return -1;
        }

        //find max product in diagonals med en for loop
        int product;
        int maxProduct = 0;

        for (int r = 0; r < length - 3; r++) {
            product = twoDimensionalArray[r][length-r-1] * twoDimensionalArray[r+1][length-r-2] *
                    twoDimensionalArray[r+2][length-r-3] * twoDimensionalArray[r+3][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 4; r++) {
            product = twoDimensionalArray[r][length-r-2] * twoDimensionalArray[r+1][length-r-3] *
                    twoDimensionalArray[r+2][length-r-4] * twoDimensionalArray[r+3][length-r-5];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 5; r++) {
            product = twoDimensionalArray[r][length-r-3] * twoDimensionalArray[r+1][length-r-4] *
                    twoDimensionalArray[r+2][length-r-5] * twoDimensionalArray[r+3][length-r-6];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 6; r++) {
            product = twoDimensionalArray[r][length-r-4] * twoDimensionalArray[r+1][length-r-5] *
                    twoDimensionalArray[r+2][length-r-6] * twoDimensionalArray[r+3][length-r-7];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 7; r++) {
            product = twoDimensionalArray[r][length-r-5] * twoDimensionalArray[r+1][length-r-6] *
                    twoDimensionalArray[r+2][length-r-7] * twoDimensionalArray[r+3][length-r-8];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 8; r++) {
            product = twoDimensionalArray[r][length-r-6] * twoDimensionalArray[r+1][length-r-7] *
                    twoDimensionalArray[r+2][length-r-8] * twoDimensionalArray[r+3][length-r-9];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 9; r++) {
            product = twoDimensionalArray[r][length-r-7] * twoDimensionalArray[r+1][length-r-8] *
                    twoDimensionalArray[r+2][length-r-9] * twoDimensionalArray[r+3][length-r-10];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 10; r++) {
            product = twoDimensionalArray[r][length-r-8] * twoDimensionalArray[r+1][length-r-9] *
                    twoDimensionalArray[r+2][length-r-10] * twoDimensionalArray[r+3][length-r-11];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 11; r++) {
            product = twoDimensionalArray[r][length-r-9] * twoDimensionalArray[r+1][length-r-10] *
                    twoDimensionalArray[r+2][length-r-11] * twoDimensionalArray[r+3][length-r-12];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 12; r++) {
            product = twoDimensionalArray[r][length-r-10] * twoDimensionalArray[r+1][length-r-11] *
                    twoDimensionalArray[r+2][length-r-12] * twoDimensionalArray[r+3][length-r-13];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 13; r++) {
            product = twoDimensionalArray[r][length-r-11] * twoDimensionalArray[r+1][length-r-12] *
                    twoDimensionalArray[r+2][length-r-13] * twoDimensionalArray[r+3][length-r-14];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 14; r++) {
            product = twoDimensionalArray[r][length-r-12] * twoDimensionalArray[r+1][length-r-13] *
                    twoDimensionalArray[r+2][length-r-14] * twoDimensionalArray[r+3][length-r-15];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }
        for (int r = 0; r < length - 15; r++) {
            product = twoDimensionalArray[r][length-r-13] * twoDimensionalArray[r+1][length-r-14] *
                    twoDimensionalArray[r+2][length-r-15] * twoDimensionalArray[r+3][length-r-16];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }
        for (int r = 0; r < length - 16; r++) {
            product = twoDimensionalArray[r][length-r-14] * twoDimensionalArray[r+1][length-r-15] *
                    twoDimensionalArray[r+2][length-r-16] * twoDimensionalArray[r+3][length-r-17];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 17; r++) {
            product = twoDimensionalArray[r][length-r-15] * twoDimensionalArray[r+1][length-r-16] *
                    twoDimensionalArray[r+2][length-r-17] * twoDimensionalArray[r+3][length-r-18];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 18; r++) {
            product = twoDimensionalArray[r][length-r-16] * twoDimensionalArray[r+1][length-r-17] *
                    twoDimensionalArray[r+2][length-r-18] * twoDimensionalArray[r+3][length-r-19];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 19; r++) {
            product = twoDimensionalArray[r][length-r-17] * twoDimensionalArray[r+1][length-r-18] *
                    twoDimensionalArray[r+2][length-r-19] * twoDimensionalArray[r+3][length-r-20];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 4; r++) {
            product = twoDimensionalArray[r+1][length-r-1] * twoDimensionalArray[r+2][length-r-2] *
                    twoDimensionalArray[r+3][length-r-3] * twoDimensionalArray[r+4][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 5; r++) {
            product = twoDimensionalArray[r+2][length-r-1] * twoDimensionalArray[r+3][length-r-2] *
                    twoDimensionalArray[r+4][length-r-3] * twoDimensionalArray[r+5][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 6; r++) {
            product = twoDimensionalArray[r+3][length-r-1] * twoDimensionalArray[r+4][length-r-2] *
                    twoDimensionalArray[r+5][length-r-3] * twoDimensionalArray[r+6][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 7; r++) {
            product = twoDimensionalArray[r+4][length-r-1] * twoDimensionalArray[r+5][length-r-2] *
                    twoDimensionalArray[r+6][length-r-3] * twoDimensionalArray[r+7][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 8; r++) {
            product = twoDimensionalArray[r+5][length-r-1] * twoDimensionalArray[r+6][length-r-2] *
                    twoDimensionalArray[r+7][length-r-3] * twoDimensionalArray[r+8][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 9; r++) {
            product = twoDimensionalArray[r+6][length-r-1] * twoDimensionalArray[r+7][length-r-2] *
                    twoDimensionalArray[r+8][length-r-3] * twoDimensionalArray[r+9][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 10; r++) {
            product = twoDimensionalArray[r+7][length-r-1] * twoDimensionalArray[r+8][length-r-2] *
                    twoDimensionalArray[r+9][length-r-3] * twoDimensionalArray[r+10][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 11; r++) {
            product = twoDimensionalArray[r+8][length-r-1] * twoDimensionalArray[r+9][length-r-2] *
                    twoDimensionalArray[r+10][length-r-3] * twoDimensionalArray[r+11][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 12; r++) {
            product = twoDimensionalArray[r+9][length-r-1] * twoDimensionalArray[r+10][length-r-2] *
                    twoDimensionalArray[r+11][length-r-3] * twoDimensionalArray[r+12][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 13; r++) {
            product = twoDimensionalArray[r+10][length-r-1] * twoDimensionalArray[r+11][length-r-2] *
                    twoDimensionalArray[r+12][length-r-3] * twoDimensionalArray[r+13][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 14; r++) {
            product = twoDimensionalArray[r+11][length-r-1] * twoDimensionalArray[r+12][length-r-2] *
                    twoDimensionalArray[r+13][length-r-3] * twoDimensionalArray[r+14][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 15; r++) {
            product = twoDimensionalArray[r+12][length-r-1] * twoDimensionalArray[r+13][length-r-2] *
                    twoDimensionalArray[r+14][length-r-3] * twoDimensionalArray[r+15][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 16; r++) {
            product = twoDimensionalArray[r+13][length-r-1] * twoDimensionalArray[r+14][length-r-2] *
                    twoDimensionalArray[r+15][length-r-3] * twoDimensionalArray[r+16][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 17; r++) {
            product = twoDimensionalArray[r+14][length-r-1] * twoDimensionalArray[r+15][length-r-2] *
                    twoDimensionalArray[r+16][length-r-3] * twoDimensionalArray[r+17][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 18; r++) {
            product = twoDimensionalArray[r+15][length-r-1] * twoDimensionalArray[r+16][length-r-2] *
                    twoDimensionalArray[r+17][length-r-3] * twoDimensionalArray[r+18][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }

        for (int r = 0; r < length - 19; r++) {
            product = twoDimensionalArray[r+16][length-r-1] * twoDimensionalArray[r+17][length-r-2] *
                    twoDimensionalArray[r+18][length-r-3] * twoDimensionalArray[r+19][length-r-4];
            if (maxProduct < product) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }
    */
}
