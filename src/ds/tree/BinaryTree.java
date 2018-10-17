package ds.tree;

import java.util.LinkedList;
import java.util.List;

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
		search :
		for(int i=0;i<10;i++){
			for(int j=0;j<6;j++){
				if(i*j==8){
					break search;
				}
				System.out.printf("value of i= %d and j= %d %n",i,j);
			}
		}

	}

}
