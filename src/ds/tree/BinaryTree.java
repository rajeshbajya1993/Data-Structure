package ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {

	static class node{
		int val;
		node left;
		node right;
		node(int val){
			this.val=val;
		}
	}
	
	/**
	 * https://www.geeksforgeeks.org/?p=662
	 * @param node
	 * @return
	 */
	node mirror(node node) 
	    { 
	        if (node == null) 
	            return node; 
	  
	        /* do the subtrees */
	        node left = mirror(node.left); 
	        node right = mirror(node.right); 
	  
	        /* swap the left and right pointers */
	        node.left = right; 
	        node.right = left; 
	  
	        return node; 
	    } 
	
	/**
	 * This method assumes that both p and q are present in tree
	 * if one of them is not present, the method will return other node
	 * Ideally it should have returned null
	 * getLCAModified()handle this case
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
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
	
	public node getLCAModified(node root, node p, node q){
		
		node temp=getLCAUtil(root,p,q);
		if(flagP&flagQ){
			return temp;
		}
		return null;
	}
	boolean flagP=false;
	boolean flagQ = false;
	
	private node getLCAUtil(node root, node p, node q) {
		if(root==null)
			return null;
		node temp=null;
		if(root==p){
			flagP=true;
			temp= root;
		}
		if(root==q){
			flagQ=true;
			temp= root;
		}
		node l = getLCAUtil(root.left, p, q);
		node r = getLCAUtil(root.right, p, q);
		
		if(temp!=null){
			return temp;
		}
		if(l !=null && r!=null){		
			
			return root;
		}
		
		
		
//		if(l!=null && flagQ){
//			return l;
//		}else if(r!=null && flagP){
//			return r;
//		}else{
//			return null;
//		}
		
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
	
	/**
	 * worked on it again
	 * @param root
	 */
	public void Inordertest(node root){
		if(root==null) return;
		Stack<node> stak = new Stack<>();
//		stak.push(root);
		node current = root;
		while(current!=null || !stak.isEmpty()){
			while(current!=null){
				stak.push(current);
				current = current.left;
			}
			System.out.print(stak.peek().val+" ");
			current = stak.pop().right;
		}
		
	}
	
	public void PreOrdertest(node root){
		if(root==null){
			return;
		}
		Stack<node> stak = new Stack<>();
		node current = root;
		while(current!=null || !stak.isEmpty()){
			if(current!=null){
				stak.push(current);
				System.out.print(current.val+" ");
				current = current.left;
			}
			else{
				current = stak.pop().right;
				
			}
//			System.out.print(stak.peek().val+" ");
//			current = stak.pop().right;
		}
	}
	
	public void levelOrder(node root){
		List<Integer> list = new ArrayList<>();
		levelOrderUtil(root,0,list);
		System.out.println(list);
	}
	private void levelOrderUtil(node root, int i, List<Integer> list) {

		if(root==null)return;
		if(i==list.size()){
			list.add(root.val);
		}
		levelOrderUtil(root.left, i+1, list);
		levelOrderUtil(root.right, i+1, list);
		
	}
	
	public int lengthOfLongestSubstring(String s) {
		
        int n ;
//        System.out.println(s.length());
        if(s==null || (n=s.length())==0) return 0;
        if(n==1)return 1;
        HashMap<Character,Integer> hash = new HashMap<>();
        int max=0;
        System.out.println("n is"+n);
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(hash.containsKey(ch)){
                int prev = hash.get(ch);
                max = Math.max(max,i-prev);
                
            }
            hash.put(ch,i);
        }
        if(hash.isEmpty()){
        	System.out.println("came here");
        	return n;
        }
        return max;
    }
	
	/**
	 * Size of a tree is, number of nodes in it
	 * @param root
	 * @return
	 */
	public int sizeofTree(node root){
		if(root==null)return 0;
		else{
			int left = sizeofTree(root.left);
			int right = sizeofTree(root.right);
			return left+right+1;
		}
	}
   /**
    * Find level of a give node
    * root is at level 0
    * @param root
    * @return
    */
	public int levelOfNode(node root,node target){
//		if(root==null)return 0;
		return levelOfNode(root,target,0);
	}
	
	private int levelOfNode(node root, node target, int level) {
	if(root==null)return 0;
	else{
		if(root.val==target.val){
			return level;
		}
		int left = levelOfNode(root.left, target, level+1);
		if(left==0){
			return levelOfNode(root.right, target, level+1);
		}
		return left;
	}
	
}
	/**
	 * https://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/
	 * @param root
	 */
	public void printPaths(node root){
		node [] paths = new node[100];
		printPaths(root,paths,0,0);
	}

	private void printPaths(node root, node[] paths, int len, int rootToLeafSum) {
		if(root==null){
			return;
		} 
		
		paths[len]=root;
		rootToLeafSum+=root.val;
		len++;
		
		if(root.left==null && root.right==null){
			System.out.print("[ Total root to leaf sum for this path: "+rootToLeafSum+"] ");
			printArrayUtil(paths,len);
			
		}else{
			printPaths(root.left,paths,len,rootToLeafSum);
			printPaths(root.right,paths,len,rootToLeafSum);
		}
		
	}

	private void printArrayUtil(node[] paths, int len) {
		for(int i=0;i<len;i++){
			System.out.print(paths[i].val+" ");
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		
		PriorityQueue<Integer>pq;
		BinaryTree bt = new BinaryTree();
		
		node root = new node(4);
		root.left=new node(11);
		root.right=new node(13);
		root.right.right=new node(45);
		node p=root.right.right.right=new node(567);
		node q=root.left.right=new node(33);
		root.left.left = new node(67);
		root.left.right = new node(20);

//		node result=bt.getLCA(root, p, q);
//	    if(result!=null){
//	    	System.out.println(result.val);
//	    }
//	    else{
//	    	System.out.println("null");
//	    }
//	    result = bt.getLCAModified(root, p, q);
//	    if(result!=null){
//	    	System.out.println(result.val);
//	    }
//	    else{
//	    	System.out.println("null");
//	    }
		
		bt.printTopView(root);
	}
	
	static class Pair{
		int level;
		node nod;
		Pair(int level, node n){
			this.level=level;
			nod=n;
		}
	}
	public void printTopView(node root){
		TreeMap<Integer,Pair> map = new TreeMap<>();
		int level=0;
		int hd=0; //horizontal distance
		printTopViewUtil(root,level,hd,map);
		
		for(Entry<Integer,Pair> entry: map.entrySet()){
			Pair p = entry.getValue();
			System.out.print(p.nod.val+" ");
		}
		System.out.println();
	}

	private void printTopViewUtil(node root, int level, int hd, TreeMap<Integer, Pair> map) {
		if(root==null)return;
		if(map.containsKey(hd)){
			Pair p = map.get(hd);
			if(p.level>level){
				map.put(hd, new Pair(level,root));
			}
		}else{
			map.put(hd, new Pair(level,root));
		}
		printTopViewUtil(root.left, level+1, hd-1, map);
		printTopViewUtil(root.right, level+1, hd+1, map);
		
	}
	

}
