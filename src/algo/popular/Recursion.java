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
	public static void main(String[] args) {
		Recursion rs = new Recursion();
		rs.parenthesisGenerator(0);

	}

}
