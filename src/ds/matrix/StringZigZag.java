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
		
		// if total is less than 2, it means there is no ZigZag, 
		// print the string itself
		if(total<2){
			System.out.println(str);
			return;
		}
		//calulate column length in matrix, max value would be n if total is 1
		// if total is not huge, n can be used as column length, as it wont impact 
		// performance much
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
  
		char [] [] mat = new char[total][col];
		int index=0;
		n = str.length();
		flag=true; 
	
		int i=0;int j=0;
		// fill the matrix
		while(index<n){
			if(flag){
				while(i<total && index<n){
					mat[i][j]=str.charAt(index);
					i++;
					index++;
				}
				// setup i,j,index,flag
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
				
			  // setup i,j,index,flag
				index--;
				i++;
				j--;
				flag = true;
				
			}
		}
		
		for(char [] arr: mat){
			for(char ch :arr){
				
					System.out.print(ch+" ");
				
			}
			System.out.println();
			
		}
		
	}
	public static void main(String[] args) {
		StringZigZag s = new StringZigZag();
		s.convertZigZag("PAYPALISHIRING", 3);
	}
}
