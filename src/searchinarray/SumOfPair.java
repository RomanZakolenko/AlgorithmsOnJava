package searchinarray;

import java.util.Arrays;
import sorting.BinarySearch;

public class SumOfPair {
	public static int countZero(int[] array) {
		int res = 0;
		int[] tempArray = new int[array.length];
		System.arraycopy(array, 0, tempArray, 0, array.length);
		Arrays.sort(tempArray);
		int index;
		for (int i = 0; i < tempArray.length; i++) {
			index = BinarySearch.binarySearch(tempArray, tempArray[i]);
			if (index != -1 && index > i) {
				res++;
			}
		}
		return res;
	}
}
