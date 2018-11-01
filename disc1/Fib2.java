public class Fib2 {
    public static void main(String[] args) {
        System.out.println(fib2(6, 0, 0, 1));
    }
    public static int fib2(int n, int k, int f0, int f1) {
        if (n < 3) {
            return 0;
	}
	else if (n == 2) {
	    return 1;
	}
        else {
	    return fib(n-1) + fib(n-2);
	}
    }
}
