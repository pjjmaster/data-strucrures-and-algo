package com.practice.array;

class MatrixConnectedCellsOf1s {

  public static int connectedCell(int[][] array) {
    // Write your code here
    int maxConnectedCells = 0;

    for (int row = 0; row < array.length; row++) {
      for (int column = 0; column < array[row].length; column++) {
        //If element is 1 then calculate count in adjacent region
        if (array[row][column] == 1) {
          int cellsCount = getConnectedCountsRegion(array, row, column);
          maxConnectedCells = Math.max(cellsCount, maxConnectedCells);
        }
      }
    }
    return maxConnectedCells;
  }

  public static int getConnectedCountsRegion(int[][] array, int row, int column) {

    if (row < 0 || column < 0 || row >= array.length || column >= array[row].length) {
      return 0;
    }

    if (array[row][column] == 0) {
      return 0;
    }

    int connectCount = 1;
    // We have visited this node, we can mark it as 0
    array[row][column] = 0;

    // check if there are any connected 1s adjacent to the element
    for (int r = row - 1; r <= row + 1; r++) {
      for (int c = column - 1; c <= column + 1; c++) {
        if (row == r && column == c) {
          continue;
        }
        connectCount += getConnectedCountsRegion(array, r, c);
      }
    }
    return connectCount;
  }


  public static void main(String[] args) {
    int[][] array = {
        {1, 1, 0, 0, 0},
        {0, 1, 1, 0, 0},
        {0, 0, 1, 0, 1},
        {1, 0, 0, 0, 1},
        {0, 1, 0, 1, 1},
        {0, 1, 0, 1, 1},
        {0, 1, 0, 1, 1}
    };

    System.out.println(connectedCell(array));

  }


}
