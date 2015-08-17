package sorting;

import java.util.Arrays;

public class Merge {
	private static int[] tempArray;

	public static void sort(int[] array) {
		tempArray = new int[array.length];
		sort(array, 0, array.length - 1);
	}

	private static void sort(int[] array, int begin, int end) {
		if (begin >= end) {
			return;
		}
		int mid = begin + (end - begin) / 2;
		sort(array, begin, mid);
		sort(array, mid + 1, end);
		merge(array, begin, mid, end);
	}

	private static void merge(int[] array, int begin, int mid, int end) {
		System.arraycopy(array, begin, tempArray, begin, end - begin + 1);
		int i = begin;
		int j = mid + 1;
		for (int k = begin; k <= end; k++) {
			if (i > mid) {
				array[k] = tempArray[j++];
			} else {
				if (j > end) {
					array[k] = tempArray[i++];
				} else {
					if (tempArray[i] > tempArray[j]) {
						array[k] = tempArray[j++];
					} else {
						array[k] = tempArray[i++];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 4, 5, 12, 1, 1, 3, 6, 4, 1, 23, 5, 100, 13, 1 };
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		Merge.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.equals(a, b));
	}
}
