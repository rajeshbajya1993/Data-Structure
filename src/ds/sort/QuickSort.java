package ds.sort;

public class QuickSort implements Sortable {

	public QuickSort() {
		// TODO Auto-generated constructor stub
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
	}

	private void swap(int[] arr, int k, int i) {
		int t = arr[k];
		arr[k]=arr[i];
		arr[i]=t;
		
	}

}
