package ds.tree.heap;

import java.util.Arrays;

public class MaxHeap {
	static MaxHeap heap;
	int size;
	int capacity;
	int [] arr;
	public MaxHeap(int cap){
		capacity=cap;
		size=0;
		arr = new int[capacity];
	}
	public int parent(int i){
		return (i-1)/2;
	}
	public int left(int i){
		return (2*i+1);
	}
	public int right(int i){
		return (2*i+2);
	}

	
	public void insert(int value){
		if(heap.capacity==heap.size){
			System.out.println("heap full........");
			return;
		}
		heap.size=heap.size+1;
		int i = heap.size-1;
		heap.arr[i]=value;
		while(i>0 && heap.arr[parent(i)]<heap.arr[i]){
			int p = heap.arr[parent(i)];
			heap.arr[parent(i)] = heap.arr[i];
			heap.arr[i]=p;
			i=parent(i);
		}
	}

	public void heapify(int i, int n, int [] arr){
		int max=i;
		int l = left(i);
		int r = right(i);
		if(l<heap.size && heap.arr[l]>heap.arr[max]){
			max=l;
		}
		if(r<heap.size && heap.arr[r]>heap.arr[max]){
			max=r;
		}
		if(max!=i){
			int p = heap.arr[max];
			heap.arr[max]=heap.arr[i];
			heap.arr[i]=p;
			i=max;
			heapify(i, n, arr);
			
		}
	}
	
	public int extractMax(){
		if(heap.size==0){
			return Integer.MIN_VALUE;
		}else if(heap.size==1){
			heap.size=0;
			return heap.arr[0];
		}else{
			int root = heap.arr[0];
			heap.arr[0]=heap.arr[heap.size-1];
			heap.size=heap.size-1;
			heapify(0, heap.size, heap.arr);
			return root;
		}
	}
	
	/**
	 * This method increases the value for a key
	 * It assumes that new value is greater than or equal to current value
	 * @param key
	 * @param value
	 */
	public void increaseKey(int i, int value){
		if(i<0 || i>heap.size-1){
			System.out.println("key doesnt exist.......");
		}else{
			heap.arr[i]=value;
			
			while(i>0 && heap.arr[parent(i)]<heap.arr[i]){
				int p = heap.arr[parent(i)];
				heap.arr[parent(i)] = heap.arr[i];
				heap.arr[i]=p;
				i=parent(i);
			}
			
		}
	}
	
	public void deleteKey(int i){
		//first increase key to INT_MAX_VALUE
		increaseKey(i, Integer.MAX_VALUE);
		
		//extract max value
		extractMax();
	}
	public static void main(String[] args) {
	
//		MaxHeap heap = new MaxHeap(10);
		 MaxHeap.heap = new MaxHeap(10);
		 heap.insert(12);
		 heap.insert(14);
		 heap.insert(112);
		 heap.insert(12);		 
		 heap.insert(1);
		 heap.insert(23);
		 heap.insert(56);		 
		 heap.insert(9);
		 heap.insert(2);		 
		 heap.insert(15);
		 System.out.println(Arrays.toString(heap.arr));
		 heap.extractMax();
		 System.out.println(Arrays.toString(heap.arr));
		 
		 
		
		
	}

}
