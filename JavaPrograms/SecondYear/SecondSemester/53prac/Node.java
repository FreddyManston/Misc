public class Node {
	String element;
	int freq;
	Node left, right;

	/** Default initialiser */
	public Node() {
	}

	/** Left and Right node initialiser */
	public Node(Node make_left, Node make_right) {
		left = make_left;
		right = make_right;
	}

	/** Element accessor */
	public String getElement() {
		return element;
	}

	/** Frequency accessor */
	public int getFreq() {
		return freq;
	}

	/** Left node accessor */
	public Node getLeft() {
		return left;

	}/** Right node accessor */
	public Node getRight() {
		return right;
	}

	/** Element modifier */
	public void setElement(String make_element) {
		element = make_element;
	}

	/** Frequency modifier */
	public void setFreq(int make_freq) {
		freq = make_freq;
	}

	/** Left node modifier */
	public void setLeft(Node make_left) {
		left = make_left;

	}/** Right node modifier */
	public void setRight(Node make_right) {
		right = make_right;
	}
}