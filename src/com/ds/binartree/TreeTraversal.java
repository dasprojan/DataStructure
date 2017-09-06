package com.ds.binartree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author projand
 *
 */
public class TreeTraversal {
	
	/**
	 * @param root
	 */
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
	
	/**
	 * @param root
	 */
	public void inorderTraversalRec(BinaryTreeNode root){
		if(root == null){
			return;
		}
		inorderTraversalRec(root.getLeft());
		System.out.print(root.getKey() + " ");
		inorderTraversalRec(root.getRight());
	}
	
	/**
	 * @param root
	 */
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
	
	/**
	 * @param root
	 * @return
	 */
	public int heightOfTree(BinaryTreeNode root) {
		if(root==null)
			return 0;
		return 1+Math.max(heightOfTree(root.getLeft()), heightOfTree(root.getRight()));
	}
	
	/**
	 * @param root
	 */
	public void levelOrderTraversalRec(BinaryTreeNode root){
		if(root == null){
			return;
		}
		for(int i=1;i<=heightOfTree(root);i++) {
			levelOrderRecHelper(root,i);
		}
	}
	
	/**
	 * @param root
	 * @param level
	 */
	public void levelOrderRecHelper(BinaryTreeNode root,int level ){
		if(level==1){
			System.out.print(root.getKey() + " ");
			return;
		}
		levelOrderRecHelper(root.getLeft(), level-1);
		levelOrderRecHelper(root.getRight(), level-1);
	}
	
	/**
	 * @param root
	 */
	public void levelOrderTraversal(BinaryTreeNode root){
		ArrayList<BinaryTreeNode> queue = new ArrayList<>();
		BinaryTreeNode currentNode = root;
		if(currentNode!=null)
			queue.add(currentNode);
		else
			return;
		while(!queue.isEmpty()){
			currentNode = queue.remove(0);
			System.out.print(currentNode.getKey()+" ");
			if(currentNode.getLeft()!=null)
				queue.add(currentNode.getLeft());
			if(currentNode.getRight()!=null)
				queue.add(currentNode.getRight());
		}
	}
	
	public void revLevelOrderTraversal(BinaryTreeNode root){
		ArrayList<BinaryTreeNode> queue = new ArrayList<>();
		Stack<BinaryTreeNode> stack = new Stack<>();
		BinaryTreeNode currentNode = root;
		queue.add(currentNode);
		while(!queue.isEmpty()){
			currentNode = queue.remove(0);
			stack.push(currentNode);
			if(currentNode.getRight()!=null){
				queue.add(currentNode.getRight());
			}
			if(currentNode.getLeft()!=null){
				queue.add(currentNode.getLeft());
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getKey() + " ");
		}
	}
}
