
public class Circle implements AreaMeasurable{
	double radius;
	
	public Circle(double r)
	{
		radius = r;
	}

	@Override
	public double getArea() {
		return Math.PI*(radius*radius);
	}

}
