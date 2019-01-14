/**
 * 
 * How is this HashSet producing sorted output?
 * 
 * The following code produces the out put [1,2]even though hashset is not sorted.

 *Set set = new HashSet();
 *set.add(new Integer(2));
 *set.add(new Integer(1));
 *System.out.println(set);
 * 
 * This behaviour is caused by several separate reasons:

Integers hash to themselves
in Java, HashMaps and HashSets are backed up by an array
they also modify hashes using the higher bits to modify the lower bits; if the hash is in range 0..15, it's therefore not modified
what bucket an object goes depends on the lower bits of the modified hash
when iterating over a map or a set, the inner table is scanned sequentially
So if you add several small (<16) integers to a hashmap/hashset, this is what happens:

integer i has hashcode i
since it's less than 16, it's modified hash is also i
it lands in the bucket no. i
when iterating, the buckets are visited sequentially, so if all you stored there are small integers, they will be retrieved in ascending order
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */










package ds.maths;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class RandomNumber {

	private HashSet<String> hash;
	private Iterator<String> itr;
	public RandomNumber(int max) {
		init(max);
	}
	public RandomNumber(){
		init(5);
	}
	

	private void init(int max) {
		hash = new HashSet<>();
//		
		for(int i=1;i<=max;i++){
			hash.add(new Integer(max+1-i).toString());
		}
		itr = hash.iterator();
		
//		System.out.println(hash);
		
	}
	public static void main(String[] args) {
		RandomNumber rn = new RandomNumber();
//		for(int i=0;i<12;i++){
//			System.out.println(rn.giveMeARandomNumber());
//		}
		Random rm = new Random();
		System.out.println(rm.nextInt());

	}
	public int giveMeARandomNumber(){
		if(itr.hasNext()){
			return Integer.parseInt(itr.next());
		}else{
			System.out.println("Ran out of numbers, restarting from first element");
//			System.out.println(new Integer(10).hashCode());
			itr = hash.iterator();
			return giveMeARandomNumber();
		}
	}

}
