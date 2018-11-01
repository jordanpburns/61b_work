public class ForMax {
    /** Returns the maximum value from m using a for loop. */
    public static int max(int[] m) {
	int biggest = m[0];
        int test;
        for (int i = 1; i < m.length; i += 1) {
	    test = m[i];
            if (test > biggest){
	        biggest = test;    
	    }
	}
        return biggest;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
       System.out.println(max(numbers));
    }
}
