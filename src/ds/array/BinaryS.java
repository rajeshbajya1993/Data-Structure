package ds.array;

public class BinaryS {

	public static void main(String[] args) {
    
		BinaryS bs = new BinaryS();
		int [] arr = {41,49,57,113,114,217,319,3311,4416};
	  System.out.println(bs.search(arr, 4444));
		

	}
	
	public int binarySearch(int [] arr,int target){
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
		return -(low+1);
	}
	public void minInRotatedArray(int [] arr){
		int n = arr.length;
		int low = 0;
		int high = n-1;		
		
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

}
