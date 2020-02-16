package com.practice.array;

import java.io.IOException;
import java.util.Scanner;

public class Jumps {

	public static int jumps(int flagHeight, int jumpHeight) {

		int numberOfJumps = 0;
		if (flagHeight < jumpHeight) {
			return flagHeight;
		}
		int modValue = flagHeight % jumpHeight;
		if (modValue == 0) {
			return flagHeight / jumpHeight;
		} else if (modValue > 0) {
			return modValue + (flagHeight - modValue * jumpHeight);
		}
		return numberOfJumps;

	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = scan.nextInt();
	
		int k = Jumps.jumps(i, j);
		System.out.println("Jumps.main():" + k);
	}		


}
