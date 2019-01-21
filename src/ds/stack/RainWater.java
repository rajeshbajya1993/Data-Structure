package ds.stack;

import java.util.Stack;

public class RainWater {
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	
	
	public int trappingRainWater(Point [] arr){
		if(arr==null)return Integer.MIN_VALUE;
		int area = 0;
		int n;
		if((n=arr.length)<2)return 0;
		Stack<Point> stack = new Stack<>();
		
		// It is given that points are already sorted on value X
		for(int i=0;i<n;i++){
			int element = arr[i].y;
			
			//push if stack is empty, below two if conditions can be merged
			if(stack.isEmpty()){
				stack.push(arr[i]);
			}
			
			// push current element if its lower than stack top
			else if(stack.peek().y>element){
				stack.push(arr[i]);
			}else{
				Point p=null;
				while(!stack.isEmpty() && stack.peek().y<element){
					p = stack.pop();
				}
				// if stack has become empty, calculate area with last popped 
				// element
				if(stack.isEmpty()){
					area = area+Math.min(arr[i].y,p.y)*Math.abs((arr[i].x-p.x));					
				}
				//if stack.top.y == current.y, calculate area and pop stack top 
				else if(stack.peek().y==arr[i].y){
					Point t=stack.pop();
					area +=arr[i].y*Math.abs((arr[i].x-t.x));					

				}
				//push current element
				stack.push(arr[i]);
			}
		}
		
		

		//case where points were in descending order[stack is not empty]
		while(!stack.isEmpty()){
			// if stack has elements 6, 4, 2
			// area will be [6,4] [4,2]
			Point p = stack.pop();
			if(stack.isEmpty()) return area;
			else{				
				Point t = stack.peek();
				area += Math.min(p.y,t.y)*Math.abs((p.x-t.x));
				}
		}
		return area;
	}

	public RainWater() {
		
	}
  public static void main(String[] args) {
	RainWater rw = new RainWater();
	Point p1 = new Point(2, 4);
	Point p2 = new Point(4, 2);
	Point p3 = new Point(6, 4);
	Point p4 = new Point(9, 1);
	Point p5 = new Point(14, 11);
	Point p6 = new Point(21, 8);
	Point p7 = new Point(22,7);
	Point p8 = new Point(25,11);
	Point [] arr = {p1,p2,p3,p4,p5,p6,p7,p8};
	System.out.println(rw.trappingRainWater(arr));
}
}
