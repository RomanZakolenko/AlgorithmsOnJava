package sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void sorting(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 4, 5, 12, 1, 1, 3, 6, 4, 1, 23, 5, 100, 13 };
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		BubbleSort.sorting(a);
		Arrays.sort(b);
		System.out.println(Arrays.equals(a, b));
	}
}
