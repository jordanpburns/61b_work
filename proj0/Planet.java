public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	String imgFileName;

	static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p) {
		double r;
		double xDiff = (this.xxPos - p.xxPos);
		double yDiff = (this.yyPos - p.yyPos);
		r = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		return r;
	}
	public double calcForceExertedBy(Planet p) {
        double dist = calcDistance(p);
        double force = (G * this.mass * p.mass) / (dist * dist);
        return force;
	}
	public double calcForceExertedByX(Planet p) {
		return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
	}
	public double calcForceExertedByY(Planet p) {
		return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
	}
	public double calcNetForceExertedByX(Planet[] planets) {
		int i = 0;
		double total = 0;
		while (i < planets.length) {
			if  (!this.equals(planets[i])) {
				total = total + calcForceExertedByX(planets[i]);
				i = i + 1;
			}
			else {
				i = i + 1;
			}
		}
		return total;
	}
	public double calcNetForceExertedByY(Planet[] planets) {
		int i = 0;
		double total = 0;
		while (i < planets.length) {
			if  (!this.equals(planets[i])) {
				total = total + calcForceExertedByY(planets[i]);
				i = i + 1;
			}
			else {
				i = i + 1;
			}
		}
		return total;
	}
	public void update(double dt, double fX, double fY) {
		double ax = fX / this.mass;
		double ay = fY / this.mass;
		this.xxVel = this.xxVel + ax * dt;
		this.yyVel = this.yyVel + ay * dt;
		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;
	}
	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/" + this.imgFileName);
	}
}