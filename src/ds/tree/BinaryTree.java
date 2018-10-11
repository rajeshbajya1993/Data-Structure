package ds.tree;

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
		if(l!=null){
			return l;
		}else{
			return r;
		}
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		node root = new node(4);
		node p=root.left=new node(11);
		node q=root.right=new node(13);
		node result = bt.getLCA(root, p, q);
		if(result!=null){
			System.out.println(result.val);
		}else{
			System.out.println("null");
		}

	}

}
