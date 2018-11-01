public class TestPlanet {
	public static void main(String[] args) {
		Planet p1 = new Planet(0, 0, 2, 3, 5e14, "wooooo");
		Planet p2 = new Planet(5, 5, 6, -3, 7e17, "gnarrrrrr");
		System.out.println(p1.calcForceExertedByX(p2));
	}
}