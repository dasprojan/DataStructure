package com.ds.binartree;

import java.util.Stack;

public class TreeTraversal {
	
	public void inorderTraversal(BinaryTreeNode root){
		Stack<BinaryTreeNode> stk = new Stack<>();
		BinaryTreeNode currentNode = root;
		while(!stk.isEmpty() || currentNode!=null){
			while(currentNode!=null){
				stk.push(currentNode);
				currentNode = currentNode.getLeft();
			}
			BinaryTreeNode poppedNode = stk.pop();
			System.out.print(poppedNode.getKey()+" ");
			currentNode = poppedNode.getRight();
		}
	}
	
	public void inorderTraversalRec(BinaryTreeNode root){
		if(root == null){
			return;
		}
		inorderTraversalRec(root.getLeft());
		System.out.print(root.getKey() + " ");
		inorderTraversalRec(root.getRight());
	}
	
	public void inOrderTraversalWithParent(BinaryTreeNode root) {
		BinaryTreeNode currentNode = root;
		boolean leftDone = false;
		while(currentNode!=null) {
			if(!leftDone){
				while(currentNode.getLeft()!=null){
					currentNode = currentNode.getLeft();
				}
			}
			leftDone = true;
			System.out.print(currentNode.getKey()+ " ");
			if(currentNode.getRight()!=null){
				currentNode = currentNode.getRight();
				leftDone = false;
			}
			else if(currentNode.getParent()!=null){
				
				while(currentNode.getParent()!=null && currentNode == currentNode.getParent().getRight()){
					currentNode = currentNode.getParent();
				}
				if(currentNode.getParent()==null){
					break;
				}
				currentNode = currentNode.getParent();
			}
			else
				break;
		}
	}
	
	public int heightOfTree(BinaryTreeNode root) {
		if(root==null)
			return 0;
		return 1+Math.max(heightOfTree(root.getLeft()), heightOfTree(root.getRight()));
	}
	
	public void levelOrderTraversalRec(BinaryTreeNode root){
		if(root == null){
			return;
		}
		System.out.println("\nHeight : "+heightOfTree(root));
		for(int i=1;i<=heightOfTree(root);i++) {
			levelOrderRecHelper(root,i);
		}
	}
	
	public void levelOrderRecHelper(BinaryTreeNode root,int level ){
		if(level==1){
			System.out.print(root.getKey() + " ");
			return;
		}
		levelOrderRecHelper(root.getLeft(), level-1);
		levelOrderRecHelper(root.getRight(), level-1);
	}
}
