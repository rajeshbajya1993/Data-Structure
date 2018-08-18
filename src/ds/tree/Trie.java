
/*
*  Trie data structure implimentation using char array
*
*/






package ds.tree;

public class Trie {

	TrieNode trie;
	static class TrieNode{
		TrieNode [] arr;
		
		Boolean word;
		TrieNode(){
			arr = new TrieNode[26];
		
			word=false;
		}
	}
	
	public void insertNode(String str){
		TrieNode temp = trie;
		int n=str.length();
		
		for(int i=0;i<n;i++){
			int index = str.charAt(i)-'a';
			if(temp.arr[index]==null){
				temp.arr[index]=new TrieNode();
			}
			temp=temp.arr[index];
		}
		temp.word=true;
	}
	public boolean search(String str){
		TrieNode temp = trie;
		int n=str.length();
		
		for(int i=0;i<n;i++){
			int index = str.charAt(i)-'a';
			if(temp.arr[index]==null){
				return false;
			}
			temp = temp.arr[index];
		}
		return (temp!=null && temp.word);
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		t.trie = new TrieNode();
		t.insertNode("rajesh");
        t.insertNode("rajya");
        System.out.println(t.search("rajesh"));
        System.out.println(t.search("rajt"));
	}

}
