package com.ds.binartree;

public class BinaryTreeUtility {
	public static void main(String[] args){
		
		BinaryTreeNode binaryTree = new BinaryTreeNode(1);
		
		//Create Binary Tree
		//      1
		//    /   \
		//   2     3
		//  / \   / \
		// 4   5 6   7 
		
		binaryTree.setLeft(new BinaryTreeNode(2));
		binaryTree.setRight(new BinaryTreeNode(3));
		binaryTree.getLeft().setLeft(new BinaryTreeNode(4));
		binaryTree.getLeft().setRight(new BinaryTreeNode(5));
		binaryTree.getRight().setLeft(new BinaryTreeNode(6));
		binaryTree.getRight().setRight(new BinaryTreeNode(7));
		binaryTree.setParent(null);
		binaryTree.getLeft().setParent(binaryTree);
		binaryTree.getRight().setParent(binaryTree);
		binaryTree.getLeft().getLeft().setParent(binaryTree.getLeft());
		binaryTree.getLeft().getRight().setParent(binaryTree.getLeft());
		binaryTree.getRight().getLeft().setParent(binaryTree.getRight());
		binaryTree.getRight().getRight().setParent(binaryTree.getRight());
		
		TreeTraversal ttr = new TreeTraversal();
		
		//Inorder Traversal Non-Recursive:
		System.out.println("Inorder Traversal Non-Recursive:");
		ttr.inorderTraversal(binaryTree);
		
		//Inorder Traversal Recursive:
		System.out.println("\nInorder Traversal Recursive:");
		ttr.inorderTraversalRec(binaryTree);
		
		//Inorder Traversal Non-Recursive(Parent pointer):
		System.out.println("\nInorder Traversal Non-Recursive(Parent Pointer):");
		ttr.inOrderTraversalWithParent(binaryTree);
		
		//Level-order Traversal Recursive:
		System.out.println("\nLevel-order Traversal Recursive:");
		ttr.levelOrderTraversalRec(binaryTree);
		
	}
}
