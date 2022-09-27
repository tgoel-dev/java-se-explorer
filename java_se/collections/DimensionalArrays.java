package collections;

import java.util.Arrays;

/**
 * Multi-Dimensional Arrays are primitive to Java.
 */
public class DimensionalArrays {

	public static int[] oneDimensionalArrays() {

		// Basic syntax: Object[]
		int[] init = { 12, 133, 44 }; // direct assignment works during initialization only.
		System.out.println("Initialized array: " + Arrays.toString(init));

		int size = 5;
		int[] arrayOfInts = new int[size]; // common

		arrayOfInts[0] = 10; // indexing begins at 0 and goes upto (size - 1)
		arrayOfInts[1] = 8;
		arrayOfInts[2] = 6;
		arrayOfInts[3] = 4;
		arrayOfInts[4] = 2;

		System.out.println(arrayOfInts[3]); // prints 4
		System.out.println(arrayOfInts.length); // prints size
		// System.out.println(Arrays.toString(arrayOfInts));

		return arrayOfInts;
	}

	@SuppressWarnings("unused")
	public static void multiDimensionalArrays() {

		int rows = 3;
		int columns = 3;

		// 2D Arrays
		String[][] table = new String[rows][columns];

		table[0][0] = "/\\";
		table[0][1] = "C1";
		table[0][2] = "C2";
		table[1][0] = "R2";
		table[2][0] = "R3";

		System.out.println(Arrays.toString(table));
		// [[/\, C1, C2], [R2, null, null], [R3, null, null]]

		// 2D Arrays can also have flexible columns lengths.
		int[][] flexible = { { 12, 2, 2 }, { 1, 4, 5 }, { 5, 6, 6, 3 }, { 1 } };

		// 3D Arrays
		int height = 3;
		int[][][] td = new int[height][][];

	}

	public static void main(String[] args) {
		oneDimensionalArrays();
		multiDimensionalArrays();

	}
}
