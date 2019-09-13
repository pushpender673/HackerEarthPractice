package practice.list;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeImpl {

	public static void main(String[] args) {

		BST<Integer> bst = new BST<>();
		bst.addEle(bst.root, new BSTNode<>(10));
		bst.addEle(bst.root, new BSTNode<>(6));
		bst.addEle(bst.root, new BSTNode<>(4));
		bst.addEle(bst.root, new BSTNode<>(8));
		bst.addEle(bst.root, new BSTNode<>(9));
		bst.addEle(bst.root, new BSTNode<>(2));
		bst.addEle(bst.root, new BSTNode<>(1));
		bst.addEle(bst.root, new BSTNode<>(15));
		bst.addEle(bst.root, new BSTNode<>(11));
		bst.addEle(bst.root, new BSTNode<>(16));
		bst.addEle(bst.root, new BSTNode<>(18));
		bst.addEle(bst.root, new BSTNode<>(17));
		bst.addEle(bst.root, new BSTNode<>(14));
		bst.addEle(bst.root, new BSTNode<>(3));

		bst.preOrderTraversal(bst.root);
		System.out.println();
		bst.inOrderTraversal(bst.root);
		System.out.println();

		// System.out.println(bst.findMax(bst.find(bst.root, 15)));

		System.out.println("Height of Tree : " + bst.height(bst.root));
	}

}

class BST<T extends Comparable<T>> {
	BSTNode<T> root;

	BSTNode<T> findMin(BSTNode<T> root) {
		if (root.left == null)
			return root;

		return findMin(root.left);
	}

	void printSpiral(BSTNode<T> root) {

		Deque<BSTNode<T>> lr_st = new LinkedList<>();
		Deque<BSTNode<T>> rl_st = new LinkedList<>();
		lr_st.add(root);

		while (!lr_st.isEmpty() || rl_st.isEmpty()) {

		}

	}

	BSTNode<T> findMax(BSTNode<T> root) {
		if (root.right == null)
			return root;

		return findMax(root.right);
	}

	BSTNode<T> delete(BSTNode<T> root, T el) {

		if (root == null)
			return root;

		if (root.data.compareTo(el) > 0)
			root.left = delete(root.left, el);
		else if (root.data.compareTo(el) < 0)
			root.right = delete(root.right, el);
		else {

			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.data = findMax(root.left).data;

			root.left = delete(root.left, root.data);
		}

		return root;

	}

	int height(BSTNode<T> root) {

		if (root == null)
			return 0;

		return 1 + Math.max(height(root.left), height(root.right));
	}

	BSTNode<T> addEle(BSTNode<T> root, BSTNode<T> ele) {
		if (root == null) {

			if (this.root == null)
				this.root = ele;

			return ele;
		}

		if (ele.data.compareTo(root.data) < 0)
			root.left = addEle(root.left, ele);
		else
			root.right = addEle(root.right, ele);

		return root;
	}

	void preOrderTraversal(BSTNode<T> root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

	void inOrderTraversal(BSTNode<T> root) {

		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);

	}

	BSTNode<T> find(BSTNode<T> root, T el) {

		if (root == null)
			return root;

		if (el.compareTo(root.data) == 0)
			return root;
		else if (el.compareTo(root.data) < 0)
			return find(root.left, el);
		else
			return find(root.right, el);
	}

}

class BSTNode<T extends Comparable<T>> {
	T data;
	BSTNode<T> left, right;

	public BSTNode(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "[data=" + data + "]";
	}

}
