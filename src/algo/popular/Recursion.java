package algo.popular;

import java.util.HashSet;

public class Recursion {

	public void parenthesisGenerator(int n){
		if(n<1){
			System.out.println("invalid number");
			return;
		}
		
		char [] result = new char[2*n];
		int open=0;
		int close=0;
		parenthesisGenerator(result,open,close,n,0);
		
	}
	private void parenthesisGenerator(char[] result, int open, int close, int n,int index) {
		if(index==2*n){
			System.out.println(result);
		}else{
			if(close<open){
				result[index]=')';
				parenthesisGenerator(result, open, close+1, n, index+1);
			}
			if(open<n){
				result[index]='(';
				parenthesisGenerator(result, open+1, close, n, index+1);
			}
		}
		
	}
	public static void main(String... args) {

		   Recursion rc = new Recursion();
//		   int [] coins = {5,1,2,7};
//		   int k = 9;
//		   rc.minimumCoins(coins, k);
		   rc.generateString(4);
		
		}
	
	public void minimumCoins(int [] coins, int k){
		int n = coins.length;
		int i=n-1;
		int total = minimumCoins(coins,  n,  k,  i);
		System.out.println(total);
	}
	private int minimumCoins(int[] coins, int n, int k, int i) {
		if(i<0 || i>n-1){
			return Integer.MAX_VALUE/2;
		}else if(k<0){
			return Integer.MAX_VALUE/2;
		}else if(k==0){
			return 0;
		}
		int a = 1+minimumCoins(coins, n, k-coins[i], i);
		int b = minimumCoins(coins, n, k, i-1);
		return Math.min(a, b);
	}
	
	
	
	/**
	 * Given a positive integer N, 
	 * count all possible distinct binary strings of length N such that there are no consecutive 1’s
	 * 
	 *  This problem can be solved using Dynamic Programming. 
	 *  Let a[i] be the number of binary strings of length i which do not contain any two consecutive 1’s 
	 *  and which end in 0. Similarly, let b[i] be the number of such strings which end in 1.
	 *  We can append either 0 or 1 to a string ending in 0, but we can only append 0 to a string ending in 1. 
	 *  This yields the recurrence relation:

                   a[i] = a[i - 1] + b[i - 1]
                   b[i] = a[i - 1] 
	 * The base cases of above recurrence are a[1] = b[1] = 1.
	 * The total number of strings of length i is just a[i] + b[i]. 
	 *  
	 *  
	 * @param n length of the String
	 */
	public void generateString(int n){
		
		if(n<1){
			return;
		}else{
			int i=0;			
			char [] arr = new char[n];
			generateString(arr,n,i);
		}
	}
	private void generateString(char[] arr, int n, int i) {
		if(i==n){
			System.out.println(arr);
			return;
		}
		else{			
	
			//base case, put 0 or 1 at index 0
			if(i==0){
				arr[i]='0';
				generateString(arr, n, i+1);
				
				arr[i]='1';
				generateString(arr, n, i+1);
			}else{
				// if previous char is 0, put 1 or 0
				// if previous char is 1, put 0
				if(arr[i-1]=='0'){
					arr[i]='0';
					generateString(arr, n, i+1);
					
					arr[i]='1';
					generateString(arr, n, i+1);
				}else if(arr[i-1]=='1'){
					arr[i]='0';
					generateString(arr, n, i+1);
				}
			}
		}
		
	}
	
	
	void wordBreakUtil(String str, int n, String result, HashSet<String> dictionary)
	{
	    //Process all prefixes one by one
	    for (int i=1; i<=n; i++)
	    {
	        //extract substring from 0 to i in prefix
	        String prefix = str.substring(0, i);
	 
	        // if dictionary conatins this prefix, then
	        // we check for remaining string. Otherwise
	        // we ignore this prefix (there is no else for
	        // this if) and try next
	        if (dictionary.contains((prefix)))
	        {
	            // if no more elements are there, print it
	            if (i == n)
	            {
	                // add this element to previous prefix
	                result += prefix;
	                System.out.println(result); //print result
	                return;
	            }
	            wordBreakUtil(str.substring(i, n-i), n-i,
	                                result + prefix + " ", dictionary);
	        }
	    }      //end for
	}


}
