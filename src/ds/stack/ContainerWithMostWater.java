package ds.stack;

public class ContainerWithMostWater {

	public ContainerWithMostWater() {
		
	}
	public static void main(String[] args) {
		ContainerWithMostWater cc = new ContainerWithMostWater();
		int [] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(cc.maxArea(height));
	}
	public int maxArea(int[] height) {
        int n = height.length;
        int i=0;
        int j=n-1;
        int max=0;
        while(i<j){
            max = Math.max(max,(j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }

}
