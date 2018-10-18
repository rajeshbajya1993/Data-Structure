package algo.popular;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HoffmanDecoding {

	node HoffmanTree;
	HashMap<Character,String> hash;
	String encodedString;
	public static class node{
		int freq;
		char data;
		node left;
		node right;
		node(int f, char data){
			freq=f;
			this.data=data;
		}
	}
	
	/**
	 * This class implements Comparator<node> interface 
	 * and sorts nodes based on frequencies
	 * @author rbajya
	 *
	 */
	public class CompareNodes implements Comparator<node>{

		@Override
		public int compare(node o1, node o2) {
			return o1.freq-o2.freq;			
		}
		
	}
	public void encode(String str){
		int n = str.length();
		// get frequencies of all the characters
		int [] arr = getFrequency(str,n);
		PriorityQueue<node> pq = new PriorityQueue<>(new CompareNodes());
		
		//insert all the characters from string into PriorityQueue
		// initially all the nodes are root nodes
		// So we have n trees inserted in PriorityQueue
		for(int i=0;i<n;i++){
			char c = str.charAt(i);
			int f = arr[c];
			node temp = new node(f,c);
			pq.add(temp);
		}
		
		//make single node out of all the nodes in Queue
		while(pq.size()>1){
			node temp1 = pq.poll();
			node temp2 = pq.poll();
			node temp = new node(temp1.freq+temp2.freq,'#');
			temp.left=temp1;
			temp.right=temp2;
			pq.add(temp);
		}
		
		HoffmanTree = pq.poll();
		node root=HoffmanTree;
		hash = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		generateSortCharacter(root,sb);
		System.out.println(hash);
		
	}
	


	public int[] getFrequency(String str, int n) {
		int [] arr = new int[256];
		for(int i=0;i<n;i++){
			arr[str.charAt(i)]++;
		}
		return arr;
	}
	
	private void generateSortCharacter(node root, StringBuilder sb) {
		if(root==null)return;
		if(root.left==null && root.right==null){
			hash.put(root.data, sb.toString());
		}else{
			sb.append('0');
			generateSortCharacter(root.left,sb);
			sb.deleteCharAt(sb.length()-1);
			
			sb.append('1');
			generateSortCharacter(root.right,sb);
			sb.deleteCharAt(sb.length()-1);
		}
		
		
		
	}

	public static void main(String[] args) {
		HoffmanDecoding hd = new HoffmanDecoding();
		hd.encode("ABACA");

	}

}
