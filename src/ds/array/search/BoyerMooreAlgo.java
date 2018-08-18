package ds.array.search;

import java.util.ArrayList;
import java.util.List;

/*
* Boyer Moore Algorithm – Bad Character Heuristic
*/
public class BoyerMooreAlgo{

	public static void designBoyerMoore(String text, String pattern) {
		int n  = text.length();
		int m = pattern.length();
		int i=m-1;
		int j=m-1;
		List<Integer> list = new ArrayList<>();
		while(i<n && j<m) {
			if(text.charAt(i)==pattern.charAt(j)) {
				if(j==0) {
					list.add(i);
					j=m-1;
					i=i+m+j;
				}else {
					i--;j--;
				}
			}else {
				int l=find(text.charAt(i),pattern,n,m);   //Hashmap can be used to find character in constant time
				i=i+m-Math.min(j, 1+l);
				j=m-1;
			}
		}
		System.out.println(list);
	}

	private static int find(char ch, String pattern, int n, int m) {
		for(int i=m-1;i>=0;i--) {
			if(pattern.charAt(i)==ch) {
				return i;
			}
		}
		return Integer.MAX_VALUE-1;
	}
  
  public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);

//		int n = scan.nextInt();
//		int [] arr = new int[n];
//		for(int i=0;i<n;i++) {
//			int p = scan.nextInt();
//			arr[i]=p;
//		}
//		int k = scan.nextInt();
//		findMinMonth(arr,k);
		String pattern = "tern";
//		String str = scan.nextLine();
		String text = "does this text match the pattern, oh yeah it does match the pattern at two indices";  
		designBoyerMoore(text, pattern);
		
//		scan.close();
	}
  
  }