package com.practice.array;

// Finding the length of cells of 1s(regions) in a matrix of 0s and 1s

public class MatrixConnectedCellsOf1s {
  
  public static int getMaximumLengthOfConnectedCellsof1s(int[][] array) {

    int maxConnectedCells= 0;

    for(int row=0; i<array.length; i++) {
      for(int cloumn=0; j<array[row].length; j++) {
        //If element is 1 then calculate count in adjacent region
        if(array[row][column] == 1) {
          cellsCount = getConnectedCountsRegion(array, row, column);
          maxConncctedCells = Math.mac(cellsCount, maxConnectedCells)
        }
      } 
    }
    return maxConnectedCells;
  }

  public static int getConnectedCountsRegion(int[] array, int row, int column) {

    int connectCount = 0;
    // We have visited this node, we can mark it as 0
    array[row][column] = 0;

    // check if there are any connected 1s adjacent to the element
    for(int r=row-1; r<row+1; r++) {
      for(int c=column-1; c<column+1; column++) {
        if(row!=1 && column!=c) {
          connectCount += getConnectedCountsRegion(array, r, c);
        }   
      }
    }
    return connectCount;
  }

  
}
