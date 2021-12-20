

public class BinaryTree {
	class Node {
		String key;
		Node left, right;

		public Node(String key2) {
			key = key2;
			left = right = null;
		}
	}

	// Root of BST
	Node root;

	// Constructor
	BinaryTree() {
		root = null;
	}

	void insert(String key) {
		root = insertRec(root, key);
	}

	Node insertRec(Node root, String key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key.length() < root.key.length() || (key.length() == root.key.length()))
			root.left = insertRec(root.left, key);
		else if (key.length() > root.key.length())
			root.right = insertRec(root.right, key);

		return root;
	}

	void inorder() {
		inorderRec(root);
	}

	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}

	boolean search(String key) {
		root = search_Recursive(root, key);
		if (root != null)
			return true;
		else
			return false;
	}

	Node search_Recursive(Node root, String key) {

		if (root == null) 
			return null;
		else if(root.key.equalsIgnoreCase(key))
			return root;
		else if (key.length() < root.key.length()  || root.key.length() == key.length() )
			return search_Recursive(root.left, key);
		else return search_Recursive(root.right, key);
	}
}
