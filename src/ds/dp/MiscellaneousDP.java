package ds.dp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MiscellaneousDP {

	
	static class node{
		int cost;
		int length;
		node(int c, int l){
			cost=c;
			length=l;
		}
	}
	
	class CompareRodes implements Comparator<node>{
		
		@Override
		public int compare(node o1, node o2){
			return o1.cost-o2.cost;
		}
	}
	
	public void fibonacciNumber(int n){
		if(n<0){
			System.out.println("invalid number");
			return;
		}
		switch(n){
		case 0:
			System.out.println(0);
			break;
		case 1:
			System.out.println(1);
			break;
		default:
			
			int a =0;
			int b=1;
			int result=1;
			for(int i=2;i<=n;i++){
				
				//f[i]=f[i-1]+f[i-2]
				result = a+b;    //f[i-1]
				a=b;           //f[i-2]
				b=result;
				
				
			}
			System.out.println(result);
			
		}
	}
	public static void main(String[] args) {

		MiscellaneousDP misc = new MiscellaneousDP();
//		misc.fibonacciNumber(7);
//		misc.longestValidparenthesis("()()(()))((())");
//		misc.getLongestSubstringWithoutDuplicates("zefaebcdefa");
		int [] arr = {-1, -20, -3};
		misc.largestSumWithNoAdjacentElements(arr);
		System.out.println(misc.largestSumWithNoAdjacentElements1(arr, arr.length));

	}
	
	
	
	public void longestValidparenthesis(String str){
		int n = str.length();
		int [] dp = new int[n];
		int max=0;
		
		for(int i=0;i<n;i++){
			if(str.charAt(i)==')'){
				if(i-1>=0 && str.charAt(i-1)=='('){
					dp[i]=i-2>=0?dp[i-2]+2:2;
					
				}else{
					int subLength = dp[i-1];
					int index = i-subLength-1;
					if(index>=0 && str.charAt(index)=='('){

						dp[i]=index-1>=0?subLength+2+dp[index-1]:subLength+2;
						
					}
				}
			}
		
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
		
		
	
	}
	public int getLongestSubstringWithoutDuplicates(String str){
		int n;
		if(str==null){
			return 0;
		}else if((n=str.length())<2){
			return n;
		}else{
			//zefabcdefa j=3,i=9
			int max=0;
			HashMap<Character,Integer> hash = new HashMap<>();
			for(int i=0,j=0;i<n;i++){
				char ch = str.charAt(i);
				if(hash.containsKey(ch)){
					j=Math.max(j, hash.get(ch)+1);
					max=Math.max(max, i-j+1);
				}else{
					max = Math.max(max, i-j+1);
				}
				 hash.put(ch,i);
			}
//			System.out.println(max);
			return max;
		}
		
	}

	
	/**
	 * Dont even have to use node,
	 * just put frequencies in Queue
	 * @param lrode
	 * @param lcost
	 */
	public void ConnectNropesWithMinimumCost(int [] lrode, int [] lcost){
		
		PriorityQueue<node> pq = new PriorityQueue<>(new CompareRodes());
		int n = lrode.length;
		for(int i=0;i<n;i++){
			node temp = new node(lcost[i],lrode[i]);
			pq.add(temp);
		}
		while(pq.size()>1){
			node p1 = pq.poll();
			node p2 = pq.poll();
			node temp = new node(p1.cost+p2.cost,p1.length+p2.length);
			pq.add(temp);
		}
		node root = pq.poll();
		System.out.println(root.length+" "+root.cost);
		
	}
	
	
	
	/**
	 * Given an array of positive numbers, 
	 * find the maximum sum of a subsequence with the constraint that no 2 numbers in the 
	 * sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 
	 * 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
	 * 
	 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
	 * @param arr
	 */
	public void largestSumWithNoAdjacentElements(int [] arr){
		int n = arr.length;
		if(n<1) return;
		int [] dp = new int[n];
		dp[0]=arr[0];
		dp[1]=Math.max(dp[0], arr[1]);
		int max=Integer.MIN_VALUE;
		for(int i=2;i<n;i++){
			dp[i]=Math.max(dp[i-2]+arr[i], dp[i-1]);
			//if 
//			dp[i]=Math.max(dp[i-2]+arr[i], Math.max(dp[i-1],arr[i]));
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
	
	public int largestSumWithNoAdjacentElements1(int arr[], int n) 
	    { 
	        int incl = arr[0]; 
	        int excl = 0; 
	        int excl_new; 
	        int i; 
	  
	        for (i = 1; i < n; i++) 
	        { 
	            /* current max excluding i */
	            excl_new = (incl > excl) ? incl : excl; 
	  
	            /* current max including i */
	            incl = excl + arr[i]; 
	            excl = excl_new; 
	        } 
	  
	        /* return max of incl and excl */
	        return ((incl > excl) ? incl : excl); 
	    } 
	
	
}
