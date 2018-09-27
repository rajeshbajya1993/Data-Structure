package ds.stack;

import java.util.Stack;

public class StackMisc {

	public static void main(String[] args) {
		StackMisc misc = new StackMisc();
		int [] arr =  {2,4,1,9,3,4,8,1,2};
		misc.greaterElementInRight(arr);

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
	

}
