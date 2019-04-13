package ds.matrix;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * @author rbajya
 *
 */
public class StringZigZag {

	/**
	 */
	public void convertZigZag(String str, int total){
		int col=0;
		int n = str.length();
		boolean flag=true;
		
		while(true){
			if(flag){
				if(n-total <=0){
					col++;
					break;
				}else{
					col++;
					n = n-total;
					flag=false;
				}
			}else{
				if(n-(total-2)<=0){
					col = col+n;
					break;
				}else{
					col = col +total-2;
					n = n-total+2;
					flag=true;
				}
			}
		}
//		System.out.println(col);
		char [] [] mat = new char[total][col];
		int index=0;
		n = str.length();
		flag=true;
		boolean flag1=true;
		int i=0;int j=0;
		while(index<n){
			if(flag){
				while(i<total && index<n){
					mat[i][j]=str.charAt(index);
					i++;
					index++;
				}
				i = total-2;
				j++;
				flag=false;
			}else{
				while(j<col && i>=0 && index<n){
					mat[i][j]=str.charAt(index);
					i = i-1;
					j++;
					index++;
				}
				index--;
				i++;
				j--;
				flag = true;
				
			}
		}
		String result="";
		for(char [] arr: mat){
			for(char ch :arr){
				if((int)ch !=0){
					result=result+ch;
				}
			}
			
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		StringZigZag s = new StringZigZag();
		s.convertZigZag("AB", 1);
	}
}
