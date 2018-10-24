package ds.stack;

import java.util.Scanner;
import java.util.Stack;

public class Histogram {

	
	/**
	 * Design a Data Structure SpecialStack 
	 * that supports all the stack operations 
	 * like push(), pop(), isEmpty(), isFull()
	 *  and an additional operation getMin()
	 *   which should return minimum element 
	 *   from the SpecialStack. 
	 *   All these operations of SpecialStack must be O(1).
	 *   To implement SpecialStack, 
	 *   you should only use standard Stack data structure
	 *    and no other data structure like arrays, list, .. etc
	 * @author rbajya
	 *
	 */
    public static class specialStack{
		private Stack<Integer> actual;
		private Stack<Integer> minstack;
		private int cap;
		public specialStack(int cap){
			this.cap=cap;
			actual = new Stack<>();
			minstack = new Stack<>();
		}
		public Integer pop(){
			if(actual.isEmpty()){
				throw new RuntimeException("Stack is Empty, "
						+ "try to add some elements before removing.");
				
			}else{
				minstack.pop();
				return actual.pop();
			}
		}
		public void push(int t){
			if(cap==actual.size()){
				throw new RuntimeException("Stack is already full, "
						+ "try to remove some elements before inserting new element.");
			}
			if(actual.isEmpty()){
				actual.push(t);
				minstack.push(t);
			}else{
				actual.push(t);
				minstack.push(minstack.peek()<t?minstack.peek():t);
			}
		}
		public int getMinimum(){
			if(actual.isEmpty()){
				throw new RuntimeException("Stack is Empty, "
						+ "try to add some elements first");
			}else{
				return minstack.peek();
			}
		}
	 }
	public static void main(String[] args) {
		Histogram hs = new Histogram();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int [] arr = new int[n];
		
		for(int i=0;i<n;i++){
			int t = scan.nextInt();
			arr[i]=t;
			
		}
		
		
		scan.close();

	}
	
	/**
	 * Given an array, print the Next Greater Element (NGE) for every element.
	 * The Next greater Element for an element x 
	 * is the first greater element on the right side of x in array. 
	 * Elements for which no greater element exist, 
	 * consider next greater element as -1
	 * @param arr
	 */
	public void nextGreaterElement(int [] arr){
		int n ;
		if(arr==null || (n=arr.length)<1){
			return;
		}
		Stack<Integer> stak = new Stack<>();
		stak.add(arr[0]);
		for(int i=1;i<n;i++){
			int k = arr[i];
			if(stak.isEmpty()){
				stak.push(k);
			}else{
				while(!stak.isEmpty() && stak.peek()<k){
					int t=stak.pop();
					System.out.println(t+" --> "+k);
				}
				stak.push(k);
			}
		}
		while(!stak.isEmpty()){
			int t = stak.pop();
			System.out.println(t+" --> "+-1);
		}
	}
	

}
