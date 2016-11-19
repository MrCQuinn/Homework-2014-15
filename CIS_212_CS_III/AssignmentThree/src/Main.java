import java.util.ArrayList;
import java.util.Random;

//Assignment 3 Written by Charlie Quinn Student ID: 951334907

public class Main {
	public static void main(String[] args) {
		
		Random random = new Random();
		ArrayList<AreaMeasurable> a = new ArrayList<AreaMeasurable>();
		int which;
		int circleCount = 0;
		int rectangleCount = 0;
		int squareCount = 0;
		int sphereCount = 0;
		int boxCount = 0;
		int cubeCount = 0;
		
		for(int i = 0; i < 1000; i++)
		{
			which = random.nextInt(6) + 1;
			
			if (which == 1){
				a.add(new Circle(nextRandomDouble()));
				circleCount++;
			}
			else if(which == 2){
				a.add(new Rectangle(nextRandomDouble(),nextRandomDouble()));
				rectangleCount++;
			}
			else if(which == 3){
				a.add(new Square(nextRandomDouble()));
				squareCount++;
			}
			else if(which == 4){
				a.add(new Sphere(nextRandomDouble()));
				sphereCount++;
			}
			else if(which == 5){
				a.add(new Box(nextRandomDouble(),nextRandomDouble(),nextRandomDouble()));
				boxCount++;
			}
			else if(which == 6){
				a.add(new Cube(nextRandomDouble()));
				cubeCount++;
			}
		}
		
		double sum = calculateSum(a);
		
		System.out.println("circles: "+ circleCount + " rects: " + rectangleCount + " squares: " + squareCount + " spheres: " + sphereCount + " boxes: " + boxCount + " cubes: " + cubeCount);
		System.out.println("sum: "+ sum);
	}
	
	private static double nextRandomDouble() 
	{
		Random r = new Random();
		double it = r.nextDouble() + Double.MIN_VALUE;
		return it; //return a double 0-1 not 0
	}
	
	private static double calculateSum(ArrayList<AreaMeasurable> arr)
	{
		double total = 0;
		for (int i = 0; i < arr.size(); i++)
		{
			total = total + arr.get(i).getArea();
		}
		return total;//return sum off all the areas in list
	}
	
	

}
