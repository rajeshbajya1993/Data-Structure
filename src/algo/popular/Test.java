package algo.popular;

import java.util.Map;
import java.util.Map.Entry;

public class Test {

	public Test() {
//		BufferedReader bf  = new BufferedReader(new FileReader(""));
	}
	public static void main(String[] args) {
		
		System.setProperty("OUTPUT_PATH", "C:\\Users\\rbajya.ORADEV\\Desktop\\logs\\text1.txt");
		
		Map<String,String> map=System.getenv();
//		map.put("OUTPUT_PATH", System.getProperty("OUTPUT_PATH"));
		
		for(Entry<String,String> entry:map.entrySet()){
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
//		System.out.println(System.getProperty("OUTPUT_PATH"));
		
	}

}
