package ds.maths;

import java.util.Scanner;

public class ReverseInteger {

	public static int reverseInteger(int n){
		String res = "";
		boolean sign = n>=0?false:true;
		if(sign){
			
		}
		while(n!=0){
			res += n%10;
			n = n/10;
		}
//		System.out.println();
		try {
			n=Integer.parseInt(res);
			return n;
		}catch(Exception e){
			return 0;
		}
	}
	public static int saveThePresioners(int p, int s, int seq){
		s = s%p;
		if(seq+s-1>p){
			int l = -1*(p-seq-s+1);
			return l;
		}else{
			return seq+s-1;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int p = scan.nextInt();
		int s = scan.nextInt();
		int seq = scan.nextInt();
		System.out.println(ReverseInteger.saveThePresioners(p, s, seq));
		System.out.println(Integer.MAX_VALUE>556065259);

		scan.close();
	}
	
}
