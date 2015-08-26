package sorting;

import java.util.Arrays;

public class Quick {
	public static void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private static void sort(int[] array, int begin, int end) {
		if (begin >= end) {
			return;
		}
		int i = begin;
		int j = end;
		int index = begin + (end - begin) / 2;
		System.out.println(Arrays.toString(array));
		System.out.println();
		while (i < j) {
			while (array[index] > array[i]) {
				i++;
			}
			while (array[index] < array[j]) {
				j--;
			}
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
			System.out.println(Arrays.toString(array));
		}
		if (begin < j) {
			sort(array, begin, j);
		}
		if (i < end) {
			sort(array, i, end);
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, -1, 2,  0, 6, 7, 8 };
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		Quick.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.toString(a));
	}
}