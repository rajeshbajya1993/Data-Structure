package ds.maths;

import java.util.ArrayList;
import java.util.List;

public class LeapYear {

	public LeapYear() {
	}
	public static void main(String[] args) {
		int start = 1800;
		int end=1900;
		LeapYear lp = new LeapYear();
		int count=lp.numberOfLeapYears(start, end);
		System.out.println("count: "+count);
	}
	
	public boolean checkIfAYearIsLeapYear(int year){
		if(year%4!=0){
			return false;
		}else if(year%100!=0){
			return true;
		}else if(year%400!=0){
			return false;
		}
		return true;
	}
	public int numberOfLeapYears(int start, int end){
		int count=0;
		List<Integer> list = new ArrayList<Integer>();
		while(start<=end){
			if(checkIfAYearIsLeapYear(start)){
				
				list.add(start);
				count++;
				start=start+4;
			}else{
				start++;
			}
		}
		System.out.println(list);
		return count;
	}

}
