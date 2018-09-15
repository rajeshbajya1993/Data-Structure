package ds.array;

import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class GenericArray  {

	class specialSorting implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			String s1=o1.toString();
			String s2=o2.toString();
			
			//multiplied by -1 to sort list in descending order
			// or return Integer.parseInt(s2+s1)-Integer.parseInt(s1+s2)
			return (Integer.parseInt(s1+s2)-Integer.parseInt(s2+s1))*-1;
			
		}
		
	}
	class Node{
		int diff,val;
		Node(int diff, int val){
			this.diff=diff;
			this.val=val;
		}
		
	}
	class SortArrayBasedOnAbsoluteDiff implements Comparator<Node>{

	

		@Override
		public int compare(Node o1, Node o2) {
			
				return o1.diff-o2.diff;
			
		}
		
	}
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		GenericArray gc = new GenericArray();
		int [] arr = new int [n];
//		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++){
			int k = scan.nextInt();
			arr[i]=k;
		}
		int x = scan.nextInt();
//		System.out.println(list);
//		gc.sort1(n,list);
		
//		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		 gc.getDateRangeUtil(df.parse("2018-08-19"), "");
//		 Calendar cal = Calendar.getInstance();
//	        cal.setTime(df.parse("2018-08-19"));
//	        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
//		java.sql.Date db = ;
//		 System.out.println("hello rajesh");
		
		gc.sortBasedOnAbs(arr,x);

	}

	private void sortBasedOnAbs(int[] arr, int x) {
		int n = arr.length;
		Node [] nodeArr = new Node[n];
		int j=0;
		for(int i:arr){
			nodeArr[j]=new Node(Math.abs(i-x), i);
			j++;
		}
		j=0;
		Arrays.sort(nodeArr, new SortArrayBasedOnAbsoluteDiff());
		for(Node node:nodeArr){
			arr[j]=node.val;
			j++;
		}
		System.out.println(Arrays.toString(arr));
		
	}

	public void sort1(int n, List<Integer> list) {
		
		list.sort(new specialSorting());
		System.out.println(list);
	}

	public List<String> getDateRangeUtil(Date date,String view) {

		
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        String startDate = "";
        String endDate = "";
        List<String> list = new ArrayList<String>();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        

        if("month".equals(view)){
            
            int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            cal.add(Calendar.DAY_OF_MONTH,-((weekOfMonth - 1) * 7 + (dayOfWeek-1)));
            startDate = df.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 34);
            endDate = df.format(cal.getTime());

        
           
        }
        else if("week".equals(view)){
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            cal.add(Calendar.DAY_OF_MONTH,-(dayOfWeek-1));
            startDate = df.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 6);     
            endDate = df.format(cal.getTime());
            
            
        }else if("list".equals(view)){
            startDate = df.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 13);     
            endDate = df.format(cal.getTime());
        }
        else {
            //day view 
        	// get data for two days instead
            startDate = df.format(cal.getTime());
            cal.add(Calendar.HOUR_OF_DAY, 24);  
            endDate = df.format(cal.getTime());
        }
      

        list.add(startDate);
        list.add(endDate);
       
        return list;
    }
 

}
