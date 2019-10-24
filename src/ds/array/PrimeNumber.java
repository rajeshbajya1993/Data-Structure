package ds.array;

import java.util.HashMap;
import java.util.TreeMap;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeNumber pp = new PrimeNumber();
//		pp.generatePrimeNumbers(150,"ccc");
		System.out.println(pp.getString("abba"));
		System.out.println(pp.getWordString("dog cat cat fish"));
		
		
	}
	String getWordString(String str) {
		String result = "";
		String[] ptr = str.split(" ");
		int n = ptr.length;
		 HashMap<String,Integer> hash = new HashMap<>();
		 int j = 0;
		for(int i=0;i<n;i++) {
			if(hash.containsKey(ptr[i])) {
				result +=hash.get(ptr[i]);
			}else {
				result +=j;
            	hash.put(ptr[i], j);
            	j++;
			}
		}
		return result;
	}
	String getString(String str){
        int n = str.length();
        int  j = 0;
        String result="";
        HashMap<Character,Integer> hash = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hash.containsKey(str.charAt(i))) {
            	result +=hash.get(str.charAt(i));
            }else {
            	result +=j;
            	hash.put(str.charAt(i), j);
            	j++;
            }
        }
        return result;
    }
	
	//Sieve analysis
	public void generatePrimeNumbers(int n,String str) {
		boolean [] prime  = new boolean[n+1];
		prime[0]=true;
		prime[1]=true;
		prime[2]=false;
//		prime[3]=false;
		if(n>3) {
			for(int j=2;j<=n;j++) {
				
				for(int i=j+1;i<=n;i++) {
					if(i%j==0) {
						prime[i]=true;
					}
				}
			}
		}
		
		TreeMap<Integer,Character> tree = new TreeMap<Integer, Character>();
		
		for(int i=65;i<=122;i++) {
			if(!prime[i]) {
				tree.put(i, (char)i);				
			}
		}
		int  l = str.length();
		String result = "";
		for(int i= 0;i<l;i++) {
			int p = (int)str.charAt(i);
			if(tree.containsKey(p)) {
				result = result+p;				
			}else {
				int ceil = tree.ceilingKey(p);
				int floor = tree.floorKey(p);
				if (p-floor > ceil-p )
				{
					result+=(char)ceil;
				}else {
					result+=(char)floor;
				}
			}
		}
		System.out.println(result);
		
	}

}
