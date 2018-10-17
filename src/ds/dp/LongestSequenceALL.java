package ds.dp;

public class LongestSequenceALL {

	public static void main(String[] args) {
		
		LongestSequenceALL ls = new LongestSequenceALL();
		int t =ls.longestSubsequenceDP("rajesh", "ytaeshty");
		int l = ls.longestSubsequenceRecursion("rajesh", "ytaeshty");
		System.out.println(t+" "+l);

	}
	public int longestSubsequenceDP(String str1, String str2){
		int n1 = 0;
		int n2 = 0;
		if(str1==null || str2==null || (n1=str1.length())<1 || (n2=str2.length())<1){
			return 0;
		}
		int [] [] dp = new int[n1][n2];
		int max=0;
		for(int i=0;i<n1;i++){
			for(int j=0;j<n2;j++){
				if(i==0 && j==0){
					if(str1.charAt(i)==str2.charAt(j)){
						dp[i][j]=1;
					}
				}else if(str1.charAt(i)==str2.charAt(j)){
					dp[i][j]=(i-1>=0 && j-1>=0)?1+dp[i-1][j-1]:1;
				}else if(str1.charAt(i)!=str2.charAt(j)){
					int max1 = (i-1>=0)?dp[i-1][j]:0;
					int max2 = (j-1>=0)?dp[i][j-1]:0;
					dp[i][j]=Math.max(max1, max2);
				}
				max = Math.max(dp[i][j], max);
			}
		}
		return max;
	}
	public int longestSubsequenceRecursion(String str1, String str2){
		if(str1==null || str2==null){
			return 0;
		}
		int n1 = str1.length();
		int n2 = str2.length();
		return longestSubsequenceRecursion(str1, str2, n1, n2);
		
	}
	public int longestSubsequenceRecursion(String str1, String str2,int n1, int n2){
		if(n1<=0 || n2<=0){
			return 0;
		}else{
			if(str1.charAt(n1-1)==str2.charAt(n2-1)){
				return 1+longestSubsequenceRecursion(str1, str2,n1-1,n2-1);
			}else{
				int max1 = longestSubsequenceRecursion(str1, str2, n1-1, n2);
				int max2 = longestSubsequenceRecursion(str1, str2, n1, n2-1);
				return Math.max(max1, max2);
			}
		}
	}
}
