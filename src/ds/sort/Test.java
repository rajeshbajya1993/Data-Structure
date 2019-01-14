package ds.sort;

import java.util.Arrays;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Sortable sb = new QuickSort();
		int [] arr = Sortable.prepareArray();
//		System.out.println(Arrays.toString(arr));
		sb.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
