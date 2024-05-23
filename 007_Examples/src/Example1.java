
public class Example1 {

	public static void main(String[] args) {
		
	// Question 1) Print the below pattern by using loop.
	/* 
	 *   * * * * *
	 *   * * * * *
	 *   * * * * *
	 *   * * * * *
	 * 
	 * */
		
		for(int i=0; i<4; i++) {
			for(int j=1; j<=5; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------------");
		
		// Question 2) By using only 1 "*", make a square with 
		// desired length. For example:
		/* 
		 *   * * * 
		 *   * * * 
		 *   * * * 
		 *   
		 * */
		// my solution:
		int edge = 3;
		for(int j=1; j<=edge; j++) {
			for(int i=1; i<=edge; i++) { // makes row.
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("------------");
		// teacher's solution:
		edge = 5;
		for(int i=1; i<=edge*edge; i++) {
			System.out.print("* ");
			if(i%edge==0) {
				System.out.println();
			}
		}
		
		System.out.println("-----------------------------------");
	
		// Question: (this is a question I came up with): By using "*" and
		// loops, make a square with desired edge lengty with an empty 
		// inner area. For example:
		/* 
		 *   * * * *
		 *   *     *
		 *   *     *
		 *   * * * *
		 *   
		 * */
		// my solution:
		edge = 5;
		for (int j=1; j<=edge; j++) { // makes the top edge
			System.out.print("* ");
		}
		System.out.println();
		String gap = "";
		for(int k=1; k<=edge-2; k++) { // for calculating gap
			gap = gap + "  ";
		}
		for(int m=1; m<=edge-2; m++) { // makes the middle lines
			System.out.println("* " + gap + "*");
		}
		for (int j=1; j<=edge; j++) { // makes the bottom edge
			System.out.print("* ");
		}
		System.out.println();
		System.out.println("------------");
		// teacher's solution:
		edge = 5;
		for(int i=1; i<edge*edge; i++) {
			if(i%edge==1 || i%edge==0 || i<=edge || i>edge*(edge-1)) {
				System.out.print("* ");
			}else {
				System.out.print("  ");
			}
			if(i%edge==0) {
				System.out.println();
			}
		}
	
		
		
		

	}
}
