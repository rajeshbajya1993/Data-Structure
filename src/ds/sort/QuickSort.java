package ds.sort;

import java.util.Arrays;

public class QuickSort implements Sortable {

	public QuickSort() {
	}

	@Override
	public void sort(int[] arr) {		
		System.out.println("sorting using quick sort....");
		quickSort(arr,0,arr.length-1);
	}
	private void quickSort(int [] arr, int low, int high){
		if(low>=high)return;
		int pi = partition(arr,low,high);
		quickSort(arr, low, pi-1);
		quickSort(arr, pi+1, high);
	}

	private int partition(int[] arr, int low, int high) {
		
		// if you choose high as pivot
		int pivot  = arr[high];
		int k = low-1;
		for(int i=low;i<=high-1;i++){
			if(arr[i]<=pivot){
				k++;
				swap(arr,k,i);
			}
		}
		swap(arr,k+1,high);
		
		 return k+1;
		 
		 
	// if you choose low as pivot
		 
//		int pivot  = arr[low];
//		int k = high+1;
//		for(int i=high;i>low;i--){
//			if(arr[i]>=pivot){
//				k--;
//				swap(arr,k,i);
//			}
//		}
//		swap(arr,k-1,low);
//		
//		 return k-1;
		 
		 
		 
		 
		 
		 
		 
		 
	}

	private void swap(int[] arr, int k, int i) {
		int t = arr[k];
		arr[k]=arr[i];
		arr[i]=t;
		
	}
	
	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int [] arr = {2,5,7,88,3,54,34};
		q.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
