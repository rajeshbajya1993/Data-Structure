package ds.tree.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianOfRunningStream {

	PriorityQueue<Integer> oneHeap;
	List<Integer> list ;
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	
	public MedianOfRunningStream(){
		oneHeap= new PriorityQueue<>();
		list = new ArrayList<Integer>();
		 minHeap= new PriorityQueue<>();
		 maxHeap= new PriorityQueue<>(new CompImpl());
	}
	public double getMedianOneHeap(){
		int size = oneHeap.size();
		if(size<3){
			return oneHeap.peek();
		}
		list.clear();
		int index = size/2;
		for(int i=0;i<index;i++){
			list.add(oneHeap.poll());
		}
		double result ;
		if(size%2==0){
			 result = (double)(oneHeap.peek()+list.get(list.size()-1))/2;
		}else{
			result =  oneHeap.peek();
		}
		
		for(Integer i:list){
			oneHeap.add(i);
		}
		return result;
	}
	public static void main(String[] args) {
		MedianOfRunningStream mo = new MedianOfRunningStream();
		mo.oneHeap.add(13);
		mo.oneHeap.add(20);
		mo.oneHeap.add(25);
		mo.oneHeap.add(2);
		
		System.out.println(mo.getMedianOneHeap());
		mo.oneHeap.add(4);
		System.out.println(mo.getMedianOneHeap());
		
	}
	static class CompImpl implements Comparator<Integer>{
		@Override
		public int compare(Integer obj1,Integer obj2){
			return obj2-obj1;
		}
	}

}
