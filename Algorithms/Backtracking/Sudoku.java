//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sudoku
{
    public static void main(String args[])
    {
        
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};        
            
            
        if(SolveSudoku(grid) == true)
            printGrid(grid);
        else
            System.out.print("NO solution exists");
        System.out.println();
    }

    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        return solve(grid, 0, 0);
    }
    
    static boolean solve(int grid[][], int row, int col) {
        System.out.println("00100" + row + " " + col);
        if (col == 9) {
            row = row + 1;
            col = 0;
        }

        while (row < 9) {
            while (col < 9) {
                System.out.println("00200" + row + " " + col);
                if (grid[row][col] == 0) { // is empty
                    for(int num = 1; num <= 9; ++num) {
                        
                        if(isSafe(grid, row, col, num)) {
                            // Set value
                            int oldGridValue = grid[row][col];
                            //System.out.println(row + "--" + col);
                            grid[row][col] = num;
                            
                            if (solve(grid, row, col + 1)) {
                                System.out.println("1111" + row + " " + col);
                                return true;
                            }
                                
                            // backtrack to old value
                            grid[row][col] = oldGridValue;
                        }
                    }
                    return false;
                }
                ++col;
                System.out.println("33A33" + row + " " + col);
            }
            ++row;
            col = 0;
            System.out.println("33B33" + row + " " + col);
        }
        System.out.println("3333" + row + " " + col);
        return true;
    }
    
    static boolean isSafe(int grid[][], int row, int col, int value) {
        //System.out.println("Check for " + row + " " + col + " " + value);
        //printGrid(grid);
        //System.out.println("V check for " + value + " " + row + " " + col);
        // vertical check
        for(int i = 0; i < 9; ++i) {
            if (grid[i][col] == value) {
                //System.out.println("V match for " + value + " " + i + " " + col);
                return false;
            }
        }
        //System.out.println("V pass for " + value + " " + row + " " + col);
        //System.out.println("H check for " + value + " " + row + " " + col);
        // horizontal check
        for(int i = 0; i < 9; ++i) {
            if (grid[row][i] == value) {
                //System.out.println("H match for " + value + " " + row + " " + i);
                return false;
            }
        }
        
        //System.out.println("H pass for " + value + " " + row + " " + col);
        //System.out.println("S check for " + value + " " + row + " " + col);
        // check sub-block of sudoku 3*3
        int subStartRow = (row / 3) * 3;
        int subStartCol = (col / 3) * 3;
        for (int i = subStartRow; i < (subStartRow + 3); ++i) {
            for (int j = subStartCol; j < (subStartCol + 3); ++j) {
                if (value == grid[i][j]) {
                    //System.out.println("S match for " + value + " " + i + " " + j);
                    return false;
                }
            }
        }
        //System.out.println("S pass for " + value + " " + row + " " + col);
        
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int r = 0; r < 9; ++r) {
            for(int c = 0; c < 9; ++c) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }
}