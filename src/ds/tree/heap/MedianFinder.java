package ds.tree.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> high;
    PriorityQueue<Integer> lo;
//    private double currentMedian;
    public MedianFinder(){
    	high = new PriorityQueue<>(new ComparatorImpl());
    	lo = new PriorityQueue<>();
    	list= new ArrayList<>();
    }
    public void addNum(int num) {
    
    	list.add(num);
    	lo.offer(num);
        high.offer(lo.poll());
        
        if (lo.size() < high.size()){
            lo.offer(high.poll());
        }
       
    }
    
//    private void resize() {
//		int size1=maxHeap.size();
//		int size2=minHeap.size();
//       if(Math.abs(size1-size2)>1){
//    	   if(size1>size2){
//    		   minHeap.offer(maxHeap.poll());
//    	   }else{
//    		   maxHeap.offer(minHeap.poll());
//    	   }
//       }
//       updateCurrentMedian();
//		
//	}
//	private void updateCurrentMedian() {
//		if(maxHeap.size()==minHeap.size()){
//			currentMedian = (double)(minHeap.peek()+maxHeap.peek())/2;
//			System.out.println("it came gere"+currentMedian+minHeap.peek()+maxHeap.peek());
//		}else{
//			if(maxHeap.size()>minHeap.size()){
//				currentMedian= (double)maxHeap.peek();
//			}else{
//				currentMedian= (double)minHeap.peek();
//			}
//		}
//		
//	}
	public double findMedian() {
		if (lo.size() > high.size()){
	        return (double) lo.peek();
	    } else {
	        return (lo.peek() + high.peek()) * 0.5;
	    }
    }
     static class ComparatorImpl implements Comparator<Integer>{
    	
    	@Override
    	public int compare(Integer obj1,Integer obj2){
    		return obj2-obj1;
    	}
    	
    }
     public static void main(String[] args) {
		MedianFinder mm = new MedianFinder();
		mm.addNum(-1);
		mm.addNum(-2);
//		mm.addNum(-3);
//		mm.addNum(2);
//		mm.addNum(234);
		System.out.println(mm.findMedian());
		System.out.println(mm.findMedianList());
	}
     
     public double findMedianList(){
    	 Collections.sort(list);
    	 if(list.size()%2!=0){
    		 return list.get(list.size()/2);
    	 }else{
    		 return (list.get(list.size()/2)+list.get((list.size()/2)-1))*0.5;
    	 }
     }
   List<Integer> list;
}
