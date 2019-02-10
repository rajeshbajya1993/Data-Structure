package algo.popular;

import java.util.HashSet;

public class PopularRecursionQuestions {

	public PopularRecursionQuestions() {
		// TODO Auto-generated constructor stub
	}
	
	public String findWordBreak(String word,HashSet<String> dictionary){
		String result="";
		
		int n = word.length();
		findWordBreakUtil(word, dictionary,result,n);
		
		
		return result;
	}

	private void findWordBreakUtil(String word, HashSet<String> dictionary, String result, int n) {
		
		for(int i=1;i<=n;i++){
			String prefix = word.substring(0,i);
			if(dictionary.contains(prefix)){
				if(i==n){
					result = result+" "+prefix;
					System.out.println(result);
					return;
				}
				findWordBreakUtil(word.substring(i,n), dictionary, result+" "+prefix, n-i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		HashSet<String> dictionary = new HashSet<>();
		dictionary.add("I");
		dictionary.add("Am");
		dictionary.add("Rajeshs");
		dictionary.add("Rajesh");
		dictionary.add("Bajya");
		String word = "IAmRajeshsBajya";
		PopularRecursionQuestions pr = new PopularRecursionQuestions();
		System.out.println(pr.findWordBreak(word, dictionary));
	}

}
