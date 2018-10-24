package algo.popular;

import java.util.Arrays;

public class NextElements {

	static int count=0;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		try{
			while (true) {
				sb.append('a');
				count++;
//				System.out.println(count);
			}
		}catch(Exception e){
			System.out.println(count);
		}
	}
		
	
	/**
	 * Given a number n, find the smallest number that has same set of digits as n and is greater than n.
	 *  If x is the greatest possible number with its set of digits, then print “not possible”
	 *  
	 *  
	 *  https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
	 *  
	 *  Following is the algorithm for finding the next greater number.
	 *  
     * I) Traverse the given number from rightmost digit, keep traversing till you find a digit 
     * which is smaller than the previously traversed digit. For example, if the input number is “534976”,
     *  we stop at 4 because 4 is smaller than next digit 9. If we do not find such a digit, 
     *  then output is “Not Possible”.
     *
     * II) Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’.
     *  For “534976″, the right side of 4 contains “976”. The smallest digit greater than 4 is 6.
     *
     * III) Swap the above found two digits, we get 536974 in above example.
     *
     * IV) Now sort all digits from position next to ‘d’ to the end of number. 
     * The number that we get after sorting is the output. For above example, 
     * we sort digits in bold 536974. We get “536479” which is the next greater number for input 534976.
     * @param arr
	 */
    public void getNextGreateElementUsingSameDigits(int [] arr){
        int n = arr.length;
        if(n<2)return;
        int i=0;
        for(i=n-1;i-1>=0;i--){
            if(arr[i]>arr[i-1]){
                break;
            }
        }
        if(i==0){
            System.out.println("not possible");
            return;
        }
        i = i-1; 
        int min = arr[i];
        int current = arr[i+1];
                 
         int k=i+1;
          for(int j=i+2;j<n;j++){
                if(arr[j]>min && arr[j]<current){
                         k=j;
                     }
          }  
          int t =arr[i];
          arr[i]=arr[k];
          arr[k]=t;
          Arrays.sort(arr, i+1, n);
          System.out.println(Arrays.toString(arr));
    }

}
