package algo.popular;

public class HanoiTower {
	
	public void towerOfHanoi(int n, char source, char dest, char temp){
		if(n<=0)return;
		towerOfHanoi(n-1, source, temp, dest);
		System.out.println("Move disk "+n+" from "+source+" to "+dest);
		towerOfHanoi(n-1, temp, dest, source);
	}

	public static void main(String[] args) {
		HanoiTower hn = new HanoiTower();
		hn.towerOfHanoi(3, 'A', 'C', 'B');

	}

}
