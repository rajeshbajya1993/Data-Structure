package ds.dp;

import java.util.*;
public class Knapsack {

	public void knapsack_0_1_algo(int val[], int wt[], int weight){
		  int dp[][] = new int[val.length+1][weight+1];
		  for(int i=1;i<=val.length;i++){
			  for(int j=1;j<=weight;j++){
				  if(j-wt[i-1]>=0){
					  dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]]+val[i-1]);
				  }else{
					  dp[i][j]=dp[i-1][j];
				  }
			  }
		  }
		  for(int i=0;i<=val.length;i++){
			 for(int j=0;j<=weight;j++){
				 System.out.print(dp[i][j]+" ");
			 }
			 System.out.println();
		  }
		
	}
	public static void main(String[] args) {
		Knapsack knap = new Knapsack();
        int val[] = {1,4,5,7};
        int wt[] = {1,3,4,5};
        knap.knapsack_0_1_algo(val, wt, 7);
        
	}

}
