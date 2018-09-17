package ds.sort;

import java.util.Arrays;
import java.util.Scanner;

public class PopularSortingAlgos {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int [] arr = new int[n];
		for(int i=0;i<n;i++){
			int k = scan.nextInt();
			arr[i]=k;
		}
		PopularSortingAlgos ps = new PopularSortingAlgos();
		ps.mergeSort(arr);
		scan.close();

	}
	public void mergeSort(int [] arr){
		int n = arr.length;
		int l=0;
		int r = n-1;
		mergeSort(arr,l,r);
		System.out.println(Arrays.toString(arr));
	}
	private void mergeSort(int[] arr, int l, int r) {
		if(r>l){
			int m = (l+r)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			mergeSortedArray(arr,l,m,r);
		}
		
	}
	private void mergeSortedArray(int[] arr, int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		int [] left = new int [n1];
		int [] right = new int[n2];
		for(int i=0;i<n1;i++){
			left[i]=arr[l+i];
		}
		for(int i=0;i<n2;i++){
			right[i]=arr[m+1+i];
		}
		int i=0;int j=0;int k=l;
		while(i<n1 && j<n2){
			if(left[i]<=right[j]){
				arr[k++]=left[i++];
			}else{
				arr[k++]=right[j++];
			}
		}
		
		while(i<n1){
			arr[k++]=left[i++];
		}
		while(j<n2){
			arr[k++]=right[j++];
		}
		
	}

}
