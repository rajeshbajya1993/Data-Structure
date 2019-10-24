package ds.array;

import java.util.Arrays;

public class BinaryS {

	public static void main(String[] args) {
    
		BinaryS bs = new BinaryS();
		int [] arr = {57,113,113,114,217,319,3311,4416};
//	  System.out.println(bs.demoBinarySearch(arr, 318));
//	  System.out.println(Arrays.binarySearch(arr, 318));
		bs.firstAndLastOccurance(arr, 113);
		

	}
	
	public int demoBinarySearch(int []  arr, int target){
		int n = arr.length;
		int s = 0,e=n-1;
		while(s<=e){
			int mid = s+(e-s)/2;
			if(arr[mid]==target){
				return mid;
			}
			else if(arr[mid]<target){
				s = mid+1;
			}
			else{
				e = mid-1;
			}
		}
		return -(s+1);
	}
	
	public int searchInRotatedArray(int [] arr, int target){
		int n;
		if(arr==null ||(n=arr.length)<1 ){
			return -1;
		}
		int low = 0;
		int high=n-1;
		while(low<=high){
			int mid = low+(high-low)/2;
			if(arr[mid]==target){
				return mid;
			}
			
			
			//if target falls into right half
			else if(arr[high]>=arr[mid]){
				//if highest element is less than target return -1
				if(arr[high]<target || arr[mid]>target) return -1;
				low = mid+1;
				
			}
			else if(arr[mid]>=arr[high]){
				//check left half, if it falls into left half
				if(arr[mid]>=target && arr[low]<=target){
					high = low-1;
				}else{
					low = mid+1;
				}
			}
			
			
			//if target falls into left half
//			else if(arr[mid]>=arr[low]){
//				//check if it falls into left half
//				if(arr[mid]<=target || arr[low]>=target) return -1;
//				high = mid-1;
//			}
//			else if(arr[low]>=arr[mid]){
//				if(arr[mid]>=target && arr[high]<=target){
//					low = mid+1;
//				}else{
//					high = mid-1;
//				}
//			}
			
			else{
				high = mid-1;
			}
		}
		System.out.println(low+" "+high+" ");
		return low;
	}
	
	public int binarySearch(int [] arr,int target){
		System.out.println("entring In binary search method......");
		int n = arr.length;
		int low = 0;
		int high=n-1;
		while(low<=high){
			int mid = low+(high-low)/2;
			if(arr[mid]<target){
				low=mid+1;
			}
			else if(arr[mid]>target){
				high=mid-1;
			}else{
				return mid;
			}
		}
		System.out.println("existing In binary search method......");
		return -(low+1);
	}
	public void minInRotatedArray(int [] arr){
//		int n = arr.length;
//		int low = 0;
//		int high = n-1;		
		
	}
	public int search(int[] arr, int target) 
    {
        return searchBinary(arr,0,arr.length-1,target);
    }
    public int searchBinary(int[] arr, int low, int high, int target) 
	{
		if(low>high)
		{
			return -1;
		}
		if(low==high)
		{
			if(arr[low]==target)
			{
				return low;
			}
			else return -1;
		}
		int mid=low+(high-low)/2;
		if(arr[mid]==target) return mid;
		else if(mid>low && arr[mid-1]==target)
		{
			return mid-1;
		}
		else if(mid<high && arr[mid+1]==target)
		{
			return mid+1;
		}
		else if(arr[high]>arr[mid] && (arr[high]>target || arr[mid]<target) || (arr[high]<arr[mid] && arr[high]<target || arr[mid]>target))
		{
			return searchBinary(arr, mid+1, high, target);
		}
		else
		{
			return searchBinary(arr, low, mid-1, target);
		}
		
	}
    public void firstAndLastOccurance(int [] arr, int target) {
    	int low = 0;
    	int n = arr.length;
    	int high = n-1;
    	while(low<high) {
    		int mid = low+(high-low)/2;
    		if(arr[mid]<target) {
    			low = mid+1;
    		}else {
    			high = mid;
    		}
    	}
    	System.out.print(low);
    	high = n-1;
    	while(low<high) {
    		int mid = (high+low)/2+1;
    		if(arr[mid]>target) {
    			high = mid-1;
    		}else {
    			low = mid;
    		}
    	}
    	System.out.print(""+" "+low);
    	System.out.println();
    	
    }

}
