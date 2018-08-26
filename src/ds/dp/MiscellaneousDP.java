package ds.dp;

public class MiscellaneousDP {

	
	
	public void fibonacciNumber(int n){
		if(n<0){
			System.out.println("invalid number");
			return;
		}
		switch(n){
		case 0:
			System.out.println(0);
			break;
		case 1:
			System.out.println(1);
			break;
		default:
			
			int a =0;
			int b=1;
			int result=1;
			for(int i=2;i<=n;i++){
				
				//f[i]=f[i-1]+f[i-2]
				result = a+b;    //f[i-1]
				a=b;           //f[i-2]
				b=result;
				
				
			}
			System.out.println(result);
			
		}
	}
	public static void main(String[] args) {

		MiscellaneousDP misc = new MiscellaneousDP();
		misc.fibonacciNumber(7);

	}

}
