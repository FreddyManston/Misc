public class Tree {
	private Node root;

	/** Default initialiser */
	public Tree() {	
	}

	/** Root initialiser */
	public Tree(Node make_root) {
		root = make_root;
	}

	/** Root modifier */
	public Node getRoot() {
		return root;
	}

	/** Root accessor */
	public void setRoot(Node make_root) {
		root = make_root;
	}
}