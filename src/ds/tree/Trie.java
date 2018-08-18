package ds.tree;

public class Trie {

	TrieNode trie;
	static class TrieNode{
		TrieNode [] arr;
		TrieNode next;
		Boolean word;
		TrieNode(){
			arr = new TrieNode[26];
			next=null;
			word=false;
		}
	}
	
	public void insertNode(String str){
		TrieNode temp = trie;
		int start=0;
		for(int i=0;i<str.length();i++){
			start=i;
			if(temp.arr[str.charAt(i)-'a']!=null){
				if(i==str.length()-1){
					temp.word=true;
				}else{
					temp=temp.arr[str.charAt(i)-'a'].next;
				}
			}else{
				break;
			}
		}
		if(start==str.length()-1 && temp.word){
			return;
		}
		for(int i=start;i<str.length();i++){
			
			temp.arr[str.charAt(i)-'a']=new TrieNode();
			if(i==str.length()-1){
				temp.arr[str.charAt(i)-'a'].word=true;
			}
			temp=temp.arr[str.charAt(i)-'a'];
		}
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		t.trie = new TrieNode();
		t.insertNode("rajesh");
        t.insertNode("rajya");
	}

}
