package ds.linkedList;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(12);
		list.addAll(list);
		System.out.println(list);
		list.remove(new Integer(1));
		System.out.println();
		System.out.println(list);
	}

}
