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
		static node copyOf(node root){
//			int value = root.value;
			node temp = new node(root.value);
			return temp;
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
	public node constructGreaterSumTree(node root){
		if(root==null)return null;
		else{
			root.right=constructGreaterSumTree(root.right);
			sum=sum+root.value;
			root.value=sum-root.value;
			root.left=constructGreaterSumTree(root.left);
			
		}
		return root;
	}
  int sum=0;
  
  public node constructMinSumTree(node root){
	  if(root==null){
		  return null;
	  }
	  root.left=constructMinSumTree(root.left);
	  sum=sum+root.value;
	  root.value=sum-root.value;
	  root.right=constructMinSumTree(root.right);
	  return root;
  }
  node LinkedList;
  public void constructSortedLinkedListFromBST(node root){
	  if(root==null){
		  return ;
	  }
	  else{
		  constructSortedLinkedListFromBST(root.right);
//		  LinkedList.r
	  }
  }
	public static void main(String[] args) {
		BST bst = new BST();
		node root=null;
//		node linkedList=null;
		Random rand = new Random();
		int [] arr = new int[10];
		for(int i=0;i<4;i++){
			 int n = rand.nextInt(100)+1;
			 arr[i]=n;
//			 System.out.print(n+" ");
			root = bst.insertNode(n, root);
			
		}
//		System.out.println();
//		bst.inorderTraversal(root);;
//		bst.deleteNodeFromBST(arr[4], root);
//		System.out.println();
//		bst.inorderTraversal(root);
//		root=bst.constructMinSumTree(root);
		
//		System.out.println();
		bst.inorderTraversal(root);
		System.out.println();
		bst.reverseInorder(root);
        
          
	}
	int count=0;
	public void reverseInorder(node root){
		if(root==null || count>=2)return;
		reverseInorder(root.right);
		count++;
		if(count==2){
			System.out.println(root.value+" ");
			return;
		}
//		System.out.print(root.value+" ");
		reverseInorder(root.left);
	}
	

}
