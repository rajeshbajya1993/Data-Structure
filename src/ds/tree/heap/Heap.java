/*
 * minHeap data structure implementation
 * 
 * A heap is min heap if at any node, value of parent node is less than value of child node and all level are 
 * completely filled only except the last level,which is filled from left to right.
 * 
 * 
 * 
 *                      6
 *            10                8
 *            
 *         12    45           9    11       
 * 
 *     13     15
 * 
 *  
 * MaxHeap is opposite of minHeap. In max heap,value of parent node is greater than child node.
 * 
 * Here min heap is implemented using Array data structure.
 */

package ds.tree.heap;

import java.util.Arrays;

public class Heap {
	static Heap heap;
	int size;
	int capacity;
	int [] arr;
	
	
	public Heap(int capacity) {
		this.capacity=capacity;
		this.size=0;
		arr = new int[capacity];
	}
	public int parent(int i) {
		return (i-1)/2;
	}
	public int left(int i) {
		return (2*i+1);
	}
	public int right(int i) {
		return (2*i+2);
	}
	
	/*
	 * key is initially inserted at last index(heap_size-1),and then compared with parent
	 * to check if it needs to be swapped
	 *  
	 */
	public void insertKey(int value) {
		if(heap.size==heap.capacity) {
			System.out.println("heap is already full");
			return;
		}
		
		heap.size=heap.size+1;
		heap.arr[heap.size-1]=value;
		int i=heap.size-1;
		while(i>0 && heap.arr[i]<heap.arr[parent(i)]) {
			int p = heap.arr[i];
			heap.arr[i] = heap.arr[parent(i)];
			heap.arr[parent(i)]=p;
			i=parent(i);
		}
		
	}
	/*
	 * This method heapify the tree on key i
	 * min of left child or right child is swapped with parent and called recursively till 
	 * every node satisfy heap property 
	 */
	public void heapify(int i) {
		int smallest = i;
		int l = left(i);
		int r = right(i);
		if(l<heap.size && heap.arr[i]>heap.arr[l]) {
			smallest=l;
		}
		if(r<heap.size && heap.arr[smallest]>heap.arr[r]) {
			smallest=r;
		}
		
		if(smallest!=i) {
			int p = heap.arr[smallest];
			heap.arr[smallest]=heap.arr[i];
			heap.arr[i]=p;
			heapify(smallest);
		}
	}
	
	/*
	 * It removes minimum element from heap, which is obviously zeroth element
	 */

	public int extractMin() {
		if(heap.size==0) {
			return Integer.MAX_VALUE;
		}else if(heap.size==1) {
			heap.size--;
			return heap.arr[0];
		}else {
			int root = arr[0];
			heap.arr[0]=heap.arr[heap.size-1];
			heap.size--;
			heapify(0);
			return root;
		}
	}
	
	/*
	 * decrease the key and check if it needs to be swapped with parents.
	 */
	public void decreaseKey(int i,int value) {
		heap.arr[i]=value;
		while(i!=0 && heap.arr[i]<heap.arr[parent(i)]) {
			int p = heap.arr[i];
			heap.arr[i]=heap.arr[parent(i)];
			heap.arr[parent(i)]=p;
			i=parent(i);
		}
	}
	
	/*
	 * first decrease the key to Integer.MIN_VALUE and then extract min value
	 */
	public void deleteKey(int i) {
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
  
  	public int getMin() { return heap.arr[0]; }
  
  /*
  *  heap sort, O(nlon(n)) time complexity , O(n) space comlexity 
  */
  public  static void heapSort(int [] arr) {
		int n = arr.length;
		heap = new Heap(n);
	System.out.println(Arrays.toString(arr));
	for(int i=0;i<n;i++) {
		heap.insertKey(arr[i]);		 //building heap		
	}
		
	for(int i=0;i<n;i++) {
		arr[i]=heap.extractMin();
	}
	System.out.println(Arrays.toString(arr));
	
	}
	public static void main(String[] args) {
		
		heap = new Heap(11);
		heap.insertKey(3);
	    heap.insertKey(2);
	    heap.deleteKey(1);
	    heap.insertKey(15);
	    heap.insertKey(5);
	    heap.insertKey(4);
	    heap.insertKey(45);
	    System.out.println(heap.extractMin());
	    System.out.println(heap.getMin());
	    heap.decreaseKey(2, 1);
	    System.out.println(heap.getMin());

	}

}
