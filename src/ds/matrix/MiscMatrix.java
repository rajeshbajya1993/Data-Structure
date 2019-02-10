package ds.matrix;

import java.util.Random;

public class MiscMatrix {

	public MiscMatrix() {
		
	}
	public static void main(String[] args) {
		MiscMatrix mm = new MiscMatrix();
		mm.printSpiral(mm.generateMatrix());
		
	}
	
	public int [] [] generateMatrix(){
		Random rand = new Random();
		//random in range [3,7]
		int upperbound=7;
		int lowerbound=3;
		int n = rand.nextInt(upperbound-lowerbound)+lowerbound; 
		int m = rand.nextInt(upperbound-lowerbound)+lowerbound;
		int [] [] matrix = new int [n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
//				matrix[i][j]=((rand.nextInt(5000))&40)| 10; //values from [10,50]
				matrix[i][j]=rand.nextInt(40)+10;
				//matrix[i][j]=rand.nextInt(1) can also be used
			}
		}
		printMatrix(matrix);
		return matrix;
	}
	
      void printMatrix(int[][] matrix) {
		
		for( int [] arr: matrix){
			for(int i:arr){
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

      public void printSpiral(int [] [] matrix){
    	  int n = matrix.length;
    	  int m = matrix[0].length;
    	  int x1=0,x2=n-1,y1=0,y2=m-1;
//    	  int i=0;
//    	  int j=0;
    	  int count=0;
    	  boolean flag=true;
    	  while(flag){
    		  flag=false;
    		  /**
    		   * >>>>>>>
    		   * -------
    		   * -------
    		   * -------
    		   */
    		  for(int i=y1;i<=y2;i++){
    			  System.out.print(matrix[x1][i]+" ");
    			  count++;
    			  flag=true;
    		  }
    		  x1++;
    		  
    		  /**
    		   * -------^
    		   * -------^
    		   * -------^
    		   * -------^
    		   */
    		  for(int i=x1;i<=x2;i++){
    			  System.out.print(matrix[i][y2]+" ");
    			  flag=true;
    			  count++;
    		  }
    		  y2--;
    		  
    		  /**
    		   * -------
    		   * -------
    		   * -------
    		   * <<<<<<<
    		   */
    		  for(int i=y2;i>=y1;i--){
    			  System.out.print(matrix[x2][i]+" ");
    			  flag=true;
    			  count++;
    		  }
    		  x2--;
    		  
    		  /**
    		   * ^-------
    		   * ^-------
    		   * ^-------
    		   * ^-------
    		   */
    		  for(int i=x2;i>=x1;i--){
    			  System.out.print(matrix[i][y1]+" ");
    			  flag=true;
    			  count++;
    		  }
    		  y1++;
    		  
    	  }
    	  System.out.println();
    	  System.out.println("count is :"+count);
    	  
      }
}
