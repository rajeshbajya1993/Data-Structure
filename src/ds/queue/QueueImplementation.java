package ds.queue;

public class QueueImplementation {

	private int size;
	final int [] arr;
	
	public QueueImplementation(int n){
		this.arr = new int[n];
		this.size=0;
	}
	
	public void add(int element){
		if(size==arr.length){
		   throw new RuntimeException("Queue is already full");
		}
		arr[size]=element;
		size++;
	}
	public int peek(){
		if(isEmpty()){
			 throw new RuntimeException("Queue is empty");
		}else{
			return arr[0];
		}
	}
	
	public boolean isEmpty() {
		
		return size==0;
	}
	
	public int pop(){
		if(isEmpty()){
			throw new RuntimeException("Queue is empty");
		}else{
			int l = arr[0];
			
			for( int i=1;i<size;i++){
				arr[i-1]=arr[i];
			}
			arr[size-1]=0;
			size--;
			return l;
		}
	}

	public static void main(String[] args) {
		

	}

}
