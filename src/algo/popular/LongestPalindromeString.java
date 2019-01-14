package algo.popular;

public class LongestPalindromeString {



public static String longestPlaindrome(String str){
	int n;
	if(str==null || (n=str.length())<2 ){
		return str;
	}
	String result="";
//	System.out.println(result.length());
	
	// for odd strings
	for(int i=0;i<n;i++){
		
		int j=i;
		int k = i;
//		boolean found=false;
		while(j>=0 && k<n){
			if(str.charAt(j)==str.charAt(k)){
				j--;
				k++;
//				found=true;
			}else{
				break;
			}
		}
//		System.out.println(i+" "+k);
//		int l = j<0 ? 0:j;
//		int m = k>n-1?n:k;
		String st=  str.substring(j+1, k);
		if(k-j-1>result.length()){
			result = st;
		}
		
	}
	// for even strings
	
	for(int i=0;i<n;i++){
		int j = i;
		int k = i+1;
		while(j>=0 && k<n){
			if(str.charAt(j)==str.charAt(k)){
				k++;
				j--;
			}else{
				break;
			}
		}
//		int l = j<0?0:j;
//		int m = k>n-1?n:k;
		
			String st=  str.substring(j+1, k);
			if(k-j-1>result.length()){
				result = st;
			}
//			System.out.println(result);
		
	}
	
	
	
	return result;
}
 public static void main(String[] args) {
//	System.out.println("abde".substring(k, 3));
	String pt = LongestPalindromeString.longestPlaindrome("ac");
	System.out.println(Integer.MAX_VALUE+2);
	System.out.println(pt);
}


}