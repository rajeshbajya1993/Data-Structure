package ds.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		CoinChange cn = new CoinChange();
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		int n = scan.nextInt();
		int [] coins = new int[n];
		for(int i=0;i<n;i++){
			int k = scan.nextInt();
			coins[i]=k;
		}
		cn.coinChange(coins, value);
		scan.close();

	}
	public void coinChange(int [] coins, int value){
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> sublist = new ArrayList<>();
		coinChangeHelper(list,sublist,coins,value,coins.length,0);
		System.out.println(list);
	}
	 void coinChangeHelper(List<List<Integer>> list, List<Integer> sublist, int[] coins, int value, int k,int start) {
		
		 if(value<0){
			 return ;
		 }
		 
		 if(value==0){
			list.add(new ArrayList<>(sublist));
			return;
		}else{
			for(int i=start;i<k;i++){
				sublist.add(coins[i]);
				coinChangeHelper(list, sublist, coins, value-coins[i], k,start);
				sublist.remove(sublist.size()-1);
			}
		}
		
	}

}
