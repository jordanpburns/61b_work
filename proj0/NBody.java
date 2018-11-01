public class NBody {
	public static double readRadius(String file) {
        In in = new In(file);
        int numPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
	}
	public static Planet[] readPlanets(String file) {
		In in = new In(file);
		int numPlanets = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[numPlanets];
		int i = 0;
		while (i < numPlanets) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
			i += 1;
		}
        return planets;
	}
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = readPlanets(filename);
		double radius = readRadius(filename);

		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for (Planet p : planets) {
			p.draw();
		}
		StdDraw.enableDoubleBuffering();
		double time = 0;
		while (time < T) {
			double[] xForces = new double [planets.length];
			double[] yForces = new double [planets.length];
			for (int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i < planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
				StdDraw.picture(0, 0, "images/starfield.jpg");
				for (Planet p : planets) {
					p.draw();
				}
				StdDraw.show();
				StdDraw.pause(10);
				time += dt;
			}
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
          	        	planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
          	        	planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
    	}
    }
}