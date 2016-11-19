
public class Box implements AreaMeasurable {
	double length;
	double width;
	double height;
	
	public Box(double l,double w, double h)
	{
		length = l;
		width = w;
		height = h;
	}

	@Override
	public double getArea() {
		return (((length*width)*2)+((width*height)*2)+((length*height)*2));
	}

}
