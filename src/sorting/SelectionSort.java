package sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void sorting(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int min = array[i];
			int index = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					index = j;
				}
			}
			array[index] = array[i];
			array[i] = min;
		}
	}

	public static void main(String[] args) {
		int[] a = { 4, 5, 12, 1, 1, 3, 6, 4, 1, 23, 5, 100, 13 };
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		SelectionSort.sorting(a);
		Arrays.sort(b);
		System.out.println(Arrays.equals(a, b));
	}
}
