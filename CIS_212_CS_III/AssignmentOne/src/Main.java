//Assignment 1 Written by Charlie Quinn Student ID: 951334907

import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args) {
		java.util.Scanner scnr;
		scnr = new java.util.Scanner(System.in);
		System.out.println("Enter a positive integer (-1 to print, -2 to reset, -3 to exit):");
		int vari = 0;
		int total = 0;
		while (vari != -3)
		{	
			try{
			vari = scnr.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("Hey, that's no integer!");
				scnr.next();
				vari = -1;
			}
			if (vari == -1)
			{
				System.out.println(total);
			}
			else if (vari == -2)
			{
				total = 0;
			}
			else if (vari == -3)
			{
				break;
			}
			else if(vari >= 0)
			{
			total = total + vari;
			}
		}
	}

}
