package ds.hashmap;


public class Computer {
	
	private Computer(ComputerBuilder cm){
		
	}
	public static class ComputerBuilder{
		public Computer build(){
			return new Computer(this);
		}
	}

}
