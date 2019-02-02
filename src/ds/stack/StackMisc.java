package ds.stack;

import java.util.Stack;

public class StackMisc {

	public static void main(String[] args) {
		StackMisc misc = new StackMisc();
//		int [] arr =  {2,4,1,9,3,4,8,1,2};
//		misc.greaterElementInRight(arr);
		Stack<Integer> stak = new Stack<>();
		stak.push(12);
		stak.push(33);
		stak.push(44);
		stak.push(13);
//		System.out.println(stak);
		misc.reverseStack(stak);
//		System.out.println(stak);

	}
	public void greaterElementInRight(int [] arr){
		int n = arr.length;
		Stack<Integer> stak = new Stack<>();
		for(int i=n-1;i>=0;i--){
			if(stak.isEmpty()){
				stak.push(arr[i]);
			}else if(stak.peek()<arr[i]){
				stak.push(arr[i]);
			}else{
				stak.push(stak.peek());
			}
		}
		
		for(int i=0;i<n;i++){
			System.out.println(arr[i]+" -> "+stak.pop());
		}
	}
	
	
	public void reverseStack(Stack<Integer>stak){
		if(stak.isEmpty())return;
		else{
			int t = stak.pop();
			reverseStack(stak);
			System.out.println(stak);
			insertAtBottom(t,stak);
		}
	}
	private void insertAtBottom(int t, Stack<Integer> stak) {
		if(stak.isEmpty()){
			stak.push(t);
		}else{
			int l = stak.pop();
			insertAtBottom(t, stak);
			stak.push(l);
		}
		
	}
	

}
