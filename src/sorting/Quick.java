package sorting;

import java.util.Arrays;

public class Quick {
	public static void sort(int[] array) {
		qsort(array, 0, array.length - 1);
	}

	private static void qsort(int[] array, int begin, int end) {
		if (end > begin) {
			int index = partition(array, begin, end);
			qsort(array, begin, index - 1);
			qsort(array, index + 1, end);
		}
	}

	private static int partition(int[] array, int begin, int end) {
		int i = begin - 1;
		int x = array[end];
		int temp = 0;
		for (int j = begin; j < end; j++) {
			if (array[j] < x) {
				temp = array[++i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		array[end] = array[++i];
		array[i] = x;
		return i;
	}

	public static void main(String[] args) {
		int[] a = { 1, -1, 2, 0, 6, 1, 4, 34, 123, 4, 2, 2, 2, 2, 0, 4, 7, 8 };
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		Quick.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.equals(a, b));
	}
}