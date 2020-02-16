package com.test.array;

public class MatrixRotation {

	public static int[][] roatate(int[][] matrix) {
		int length = matrix.length;
		int[][] result = new int[matrix.length][matrix.length];

		for (int i = 0; i <= length - 1; i++) {

			for (int j = 0; j <= length - 1; j++) {
				int temp = matrix[i][j];

				result[i][j] = matrix[j][length - 1 - i];

				// result[i][j] = matrix[length - j - 1][i];
			}

		}
		return result;

	}

	// An Inplace function to rotate a N x N matrix
	// by 90 degrees in anti-clockwise direction
	static int[][] rotateMatrix(int N, int mat[][]) {
		// Consider all squares one by one
		for (int x = 0; x < N / 2; x++) {
			// Consider elements in group of 4 in
			// current square
			for (int y = x; y < N - x - 1; y++) {
				// store current cell in temp variable
				int temp = mat[x][y];

				// move values from right to top
				mat[x][y] = mat[y][N - 1 - x];

				// move values from bottom to right
				mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];

				// move values from left to bottom
				mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];

				// assign temp to left
				mat[N - 1 - y][x] = temp;
			}
		}
		return mat;
	}

	public static void printMatrix(int[][] matrix) {

		int length = matrix.length;

		for (int i = 0; i <= length - 1; i++) {

			for (int j = 0; j <= length - 1; j++) {
				int temp = matrix[i][j];
				System.out.print(" " + temp);
			}
			System.out.println("");
		}

	}

	public static int[][] roatateWithNOExtraSpace(int[][] matrix) {

		int n = matrix.length;

		for (int x = 0; x < n / 2; x++) {

			for (int y = 0; y < n - 1 - x; y++) {

				// Save the top left corner value in temp
				int temp = matrix[x][y];
				//
				matrix[x][y] = matrix[y][n - 1 - x];

				matrix[y][n - 1 - x] = matrix[n - 1 - x][n - 1 - y];

				matrix[n - 1 - x][n - 1 - y] = matrix[n - 1 - y][x];

				matrix[n - 1 - y][x] = temp;

			}

		}
		return matrix;
	}

	public static int[][] rotateInPlace(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
		return matrix;
	}

	public static void main(String[] args) {

		// Test Case 1
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		// roatate(matrix);
		// printMatrix(roatate(matrix));

		printMatrix(rotateMatrix(matrix.length, matrix));
	}

}
