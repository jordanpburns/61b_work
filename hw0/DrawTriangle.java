public class DrawTriangle {
	public static void drawTriangle(int N) {
		String line = "*";
		int length = 1;
		while (length <= N) {
                        System.out.println(line);
                        line = line + "*";
                        length = length + 1;
	}
}
	public static void main(String[] args) {
		drawTriangle(10);
	}
}
