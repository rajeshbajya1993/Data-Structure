package ds.array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GenericArray  {

	class specialSorting implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			String s1=o1.toString();
			String s2=o2.toString();
			return (Integer.parseInt(s1+s2)-Integer.parseInt(s2+s1))*-1;
			
		}
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		GenericArray gc = new GenericArray();
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++){
			int k = scan.nextInt();
			list.add(k);
		}
		System.out.println(list);
		gc.sort1(n,list);
	}

	private void sort1(int n, List<Integer> list) {
		
		list.sort(new specialSorting());
		System.out.println(list);
	}

	

}
