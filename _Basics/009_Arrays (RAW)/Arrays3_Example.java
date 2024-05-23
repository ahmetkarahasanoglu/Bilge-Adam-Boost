
public class Arrays3_Example {

	public static void main(String[] args) {
		
	// Find the min and max numbers in the array below.
		int[] numArr = new int[] {1, 5, -5, 9, 54, 3, 23, 87};
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<numArr.length; i++) {
//			if(i==0) {  // this is another technique to initiate min&max values.
//				max = numArr[i];
//				min = numArr[i];
//			}
			if(numArr[i] > max) {
				max = numArr[i];
			}
			if(numArr[i] < min) {
				min = numArr[i];
			}
		}
		
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
		

	}
}
