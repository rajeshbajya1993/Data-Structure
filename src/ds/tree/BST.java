package ds.tree;

import java.util.Random;

public class BST {
//	node root;
	static class node{
		int value;
		node left;
		node right;
		node(int value){
			this.value=value;
			
		}
	}
	
	public node insertNode(int value,node root){
		if(root==null){
			root = new node(value);
			
			
		}else if(root.value>value){
			root.left=insertNode(value,root.left);
		}
		else if(root.value<value){
			root.right=insertNode(value, root.right);
		}
		return root;
	}
	
	public void inorderTraversal(node root){
		if(root==null)return;
		
			inorderTraversal(root.left);
			System.out.print(root.value+" ");
			inorderTraversal(root.right);
		
	}
	
	public Boolean searchValue(int value,node root){
		if(root==null) return false;
		else if(root.value==value)return true;
		else if(root.value>value)return searchValue(value, root.left);
		else return searchValue(value, root.right);
	}

	public node deleteNodeFromBST(int value,node root){
		if(root==null) return null;
		else if(root.value>value){
			root.left=deleteNodeFromBST(value, root.left);
		}else if(root.value<value){
			root.right=deleteNodeFromBST(value, root.right);
		}else{
			if(root.left==null && root.right==null){
				root=null;
			}else if(root.left==null){
				root=root.right;
			}else if(root.right==null){
				root=root.left;
			}else{
				node temp = maxInLeftTree(root.left);
				root.value=temp.value;
				root.left=deleteNodeFromBST(temp.value, root.left);
			}
		}
		return root;
	}
	public node maxInLeftTree(node root) {
		if(root==null)return null;
		while(root.right!=null){
			root=root.right;
		}
		return root;
		
	}

	public static void main(String[] args) {
		BST bst = new BST();
		node root=null;
		Random rand = new Random();
		int [] arr = new int[10];
		for(int i=0;i<10;i++){
			 int n = rand.nextInt(100)+1;
			 arr[i]=n;
			 System.out.print(n+" ");
			root = bst.insertNode(n, root);
			
		}
		System.out.println();
		bst.inorderTraversal(root);;
		bst.deleteNodeFromBST(arr[4], root);
		System.out.println();
		bst.inorderTraversal(root);
		

          
	}

}
