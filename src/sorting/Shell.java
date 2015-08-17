package sorting;

import java.util.Arrays;

public class Shell {
	public static void sort(int[] array) {
		for (int d = array.length / 2; d >= 1; d /= 2) {
			for (int i = d; i < array.length; i += d) {
				int key = array[i];
				int index = i - d;
				while (index >= 0 && key < array[index]) {
					array[index + d] = array[index];
					index -= d;
				}
				array[index + d] = key;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 4, 5, 12, 1, 1, 3, 6, 4, 1, 23, 5, 100, 13 };
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		Shell.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.equals(a, b));
	}
}
