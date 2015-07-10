package matrix;

import java.util.Arrays;

public class Matrix {

	public static double dot(double[] x, double[] y) {
		double res = 0;
		for (int i = 0; i < x.length; i++) {
			res += x[i] * y[i];
		}
		return res;
	}

	public static double[][] mult(double[][] a, double[][] b) {
		double[][] res = new double[a.length][b[0].length];
		if (a[0].length != b.length) {
			new NotRightDimensionOfMatrix().printStackTrace();
		} else {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					for (int j2 = 0; j2 < a[0].length; j2++) {
						res[i][j] += a[i][j2] * b[j2][j];
					}
				}
			}
		}
		return res;
	}

	public static double[][] transpose(double[][] a) {
		double[][] res = new double[a[0].length][a.length];
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				res[i][j] = a[j][i];
			}
		}
		return res;
	}

	public static double[] mult(double[][] a, double[] x) {
		double[] res = new double[a.length];
		if (a[0].length != x.length) {
			new NotRightDimensionOfMatrix().printStackTrace();
		} else {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					res[i] += a[i][j] * x[j];
				}
			}
		}
		return res;
	}

	public static double[] mult(double[] y, double[][] a) {
		double[] res = new double[a[0].length];
		if (a.length != y.length) {
			new NotRightDimensionOfMatrix().printStackTrace();
		} else {
			for (int i = 0; i < a[0].length; i++) {
				for (int j = 0; j < a.length; j++) {
					res[i] += a[j][i] * y[j];
				}
			}
		}
		return res;
	}

	public static void drawVector(double[] a) {
		System.out.println(Arrays.toString(a));
	}

	public static void drawMatrix(double[][] a) {
		for (int i = 0; i < a.length; i++) {
			drawVector(a[i]);
		}
	}

	public static void main(String[] args) {
		double[] a = { 1, 4, 5, 3 };
		double[][] c = { { 3, 3 }, { 3, 3 }, { 3, 3 }, { 3, 3 } };
		double[] b = { 44, 4, 12, 3, 12 };
		double[][] x = { { 1, 4, 2, 1 }, { 4, 1, 4, 3 } };
		double[][] x1 = { { 1, 4, 2, 1, 1 }, { 4, 1, 4, 3, 2 }, { 4, 1, 4, 3, 2 }, { 4, 1, 4, 3, 2 }, };
		drawVector(mult(x, a));
		System.out.println();
		drawMatrix(mult(x, x1));
		System.out.println();
		drawVector(mult(a, c));
		System.out.println(dot(a, b));
	}
}
