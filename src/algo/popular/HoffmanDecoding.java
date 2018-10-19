package algo.popular;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class HoffmanDecoding implements Serializable{

	private static final long serialVersionUID = 4905753845989744706L;
	node HoffmanTree;
	HashMap<Character,String> hash;
	String encodedString="";
	String decodedString="";
	
	
	/**
	 * node class, if its a leaf node, set value of data variable
	 * @author rbajya
	 *
	 */
	public static class node implements Serializable{
		private static final long serialVersionUID = -3651124433924079511L;
		int freq;
		char data;
		node left;
		node right;
		node(int f){
			freq=f;			
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
		HashMap<Character,Integer> chash = getFrequency(str,n);
		PriorityQueue<node> pq = new PriorityQueue<>(new CompareNodes());
		Set<Entry<Character,Integer>> entry = chash.entrySet();
		
		
		//insert all the characters from string into PriorityQueue
		// initially all the nodes are root nodes
		// So we have n trees inserted in PriorityQueue
		for(Entry<Character,Integer> e: entry){
			char c = e.getKey();
			int f = e.getValue();
			node temp = new node(f);
			temp.data=c;
			pq.add(temp);
		}
		
		//make single node out of all the nodes in Queue
		while(pq.size()>1){
			node temp1 = pq.poll();
			node temp2 = pq.poll();
			node temp = new node(temp1.freq+temp2.freq);
			temp.left=temp1;
			temp.right=temp2;
			pq.add(temp);
		}
		
		HoffmanTree = pq.poll();
		node root=HoffmanTree;
		hash = new HashMap<>();
		generateSortCharacter(root,"");
		
		//generate encoded string
		for(int i=0;i<n;i++){
			encodedString+=hash.get(str.charAt(i));
		}
				
	}
	

   /**
    * utility method to get frequency of a character in a map
    * @param str
    * @param n
    * @return
    */
	public HashMap<Character, Integer> getFrequency(String str, int n) {
		HashMap<Character, Integer> charhash = new HashMap<Character, Integer>();
		
		for(int i=0;i<n;i++){
			char c = str.charAt(i);
			if(charhash.containsKey(c)){
				int t = charhash.get(c);
				charhash.put(c, t+1);
			}else{
				charhash.put(c, 1);
			}
		}
		return charhash;
	}
	
	public void inorderTraversal(node root){
		if(root==null)return;
		else{
			inorderTraversal(root.left);
			System.out.print(root.data+" ");
			inorderTraversal(root.right);
		}
	}
	
	
	/**
	 * Traverse the tree and if its a leaf node, We have a string of encoded characters for the said 
	 * character.
	 * @param root
	 * @param sb
	 */
	private void generateSortCharacter(node root, String sb) {
		if(root==null)return;
		if(root.left==null && root.right==null){
			hash.put(root.data, sb);
		}else{			
			generateSortCharacter(root.left,sb+'0');			
			generateSortCharacter(root.right,sb+'1');
			
		}	
		
	}
	
	/**
	 * Method to decode the encoded String
	 * Loop through the encoded String and set left and right tree accordingly 
	 * if its a lead node, append the character in decodedString
	 * @param str
	 * @param root
	 */
	
	public void decode(String str, node root) {
		node temp=root;
		int n = str.length();
		for(int i=0;i<n;i++){
			char ch = str.charAt(i);
			if(ch=='0'){
				temp = temp.left;
			}else{
				temp=temp.right;
			}
			
			if(temp.left==null && temp.right==null){
				decodedString+=temp.data;
				temp=root;
			}
						
		}
		
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		HoffmanDecoding hd = new HoffmanDecoding();
		hd.encode("Rajesh is a good boy");
	
		
		//Put this object in file
		File f = new File("HoffmanEncoded.txt");
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(hd);
		out.close();
		
		//read object from file
		FileInputStream fin = new FileInputStream(f);
		ObjectInputStream oin = new ObjectInputStream(fin);
		hd = (HoffmanDecoding)oin.readObject();	
		System.out.println(hd.encodedString);
		oin.close();
		
		//decode String
		hd.decode(hd.encodedString,hd.HoffmanTree);
		System.out.println(hd.decodedString);

	}

}
