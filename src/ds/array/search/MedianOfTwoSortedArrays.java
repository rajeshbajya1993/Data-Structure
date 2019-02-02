package ds.array.search;

import java.util.Arrays;


/**
 * https://www.youtube.com/watch?v=LPFhl65R7ww
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
 * @author rbajya
 *
 */
public class MedianOfTwoSortedArrays {

	public double findMedianOfTwoSortedArrays(int [] input1, int [] input2){
		int n1 = input1.length;
		int n2 = input2.length;
		if(n1>n2){
			return findMedianOfTwoSortedArrays(input2, input1);
		}
		n1 = input1.length;
		n2 = input2.length;
		int low = 0;
		int high = n1;
		while(low<=high){
			int partitionX = (low+high)/2;
			int partitionY = (n1+n2+1)/2 -partitionX;
			
			int max_left_x = partitionX==0?Integer.MIN_VALUE:input1[partitionX-1];
			int min_right_x = partitionX==n1?Integer.MAX_VALUE:input1[partitionX];
			
			int max_left_y = partitionY==0?Integer.MIN_VALUE:input2[partitionY-1];
			int min_right_y = partitionY==n2?Integer.MAX_VALUE:input2[partitionY];
			
			//base condition
			if(min_right_x >= max_left_y && max_left_x<= min_right_y){
				if((n1+n2)%2==0){
					return (double)(Math.max(max_left_x, max_left_y)+Math.min(min_right_x, min_right_y))/2;
				}else{
					return Math.max(max_left_x, max_left_y);
				}
			}else if(max_left_x>min_right_y){
				high = partitionX-1;
			}else{
				low = partitionX+1;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public double FindMedianChecker(int [] input1, int [] input2){
		int n1 = input1.length;
		int n2 = input2.length;
		int [] mergedArray = new int[n1+n2];
		int i=0,j=0,k=0;
		while(i<n1 && j<n2){
			if(input1[i]<=input2[j]){
				mergedArray[k++]=input1[i++];
			}else{
				mergedArray[k++]=input2[j++];
			}
		}
		while(i<n1){
			mergedArray[k++]=input1[i++];
		}
		while(j<n2){
			mergedArray[k++]=input2[j++];
		}
		int t1 = (n1+n2)/2; //[0,1,2,3,4,5,6,7,8]
		System.out.println(Arrays.toString(mergedArray));
		if((n1+n2)%2==0){			
			return (double)(mergedArray[t1]+mergedArray[t1-1])/2;
		}else{
			return mergedArray[t1];
		}
	}
	
	public static void main(String[] args) {
		int [] input1 = {4,9,14,17,20};
		int [] input2 = {3,5,6,8,12,23,27};

		MedianOfTwoSortedArrays ms = new MedianOfTwoSortedArrays();
		System.out.println(ms.FindMedianChecker(input1, input2));
		System.out.println(ms.findMedianOfTwoSortedArrays(input1, input2));
	}

}
