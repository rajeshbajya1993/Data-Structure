package algo.popular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class HanoiTower {
	
	public void towerOfHanoi(int n, char source, char dest, char temp){
		if(n<=0)return;
		towerOfHanoi(n-1, source, temp, dest);
		System.out.println("Move disk "+n+" from "+source+" to "+dest);
		towerOfHanoi(n-1, temp, dest, source);
	}

	public static void main(String[] args) {
//		HanoiTower hn = new HanoiTower();
//		hn.towerOfHanoi(3, 'A', 'C', 'B');
//		
////		HashMap<String,String> hash;
//		ArrayList<Integer> [] out  ;
//		TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
//		
//		ts.add(12);
//		ts.add(11);
//		ts.add(1);
//		ts.add(23);
//		System.out.println(ts.first());
//		ts.remove(ts.first());
//		ts.isEmpty();
//		System.out.println(ts);
		
    int [] arr = {1, 2, 3, 1, 1};
    int [] query = {1,2,3,4,5};
//    HanoiTower.solve(query,arr);
    findMinLadders(arr);
	}
	 static void  Solve(int[] arr) {
		 ArrayList<Integer> temp = new ArrayList<>();
	        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
	        int n = arr.length;
	        int whichDisk = n;
	        // ArrayList<Integer> [] out  = new ArrayList<Integer> [n];
	        if(n<1){
	            System.out.println("");
	            return;
	        }
	        int max = n;
	        for(int i=0;i<n;i++){
	            int val = arr[i];
	            ts.add(val);
	            int req = n-i;
	            if(val>=whichDisk){
	               while(true){
	                   if(!ts.isEmpty()){
	                       int p = ts.first();
	                       if(p>=req){
	                           System.out.print(p+" ");
	                           whichDisk = p-1;
	                           ts.remove(p);
	                       }else{
	                           break;
	                       }
	                   }else{
	                       break;
	                   }
	               }
	               System.out.println();
	               
	            }else{
	               
	                System.out.println();
	            }
	        }
	    }
	 
	 
	 static void  solve(int[] query, int[] arr){
	        int n  = arr.length;
	        int [] dp = new int [n+1];
	        TreeMap<Integer,ArrayList<Integer>> tree  = new TreeMap<>(Collections.reverseOrder());

	        for(int i=1;i<=n;i++){
	                dp[i] = Integer.MAX_VALUE;      
		
	                if(tree.containsKey(i-1+arr[i-1])){
		        		ArrayList<Integer> list = tree.get(i-1+arr[i-1]);
		        		list.add(i-1);
		        		tree.put(i-1+arr[i-1], list);
		        	}else{
		        		ArrayList<Integer> list = new ArrayList<>();
		        		list.add(i-1);
		        		tree.put(i-1+arr[i-1], list);
		        	} 
	                
	                
	            	Iterator<Integer> it = tree.keySet().iterator();
	            	boolean b=true;
	            	while(it.hasNext() && b){
	            		int p = it.next();

	            		if(p<i){
	            			b=false;
	            			break;
	            		}
	            		ArrayList<Integer> tem = tree.get(p);

	            		
	            		for(int j: tem){
	            			dp[i] = Math.min(dp[j]+1, dp[i]);
	            		}
	            		
	            		
	            	}
	            	
	            	
	            	
	        }
	           
	                
	               
	       
	     
	        for( int i: query){
	            System.out.println(dp[i]);
	        }
	 }
	 
	 public static void findMinLadders(int arr[]) {
			if(arr == null || arr.length == 0) {
				return ;
			}
			int dp[] = new int[arr.length];
			dp[0] = 0;
			int idx = 0;
			boolean found = false;
			for(int i = 0 ; i < arr.length ; i++) {
				if(found) {
					break;
				}
				if(arr[i] <= 0 ) {
					continue;
				}
				int n = i+arr[i]-idx;
				while(n > 0) {
					idx++;
					if(idx == arr.length) {
						found = true;
						break;
					}
					dp[idx] = dp[i]+1;
					n--;
				}
			}
			System.out.println(Arrays.toString(dp));
		}
	 

}
