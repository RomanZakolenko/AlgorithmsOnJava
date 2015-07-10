package sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void sorting(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int index = i - 1;
			while (index >= 0 && key < array[index]) {
				array[index + 1] = array[index];
				index--;
			}
			array[index + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] a = { 4, 5, 12, 1, 1, 3, 6, 4, 1, 23, 5, 100, 13 };
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		InsertionSort.sorting(a);
		Arrays.sort(b);
		System.out.println(Arrays.equals(a, b));
	}
}
