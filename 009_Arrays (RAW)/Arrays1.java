
public class Arrays1 {

	public static void main(String[] args) {
		
		// Declaration:
		int[] numbers_array;
		String[] names_array;
		boolean[] choice_array;		
		
		// Assignment to Array:
		numbers_array = new int[4]; // (4-element array)
		names_array = new String[3]; // (3-element array)
		choice_array = new boolean[5]; // (5-element array)
		
		int[] myArray = new int[5]; // Initializing an array of integers with size 5.

		
		// Assignment By Specifying The Content of the Array
		String[] names = {"John", "Jack", "Alan"};
		
		/*  *** CHARACTERISTICS OF ARRAYS: ***
		 *  Fixed Size:  Once the size of an array is defined, it cannot be changed.
		 *  Homogeneous Elements:  All elements in an array must be of the same type (e.g., int, String, Object, etc.).
		 */
		
		int simpleVariable = 34;
		int[] numbers = new int[6]; // (6-element array)
		numbers[0] = 123;
		System.out.println(numbers[0]); // output: 123		
		System.out.println(numbers[1]); // output: 0 --> non-asigned elements has the value of 0
		System.out.println(numbers[5]); // output: 0 --> non-asigned elements has the value of 0
		
		/* '--> In an array that has primitive-type elements, all the 
		  elements are addressed on the memory; so the non-assigned 
		  elements take their default initial value:
		  - byte, short, int, long -> 0
		  - float, double -> 0.0
		  - boolean -> false
		  - char -> '\0'
		* For the arrays that are created to have References Data Type 
		  elements (like String), addressing is done but since the 
		  address doesn't point to any place in the memory, all the 
		  non-assigned elements take the value of null.		  
		*/
		String[] strArr = new String[3];
		System.out.println("Element 1: " + strArr[0]);
		System.out.println("Element 2: " + strArr[1]);
		System.out.println("Element 3: " + strArr[2]);
		// ---------------------------------------------------------
		System.out.println("---------------------------------------");

		// Jagged Array: arrays within an array. Each sub-array can have different length.
		int[][] jaggedArray = new int[3][];
		jaggedArray[0] = new int[]{1, 2, 3};
		jaggedArray[1] = new int[]{4, 5};
		jaggedArray[2] = new int[]{6, 7, 8, 9};

		// Accessing elements in the jagged array
		System.out.println(jaggedArray[0][1]); // Outputs: 2
		System.out.println(jaggedArray[1][0]); // Outputs: 4
		System.out.println(jaggedArray[2][3]); // Outputs: 9
		
		
		
	}
}
