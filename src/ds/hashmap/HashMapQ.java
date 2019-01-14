package ds.hashmap;

import java.util.HashSet;

public class HashMapQ {

	public HashMapQ() {
		
	}

	static HashSet<String> hash = new HashSet<>();
	public static void main(String[] args) {
		hash.add("I");
		hash.add("AM");
		hash.add("BATMAN");
		hash.add("BATMANS");
		hash.add("Hello,");
		hash.add("AMPY");
		HashMapQ hm = new HashMapQ();
		String word="Hello,IAMBATMANSAMPY";
		String result="";
		hm.workBreak(word,result,word.length());
		System.out.println(new Integer(12).hashCode());
		System.out.println(new Integer(12).hashCode());

	}
	public void workBreak(String word, String result, int n) {
		for(int i=1;i<=n;i++){
			String sub = word.substring(0,i);
			if(hash.contains(sub)){
				if(i==n){
					result = result+" "+sub;
					System.out.println(result);
					return;
				}
				
				workBreak(word.substring(i,n),result+" "+sub,n-i);
			}
		}
		
	}

}
