package ds.tree.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedArrays {

	public MergeKSortedArrays() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] arr = new int[n][];
		for(int i=0;i<n;i++){
			int l = scan.nextInt();
			int [] p = new int[l];
			for(int j=0;j<l;j++){
				int t = scan.nextInt();
				p[j]=t;
			}
			Arrays.sort(p);
			arr[i]=p;
		}
		

		scan.close();
	}
	public List<Integer> mergeKSortedArrays(int [] [] arr, int n){
		List<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		//add minimum elemenet from every array
		for(int [] p: arr){
			pq.add(p[0]);
			p[0]=1;
		}
		while(!pq.isEmpty()){
			int minimum_in_pq = pq.poll();
			Integer t = getNext(arr, minimum_in_pq);
			if(t!=null){
				pq.add(t);
			}
			list.add(minimum_in_pq);
		}
		return list;
		
	}
	private Integer getNext(int[][] arr, int minimum_in_pq) {
		for(int [] p: arr){
			int index = p[0];
			if(p[0]<p.length){
				
			}
		}
		return null;
	}

}
