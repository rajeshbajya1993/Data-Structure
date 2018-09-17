package ds.linkedList;

public class LinkedList {

	node head;
	static class node{
		int val;
		node next;
		node(int value){
			this.val=value;
		}
	}
	/**
	 * Method to insert node at the end of the linkedlist
	 * @param val
	 */
	public void insertNodeAtEnd(int val){
		if(head==null){
			head = new node(val);
		}else{
			node temp = head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=new node(val);
		}
	}
	
	/**
	 * method to get middle elemene of the linked list
	 * @param h head of linked list
	 * @return middle element
	 */
	public node getMiddleNode(node h){
		if(h==null || h.next ==null)return h;
		else{
				node fast=h.next;
				node slow=h;
//			1 ->4 ->5 ->(11) ->14 ->6 ->7 ->9
			while(fast!=null && fast.next!=null){
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow;
		}
	}
	
	
	/**
	 * recursively sort the linked list in two halves 
	 * until length becomes one 
	 * @param head
	 * @return
	 */
	public node mergeSort(node head){
		if(head==null || head.next==null){
			return head;
		}else{
			node mid = getMiddleNode(head);
			node left = head;
			node right = mid.next;
			mid.next=null;
			//sort left half
			left=mergeSort(left);
			//sort right half
			right=mergeSort(right);
			//merge both half
			head=merge(left,right);
			return head;
		}
	}
	
	/**
	 * Method to merge two linked list based on node values
	 * @param left
	 * @param right
	 * @return
	 */
	private node merge(node left, node right) {
		if(left==null)return right;
		else if(right==null)return left;
		node result = null;
			
			if(left.val<=right.val){
				result = left;
				result.next=merge(left.next, right);
			}else{
				result = right;
				result.next = merge(left, right.next);
			}
		
		return result;
	}

	/**
	 * This method prints linked list starting fron begining
	 * @param head takes head of linked list
	 */
	public void printLinkedList(node head){
		if(head==null)return;
		node temp=head;
		while(temp.next!=null){
			System.out.print(temp.val+" -> ");
			temp=temp.next;
		}
		System.out.println(temp.val);
		
	}
	
//	public node reverseLinkedList(node head){
//		if(head==null || head.next==null){
//			return head;
//		}else{
//			node temp = reverseLinkedList(head.next);
//			node result=temp;
//			
//			result.next
//			
//		}
//	}
	
	
	
	public node reverseLinkedListIterative(node head){
		if(head==null || head.next==null){
			return head;
		}else{
			node prev=null;
			node curr=head;
			node nextone=null;
			while(curr!=null){
				nextone = curr.next;
				curr.next=prev;
				prev=curr;
				curr=nextone;
			}
			return prev;
		}
	}
	/**
	 * Main method to test activities on LinkedList
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list  = new LinkedList();
		list.insertNodeAtEnd(1);
		list.insertNodeAtEnd(4);
		list.insertNodeAtEnd(5);
		list.insertNodeAtEnd(11);
		list.insertNodeAtEnd(14);
		list.insertNodeAtEnd(6);
		list.insertNodeAtEnd(7);
		list.insertNodeAtEnd(9);
		list.insertNodeAtEnd(41);
        list.printLinkedList(list.mergeSort(list.head));
        list.printLinkedList(list.reverseLinkedListIterative(list.head));

	}

}
