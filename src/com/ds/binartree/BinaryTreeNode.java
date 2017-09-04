package com.ds.binartree;

public class BinaryTreeNode {
	private int key;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	private BinaryTreeNode parent;
	
	public BinaryTreeNode() {
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	public BinaryTreeNode(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public BinaryTreeNode getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}
}
