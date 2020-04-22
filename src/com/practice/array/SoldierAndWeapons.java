package com.practice.array;

public class SoldierAndWeapons {

	public static int getSoldiersWithNoWeaponsXOR(int number, int[] typesOfWeapons, int[] weaponExpertise) {

		if (number <= 0) {
			return 0;
		}
		int currentSum = getXOR(number, typesOfWeapons, weaponExpertise);
		int minSum = currentSum;
		if (minSum == 0) {
			return 0;
		}

		for (int i = 0; i < number - 1; i++) {
			leftRotatebyOne(weaponExpertise, number);
			currentSum = getXOR(number, typesOfWeapons, weaponExpertise);
			minSum = Math.min(currentSum, minSum);
		}

		return minSum;
	}

	public static void leftRotatebyOne(int arr[], int n) {
		int i, temp;
		temp = arr[0];
		for (i = 0; i < n - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = temp;
	}

	private static int getXOR(int number, int[] typesOfWeapons, int[] weaponExpertise) {
		int currentSum = 0;
		for (int i = 0; i < number; i++) {
			currentSum += typesOfWeapons[i] ^ weaponExpertise[i];
		}
		return currentSum;
	}

	public static void main(String[] args) {

		int[] array1 = { 0, 0, 1, 0 };
		int[] array2 = { 1, 0, 0, 0 };

		int[] array3 = { 0, 1, 1, 0, 1, 0 };
		int[] array4 = { 1, 1, 1, 0, 1, 0 };

		int[] array5 = { 1, 0, 1, 0 };
		int[] array6 = { 0, 0, 0, 0 };

		System.out.println(
				"SoldierAndWeapons.enclosing_method():" + getSoldiersWithNoWeaponsXOR(array1.length, array1, array2));
		System.out.println(
				"SoldierAndWeapons.enclosing_method():" + getSoldiersWithNoWeaponsXOR(array3.length, array3, array4));

		System.out.println(
				"SoldierAndWeapons.enclosing_method():" + getSoldiersWithNoWeaponsXOR(array5.length, array5, array6));

	}

}
