package algo.popular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

	Map<Character,String> hash ;
	
	public PhoneNumber(){
		hash= new HashMap<>();
		hash.put('2', "abc");
		hash.put('3', "def");
		hash.put('4', "ghi");
		hash.put('5', "jkl");
		hash.put('6', "mno");
		hash.put('7', "pqrs");
		hash.put('8', "tuv");
		hash.put('9', "wxyz");
	}
	
	public void generateAllString(String number){
		int n=0;
		if(number==null || (n=number.length())==0){
			return;
		}
		StringBuilder result= new StringBuilder();
		
		List<String>list = new ArrayList<>();
		helper(list,0,number,result,n);
		System.out.println(list);
	}

	private void helper(List<String> list, int i, String number, StringBuilder result, int n) {
		
		if(result.length()==n){
			List<String> li = new ArrayList<>();
//			li.add(result.toString());
			list.add(result.toString());
			return;
		}
		if(i<n){
//			System.out.println(i +" is "+n);
			String temp = hash.get(number.charAt(i));
			int templength=temp.length();
			for(int j=0;j<templength;j++){
				result.append(temp.charAt(j));
				helper(list, i+1, number, result, n);
				result.deleteCharAt(result.length()-1);
			}
		}
		
		
	}
	public static void main(String[] args) {
		PhoneNumber pn = new PhoneNumber();
		pn.generateAllString("2346");
	}
}
