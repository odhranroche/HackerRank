public class RotateLeft {

	public static void main(String[] args) {

		int arr[] = {1, 2, 3, 4, 5};
		
		printArray(arr);
		printArray(rotLeft(arr, 1));
		printArray(rotLeft(arr, 4));
		printArray(rotLeft(arr, 7));
		printArray(rotLeft(arr, 10));
	}
	
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int len = a.length;
        int numRotations = d % len;
        //System.out.println("Rotating " + numRotations + " time(s):");
        
        if (numRotations <= 0) {
        	return a;
        }
        
        int newA[] = new int[len]; 
        
        for (int i = 0; i < a.length; i++) {
        	int indexToSwap = (i + numRotations) % len;
        	newA[i] = a[indexToSwap];
        }
        
        return newA;
    }
    
    static void printArray(int[] arr) {
		for (int i = 0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
    }

}
