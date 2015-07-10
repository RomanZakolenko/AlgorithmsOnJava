package matrix;

public class NotRightDimensionOfMatrix extends Exception {

	private static final long serialVersionUID = 1L;
	String comment = new String();

	public NotRightDimensionOfMatrix() {
	}

	public NotRightDimensionOfMatrix(String s) {
		super();
		comment = s;
	}

	public void printComment() {
		System.out.println(comment);
	}
}
