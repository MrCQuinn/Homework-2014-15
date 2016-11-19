
public class Sphere implements AreaMeasurable {
	double radius;
	
	public Sphere(double r)
	{
		radius = r;
	}

	@Override
	public double getArea() {
		return Math.PI*(radius*radius)*4;
	}

}
