package algo.popular;

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
		   int [] coins = {5,1,2,7};
		   int k = 9;
		   rc.minimumCoins(coins, k);
		
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

}
