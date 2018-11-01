public class Triangle {
	public static void main(String[] args) {
		String line = "*";
		int length = 1;
		while (length <= 5) {
			System.out.println(line);
			line = line + "*";
			length = length + 1;
		}
	}
}	
