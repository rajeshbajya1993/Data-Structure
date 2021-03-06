package ds.lru;

import java.util.HashMap;

public class LRUCache {

	HashMap<Integer,node> hash;
	node start;
	node end;
	int capacity;
	
	public LRUCache(int cap){
		hash = new HashMap<>();
		capacity=cap;
		start = new node(0, 0);
		end = new node(0,0);
		start.next=end;
		end.prev=start;
	}
	static class node{
		int key;
		int value;
		node next;
		node prev;
		node(int key,int value){
			this.key=key;
			this.value=value;
		}
	}
	public void remove(node temp){
		temp.prev.next=temp.next;
		temp.next.prev=temp.prev;
		
	}
	/**
	 * Insert element at the starting of the LinkedList
	 * Keys cannot be duplicate
	 * For duplicate keys, code needs to be changed slightly
	 * @param key
	 * @param value
	 */
	public void insert(int key,int value){
		
		
		if(hash.size()==capacity){			
			hash.remove(end.prev.value);
			remove(end.prev);	
		}
			node temp = new node(key,value);
			temp.next=start.next;
			temp.prev=start;
			start.next.prev=temp;
			start.next=temp;
			hash.put(key, temp);
		
	}
	/**
	 * If key is present, remove the key-node and insert a new node 
	 * at the starting with same key-value as deleted key-node
	 * @param key
	 * @return
	 */
	public int get(int key){
		if(!hash.containsKey(key)){
			System.out.println("no such element...");
			return Integer.MAX_VALUE;
		}
		node temp = hash.get(key);
		int val=temp.value;
		hash.remove(key);
		remove(temp);
		insert(key, val);
		return val;
	}
	public void printLinkedList(){
		node temp = start.next;
		while(temp!=null && temp.next!=end){
			System.out.print(temp.key+" -> ");
			temp=temp.next;
		}
		System.out.println(temp.key);
	}
	public static void main(String[] args) {
		   LRUCache lru = new LRUCache(4);
           lru.insert(2, 111);
           lru.insert(12, 4445);
           lru.insert(21, 879);
           lru.insert(53, 900);
//           lru.insert(29, 602);
//           lru.insert(6, 1602);
//           lru.insert(43, 4785);
//           lru.insert(7, 800);
//           lru.insert(03, 908);
//           lru.insert(56, 872);
//           lru.insert(05, 160);

           lru.printLinkedList();
           lru.get(2);
           lru.printLinkedList();
           lru.insert(22, 78877);
           lru.printLinkedList();
	}

}
