package ds.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExamples {

	public QueueExamples() {
		
	}
	/**
	 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
	 */
	public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }
	
	 public int lengthOfLongestSubstringHashMap(String s) {
	        if (s.length()==0) return 0;
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int max=0;
	        for (int i=0, j=0; i<s.length(); ++i){
	            if (map.containsKey(s.charAt(i))){
	                j = Math.max(j,map.get(s.charAt(i))+1);
	            }
	            map.put(s.charAt(i),i);
	            max = Math.max(max,i-j+1);
	        }
	        return max;
	    }
	 public static void main(String[] args) {
		System.out.println(15%10);
	}

}
