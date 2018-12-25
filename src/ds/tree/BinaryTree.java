package ds.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

	static class node{
		int val;
		node left;
		node right;
		node(int val){
			this.val=val;
		}
	}
	
	public node getLCA(node root, node p, node q){
		if(root==null || root==p || root==q) return root;
		node l = getLCA(root.left, p, q);
		node r = getLCA(root.right, p, q);
		if(l != null && r != null)   return root;
//		System.out.println(root.val);
		if(l!=null){			
			return l;
		}else{
			return r;
		}
	}
	
	public int getMaxSumPathLeafToLeaf(node root){
		if(root==null)return 0;
		else {
			int l = getMaxSumPathLeafToLeaf(root.left);
			int r = getMaxSumPathLeafToLeaf(root.right);
			result = Math.max(result, l+r+root.val);
			return Math.max(l, r)+root.val;
		}
		
	}
	static int length;
	public int getMaxLeaftoLeafLength(node root){
		if(root==null)return 0;
		else{
			int l = getMaxLeaftoLeafLength(root.left);
			int r = getMaxLeaftoLeafLength(root.right);
			length = Math.max(length, l+r+1);
			return Math.max(l, r)+1;
		}
	}
	static int  result=0;
	
	
//	public void levelOrderTraversal(node root){
//		if(root==null)return;
//		List<List<Integer>> list = new LinkedList<>();
//		int level=0;
//		levelOrderTraversal(root,list,level);
//		System.out.println(list);
//	}
//	private void levelOrderTraversal(node root, List<List<Integer>> list, int level) {
//		if(root==null)return;
//		List<Integer> temp = list.get(level);
//		if(temp==null){
//			temp = new LinkedList<>();
//			temp.add(root.val);
//		}else{
//			temp.add(root.val);
//		}
//		list.add(level,temp);
//		levelOrderTraversal(root.left, list, level+1);
//		levelOrderTraversal(root.right, list, level+1);
//		
//	}

	
	/**
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 * 
	 * Input: [1,null,2,3]
	 * 
             1
              \
               2
               /
              3

       Output: [1,3,2]
       
	 *
	 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
	 * 
	 * @param root 
	 * @return
	 */
	public List<Integer> inorderTraversal(node root) {
        List<Integer> list = new LinkedList<>();
        Stack<node> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {  
                stack.push(root);
                root = root.left;  
            } else {                              
                System.out.print((stack.peek().val)+" ");
                root = stack.pop().right;
            }
        }
        return list;
    }
	public void iterativeInorderTraversal(node root){
		Stack<node> q = new Stack<>();
//		List<Integer> list = new ArrayList<>();
		node curr = root;
		while(curr!=null || !q.isEmpty()){
			while(curr!=null){
				q.push(curr);
				curr = curr.left;
			}
				 curr = q.pop();
				System.out.print(curr.val+" ");
				curr = curr.right;
//				q.push(curr);
			
		}
	}
	public void recursiveInorder(node root){
		if(root==null)return;
		recursiveInorder(root.left);
		System.out.print(root.val+" ");
		recursiveInorder(root.right);
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		node root = new node(4);
//		node p=root.left=new node(11);
		root.left=new node(11);
		root.right=new node(13);
//		int result=0;
//		node q=root.left.left = new node(32);
		root.left.left = new node(32);
		root.left.right=new node(33);
//		node result = bt.getLCA(root, p, q);

//		if(result!=null){
//			System.out.println(result.val);
//		}else{
//			System.out.println("null");
//		}
//		bt.getMaxSumPathLeafToLeaf(root);
//		bt.getMaxLeaftoLeafLength(root);
//		System.out.println(result);
//		System.out.println(length);
//		bt.levelOrderTraversal(root);
	
//		bt.iterativeInorderTraversal(root);
//		System.out.println();
//		bt.recursiveInorder(root);
//		System.out.println();
//		bt.inorderTraversal(root);

	}
	

}
