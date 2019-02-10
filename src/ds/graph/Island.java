package ds.graph;

import java.util.Random;

public class Island {

	public Island() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Island is = new Island();

		int [] [] matrix = is.randomMatrix();
		System.out.println("Total islands: "+is.findNumberOfIslands(matrix));
//		System.out.println("Max Area island: "+is.findLargetIsland(matrix));

	}
	
	private int[][] randomMatrix() {
		
		Random rand = new Random();
		//random in range [3,7]
		int upperbound=7;
		int lowerbound=3;
		int n = rand.nextInt(upperbound-lowerbound)+lowerbound; 
		int m = rand.nextInt(upperbound-lowerbound)+lowerbound;
		int [] [] matrix = new int [n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				matrix[i][j]=(rand.nextInt(5000))&1;
				//matrix[i][j]=rand.nextInt(1) can also be used
			}
		}
		printMatrix(matrix);
		return matrix;
	}
	
	private void printMatrix(int[][] matrix) {
		
		for( int [] arr: matrix){
			for(int i:arr){
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	public int findNumberOfIslands(int [] [] matrix){
		if(matrix==null)return 0;
		int n = matrix.length;
		if(n<1)return 0;
		int m = matrix[0].length;
		int result=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(matrix[i][j]==1){
					removeThisIsland(matrix,i,j,n,m);
					printMatrix(matrix);
					result++;
				}
			}
		}
		return result;
	}

	

	private void removeThisIsland(int[][] matrix, int i, int j, int n, int m) {
		if(i<0 || i>=n || j<0 || j>=m || matrix[i][j]==0)return;
		
		//remove this island
		matrix[i][j]=0;
		//remove island above
		removeThisIsland(matrix, i-1, j, n, m);
		//remove island below
		removeThisIsland(matrix, i+1, j, n, m);
		//remove island in left
		removeThisIsland(matrix, i, j-1, n, m);
		//remove island in right
		removeThisIsland(matrix, i, j+1, n, m);
		
	}
	
	public int findLargetIsland(int [] [] matrix){
		if(matrix==null) return 0;
		int n = matrix.length;
		if(n<1)return 0;
		int m = matrix[0].length;
		int max = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(matrix[i][j]==1){
					//check how many more, 1 can you see  from this 1	
					int result = findLargestAreaFromThisIsland(matrix, i,j,n,m);
					max = Math.max(max, result);
				}
			}
		}
		return max;
		
	}

	private int findLargestAreaFromThisIsland(int[][] matrix, int i, int j, int n, int m) {
		
		if(i>=0 && i<n && j<m && j>=0 && matrix[i][j]==1){
			matrix[i][j]=0;
			return 1+
					findLargestAreaFromThisIsland(matrix, i-1, j, n, m)+
					findLargestAreaFromThisIsland(matrix, i+1, j, n, m)+
					findLargestAreaFromThisIsland(matrix, i, j+1, n, m)+
					findLargestAreaFromThisIsland(matrix, i, j-1, n, m);
			       
		}
		return 0;
		
		
	}

}
