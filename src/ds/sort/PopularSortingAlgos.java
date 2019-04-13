package ds.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PopularSortingAlgos implements Sortable{

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
	@Override
	public void sort(int[] arr) {
		System.out.println("sorting using mergesort....");
		mergeSort(arr);
		
	}
	
	class ComparatorImpl implements Comparator<Integer>{
		
		

		@Override
		public int compare(Integer o1, Integer o2) {
			String s1 = o1.toString();
			String s2 = o2.toString();
			return -(s1+s2).compareTo(s2+s1);
		}
	}
	
	public void getMaximumValue(List<Integer> arr){
	    int n=0;
	    if(arr==null || (n=arr.size())==0){
	    	System.out.println("No such value");
	    }
	    System.out.println(arr);
	    Collections.sort(arr, new ComparatorImpl());
	    System.out.println(arr);
	    
	}
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer> ();
		arr.add(3);
		arr.add(33);
		arr.add(24);
		arr.add(22);
		arr.add(30);
		PopularSortingAlgos ps = new PopularSortingAlgos();
		ps.getMaximumValue(arr);
		System.out.println("a".compareTo("b"));
	}

}
