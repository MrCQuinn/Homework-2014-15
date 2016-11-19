//Assignement 2 Written By Charlie Quinn Student ID: 951334907
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int arrayLength = 0;
		double arrayDensity = -1.0;
		
		while (arrayLength == 0)
		{
			System.out.println("Array Length: ");
			
			try{
				arrayLength = sc.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("That's not a proper length.");
				sc.next();
			}
		}
		
		while(arrayDensity == -1)
		{
			System.out.println("Enter Density: ");
			try{
				arrayDensity = sc.nextDouble();
				if (arrayDensity > 1 || arrayDensity < 0)
				{
					arrayDensity = -1;
					System.out.println("Please enter a density between 0 and 1");
				}
			}
			catch(InputMismatchException e){
				System.out.println("That's not a proper density.");
				sc.next();
			}
		}
		long startTime = System.nanoTime();
		int[] a = denseArray(arrayLength,arrayDensity);
		long createDenseTime = System.nanoTime() - startTime;
		//Took longer than createSparseArray() for low density and high length
		//Much Quicker than createSparseArray() for high density and high length
		//Took Much longer than createSparseArray() for low density and low length
		//Took Much longer than createSparseArray() for high density and low length
		//Only Quicker for cases in which their are few zeros and a large number of variables
		
		startTime = System.nanoTime();
		ArrayList<int[]> b = sparseArray(arrayLength,arrayDensity);
		long createSparseTime = System.nanoTime() - startTime;
		//Quicker creation time for most cases except high density arrays with a length in the hundreds of thousands
		
//		System.out.println("Dense Array:");
//		System.out.println(Arrays.toString(a));
//		
//		System.out.println();
//		
//		System.out.println("Sparse Array:");
//		
//		System.out.print("[");
//		for (int[] array : b) {
//		     System.out.print(Arrays.toString(array) + ",");
//		}
//		System.out.print("]\n\n");
		
		System.out.println("createDenseArray() length: " + a.length + " time: " + createDenseTime + "\n");
		System.out.println("createSparseArray() length: " + b.size() + " time: " + createSparseTime + "\n" );
		
		startTime = System.nanoTime();
		ArrayMax(a);
		long findArrayMaxTime = System.nanoTime() - startTime;
		System.out.println("dense findMax() time: " + findArrayMaxTime + "\n");
		//Quicker than sparse findMax() except for very low densities (less than .1) and high lengths
		
		startTime = System.nanoTime();
		ListMax(b);
		long findListMaxTime = System.nanoTime() - startTime;
		System.out.println("sparse findMax() time: " + findListMaxTime + "\n");
		//Only Quicker than dense findMax() for cases with low densities and high lengths
		
	}
	
	private static final int MAX_INT = 1000000;
	
	private static int[] denseArray(int len, double den)
	{
		Random r = new Random();
		int i = 0;
		int newnew = 0;
		int array[] = new int[len];
		
		while (i < len)
		{
			double num = r.nextDouble();
			
			if(num <= den)
			{
				newnew = r.nextInt(MAX_INT);
				array[i] = newnew;
			}
			i++;
		}
		return array;
	}
	
	private static ArrayList<int[]> sparseArray(int len, double den)
	{
		Random r = new Random();
		int i = 0;
		int newnew = 0;
		
		ArrayList<int[]> array = new ArrayList<int[]>();
		
		while (i < len)
		{
			double num = r.nextDouble();
			if(num <= den)
			{
				newnew = r.nextInt(MAX_INT);
				int [] miniArray = {i, newnew};
				array.add(miniArray);
			}
			i++;
		}
		return array;
	}
	
	private static void ArrayMax(int[] array)
	{	
		int d_max = 0;
		int count = 0;
		int index = 0;
		for (int el : array)
		{
			if (el > d_max)
			{
				d_max = el;
				index = count;
			}
		count++;
		}
		System.out.println("findMax (array): " + d_max + " at: " + index + "\n");
	}
	
	private static void ListMax (ArrayList<int[]> array)
	{
		int d_max = 0;
		int index = 0;
		for (int[] el : array)
		{
			if (el[1] > d_max)
			{
				d_max = el[1];
				index = el[0];
			}
		}
		System.out.println("findMax (list): " + d_max + " at: " + index + "\n");
	}

}
