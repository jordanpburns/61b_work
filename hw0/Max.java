public class Max {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int index = 0;
	int biggest = m[index];
	int len = m.length;
	int test;
        while (index < len - 1) {
	    index = index + 1;
	    test = m[index];
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
