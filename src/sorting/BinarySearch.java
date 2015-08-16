package sorting;

public class BinarySearch {
	public static int binarySearch(int[] array, int key) {
		int first = 0;
		int last = array.length - 1;
		int middle;
		while (first <= last) {
			middle = first + (last - first) / 2;
			if (array[middle] > key) {
				last = middle - 1;
			} else {
				if (array[middle] < key) {
					first = middle + 1;
				} else {
					return middle;
				}
			}
		}
		return -1;
	}
}
