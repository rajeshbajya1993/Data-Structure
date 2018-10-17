package ds.dp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
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
		
		
		Scanner scan = new Scanner(fin);
		int  row = scan.nextInt();
		int column = scan.nextInt();
		int [] [] matrix = new int[row][column];
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				int l = scan.nextInt();
				matrix[i][j]=l;
			}
		}
		MatrixDP mx = new MatrixDP();
		System.out.println(mx.LargestSquare(matrix));

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

}
