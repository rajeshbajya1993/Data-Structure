package ds.dp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class MatrixDP {

	public static void main(String[] args) throws IOException {
//		FileOutputStream fout = new FileOutputStream("input.txt");
//		fout.write(12);
//		System.out.println(new File("input.txt").getAbsolutePath());
//		File directory = new File("C:\\eclipse\\workspace\\Data Structure");
//		File.createTempFile("input", ".txt",directory);
//		FileInputStream fin = new FileInputStream("input.txt");
//		System.out.println(new File("input.txt").getAbsolutePath());
//		int n ;
//		while((n=fin.read())!=-1){
//			System.out.print((char)n);
//		}
//		File file = new 
		FileInputStream fin = new FileInputStream("input.txt");
		
		
		Scanner scan = new Scanner(System.in);
		int  row = scan.nextInt();
		int column = scan.nextInt();
		char [] [] matrix = new char[row][column];
//		for(int i=0;i<row;i++){
//			for(int j=0;j<column;j++){
//				int l = scan.nextInt();
//				matrix[i][j]=l;
//			}
//		}
		
		MatrixDP mx = new MatrixDP();		
		for(int i=0;i<row;i++){
			String str = scan.next();
			matrix[i]=str.toCharArray();
		}
		mx.printAllPath(matrix);
		
       scan.close();
	}
	/**
	 * Maximum size square sub-matrix with all 1s
	 * @param matrix
	 * @return
	 */
	public int LargestSquare(int [] [] matrix){
		int row = matrix.length;
		int column = matrix[0].length;
		int [] [] dp = new int[row][column];
		int max=0;
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				if(i==0 || j==0){
					dp[i][j]=matrix[i][j];
				}else if(matrix[i][j]==1){
					dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
//		for(int [] arr: matrix){
//			System.out.println(Arrays.toString(arr));
//		}
//		System.out.println();
//		for(int [] arr: dp){
//			System.out.println(Arrays.toString(arr));
//		}
		return max;
		
	}
	
	public void printAllPath(char [] [] matrix){
		int row = matrix.length;
		int column = matrix[0].length;
//		char [] arr = new char[row+column-1];
		printPath(matrix,row,column,0,0,"");
	}
	private void printPath(char[][] matrix, int row, int column, int i, int j, String result) {
		if(i==row-1){
			for(int k=j;k<column;k++){
				result+=matrix[i][k];
			}
			System.out.println(result);
			return;
		}
		if(j==column-1){
			for(int k=i;k<row;k++){
				result+=matrix[k][j];
			}
			System.out.println(result);
			return;
		}
			
				result+=matrix[i][j];
				printPath(matrix, row, column, i+1, j, result);			
				printPath(matrix, row, column, i, j+1, result);
			
	
		
	}

}
