
public class Rectangle implements AreaMeasurable {
	double height;
	double width;
	
	public Rectangle(double h, double w)
	{
		height = h;
		width = w;
	}
	
	@Override
	public double getArea() {
		return height*width;
	}

}
