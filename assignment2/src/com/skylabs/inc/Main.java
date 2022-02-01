package com.skylabs.inc;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        int score = 0;
        boolean displayedWin = false;
        boolean isWithinRange = false;
        int userGridInput = 4;

        do {
            System.out.println("Please enter a dimension betweeen 4 and 10 for the grid");
            userGridInput = in.nextInt();

            if(userGridInput>=4 && userGridInput<=10) {
                isWithinRange = true;
            }
        }while(!isWithinRange);

        int[][] grid= new int[userGridInput][userGridInput];

//		for ( int i = 0 ; i < grid.length; i++) {
//			for( int j = 0 ; j <grid[i].length; j++) {
//
//				if(i != 0) {
//					grid[i][j] = 1;
//				}
//		}
//	}
//		grid[0][1]=512;
//		grid[0][2]=512;
//		grid[3][3]= 512;
//		grid[2][3] = 512;

        int[][] emptyCells = new int[grid.length * grid.length][2];

        int num = freeCells(grid, emptyCells);
        addOne(grid, emptyCells, num, rnd);

        num = freeCells(grid, emptyCells);
        addOne(grid, emptyCells, num, rnd);

        displayedWin = display(grid,displayedWin);
        while(true) {
            System.out.println("Use W, A, S or D to move the cells of the grid around");
            char userGameInput = Character.toUpperCase(in.next().charAt(0));

            if(userGameInput == 'W') {
                movingCellsUp(grid, emptyCells, num, rnd);
            }
            else if(userGameInput == 'A') {
                movingCellsLeft(grid, num, emptyCells, rnd);
            }
            else if(userGameInput == 'S') {
                movingCellsDown(grid, num, emptyCells, rnd);
            }
            else if(userGameInput == 'D') {
                movingCellsRight(grid, emptyCells, num, rnd);
            }
            else {
                System.out.println("Please enter a valid letter");
            }
            displayedWin = display(grid,displayedWin);
        }

    }

    //method to get the grid built and displayed
    public static boolean display(int[][] grid,boolean displayedWin) {
        boolean foundWin = false;
        for(int col=0; col< grid[0].length; col++) {
            System.out.print("+----");
        }
        System.out.print("+");

        System.out.println();
        for(int row=0; row< grid.length; row++) {

            System.out.print("|");

            for(int col=0; col< grid[row].length; col++) {


                if(grid[row][col] == 0) {
                    System.out.print("    ");
                }
                else if(grid[row][col] < 10) {
                    System.out.print("   ");
                    System.out.print(grid[row][col]);
                }
                else if(grid[row][col] < 100) {
                    System.out.print("  ");
                    System.out.print(grid[row][col]);
                }
                else if(grid[row][col] <1000) {
                    System.out.print(" ");
                    System.out.print(grid[row][col]);
                }
                else {
                    System.out.print("");
                    System.out.print(grid[row][col]);
                }
                System.out.print("|");
                if(!displayedWin) {
                    if(grid[row][col] ==1024) {
                        foundWin = true;
                    }
                }
            }
            System.out.println();


            for(int col=0; col< grid[row].length; col++) {
                System.out.print("+----");
            }

            System.out.print("+");
            System.out.println();
        }
        if(!displayedWin) {
            if(foundWin) {
                System.out.println("you have won.");
                displayedWin = true;
            }
        }
        return displayedWin;
    }
//This method tells us the free cells which would tell us which cell to add a 1 tile to after each turn

    public static int freeCells(int[][] grid, int[][] emptyCells) {

        int counter=0;

        for(int i=0; i<grid.length; i++) {

            for(int j=0; j<grid[i].length; j++) {

                if(grid[i][j] == 0) {
                    emptyCells[counter][0]=i;
                    emptyCells[counter][1] = j;
                    counter++;
                }

            }
        }
//To print out empty cells if needed
//		for ( int i = 0 ; i < (grid.length*grid.length); i++) {
//			for( int j = 0 ; j <2; j++) {
//				System.out.println(emptyCells[i][j]);
//			}
//		}

        return counter;
    }

//This method helps us add 1 to a random cell

    public static void addOne(int[][]grid, int[][]emptyCells, int num, Random rnd) {

        int randomNum = rnd.nextInt(num);

        grid[emptyCells[randomNum][0]][emptyCells[randomNum][1]] = 1;

    }

//This method helps us with the games controls

    public static char gameControls(Scanner in) {

        do {
            System.out.println("Use W, A, S or D to move the cells of the grid around");
            char userGameInput = Character.toUpperCase(in.next().charAt(0));

            if(userGameInput == 'W' || userGameInput == 'A' || userGameInput == 'S' || userGameInput == 'D') {
                return userGameInput;
            }

        }while(true);
    }

    //This is to actually move the cells
    public static int[][] movingCellsRight(int grid[][], int[][] emptyCells, int num, Random rnd) {

        int[] sortingArray = new int[grid.length];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid.length; j++) {
                sortingArray[j] = grid[i][j];
            }
            move(sortingArray);
            mergeCells(sortingArray);
            move(sortingArray);

            for(int j=0; j<grid.length; j++) {
                grid[i][j] = sortingArray[j];
            }
        }

        num = freeCells(grid, emptyCells);
        addOne(grid, emptyCells, num, rnd);

        return grid;

    }

    public static int[][] movingCellsLeft(int grid[][], int num, int[][] emptyCells, Random rnd) {

        int[] sortingArray = new int[grid.length];

        for(int i=0; i<grid.length; i++) {
            for( int j=grid.length-1; j>=0; j--) {
                sortingArray[grid.length-j-1] = grid[i][j];
            }
            move(sortingArray);
            mergeCells(sortingArray);
            move(sortingArray);
            for( int j=grid.length-1; j>=0; j--) {
                grid[i][j] = sortingArray[grid.length-j-1];
            }
        }

        num = freeCells(grid, emptyCells);
        addOne(grid, emptyCells, num, rnd);

        return grid;


    }

    public static int[][] movingCellsUp(int grid[][], int[][] emptyCells, int num, Random rnd) {

        int[] sortingArray = new int[grid.length];

        for(int j=0; j<grid.length; j++) {
            for( int i=grid.length-1; i>=0; i--) {
                sortingArray[grid.length-i-1] = grid[i][j];
            }
            move(sortingArray);
            mergeCells(sortingArray);
            move(sortingArray);
            for( int i=grid.length-1; i>=0; i--) {
                grid[i][j] = sortingArray[grid.length-i-1];
            }
        }

        num = freeCells(grid, emptyCells);
        addOne(grid, emptyCells, num, rnd);

        return grid;


    }

    public static int[][] movingCellsDown(int grid[][], int num, int[][] emptyCells, Random rnd) {

        int[] sortingArray = new int[grid.length];

        for(int j=0; j<grid.length; j++) {
            for(int i=0; i<grid.length; i++) {
                sortingArray[i] = grid[i][j];
            }
            move(sortingArray);
            mergeCells(sortingArray);
            move(sortingArray);
            for(int i=0; i<grid.length; i++) {
                grid[i][j] = sortingArray[i];
            }
        }

        num = freeCells(grid, emptyCells);
        addOne(grid, emptyCells, num, rnd);

        return grid;

    }



    public static int[] move(int sortingArray[]) {

//		sortingArray[0] =1;
//		sortingArray[1] =2;
//		sortingArray[2] =3;
//		sortingArray[3] =4;

        for(int i=sortingArray.length-2; i>=0; i--) {

            if(sortingArray[i] != 0) {

                int lastZero = i;

                for(int j=i+1; j<sortingArray.length; j++) {

                    if(sortingArray[j] == 0) {
                        lastZero = j;
                    }
                    else {
                        break;
                    }
                }

                if(lastZero != i) {
                    sortingArray[lastZero] = sortingArray[i];
                    sortingArray[i] = 0;
                }
            }

        }

        return sortingArray;
    }

    public static int[] mergeCells(int sortingArray[]) {

        for(int i=0; i<sortingArray.length-1; i++) {

            if(sortingArray[i] == sortingArray[i+1]) {
                sortingArray[i+1] = sortingArray[i] + sortingArray[i+1];
                //score+= sortingArray[i+1];
                sortingArray[i] = 0;

            }

        }
        return sortingArray;
    }


}