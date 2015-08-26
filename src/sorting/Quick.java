package sorting;

public class Quick {
	public static void sort(int[] array) {

	}

	private static void sort(int[] array, int begin, int end) {
		if (begin <= end) {
			return;
		}
		int i = begin;
		int j = end;
		int index = begin + (end - begin) / 2;
		while (i < j) {
			while (array[index] > array[i]) {
				i++;
			}
			while (array[index] < array[j]) {
				j--;
			}
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
}