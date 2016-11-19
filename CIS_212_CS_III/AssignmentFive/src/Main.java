import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Assignment 5 Written by Charlie Quinn Student ID: 951334907
public class Main {
	public static void main(String[] args) throws IOException {
		

		String path = "src/phonebook.txt";
		ArrayList<ContactEntry> contacts = CreateArray(path);
		
		MainFrame mainframe = new MainFrame(contacts);
		mainframe.setVisible(true);
		
//		ArrayList<ContactEntry> selectSortList = mergeSort(contacts);
		
//		for (int i=0; i< selectSortList.size(); i++ )
//		{
//			System.out.println(selectSortList.get(i).get_first() + " " + selectSortList.get(i).get_last() + " " + selectSortList.get(i).get_num());
//		}
//		
//		System.out.println(isSorted(selectSortList));
		
		
	}
	
	public static ArrayList<ContactEntry> CreateArray(String path) throws IOException {
		
		FileReader fr = new FileReader(path);
		BufferedReader in = new BufferedReader(fr);
		
		ArrayList<ContactEntry> ar = new ArrayList<ContactEntry>();
		
		String line = null;
		 while( ( line = in.readLine() ) != null )  {
		       String [] a = line.split(" ");
		       ar.add(new ContactEntry(a[0],a[1].replaceAll("[^a-zA-Z\\s]", ""),a[2]));
		    }
		    in.close();
        return ar;
	}
	
	public static boolean isSorted(ArrayList<ContactEntry> a)
	{
		boolean is = true;
		for (int i =0; i < a.size(); i++)
		{
			if(a.get(i++).get_first().compareTo(a.get(i).get_first()) <= 0)
			{
				is = true;
			}
			else
			{
				is = false;
			}
		}
		return is;
	}
	
	public static ArrayList<ContactEntry> SelectionSort(ArrayList<ContactEntry> unsorted) {
		// Sources used
		//http://www.algolist.net/Algorithms/Sorting/Selection_sort
		int minIndex;
		ContactEntry temp;
		
		for (int i = 0; i < unsorted.size() - 1; i++)
		{
			minIndex = i;
			
			for (int j = i + 1; j < unsorted.size(); j++)
			{
				if (unsorted.get(j).get_first().compareTo(unsorted.get(minIndex).get_first()) < 0)
				{
					minIndex = j;
				}
			}
			if (minIndex != i)
			{
				temp = unsorted.get(i);
				unsorted.set(i, unsorted.get(minIndex));
				unsorted.set(minIndex, temp);
			}
		}
		return unsorted;
	}
	
	public static ArrayList<ContactEntry> mergeSort(ArrayList<ContactEntry> n)
	{
		//Sources used
		//http://users.cis.fiu.edu/~kraynek/COP3337-examples/Sorting/ArrayListSorts.java
		mergeSort(n,0,n.size()-1);
		return n;
	}
	public static void mergeSort(ArrayList<ContactEntry> n, int left, int right)
	{
		if(left >= right)
		{
			return;
		}
		int middle =(left+ right) / 2;
		mergeSort(n,left,middle);
		mergeSort(n,middle+1, right);
		ArrayList<ContactEntry> b = new ArrayList<ContactEntry>();
		int l = left;
		int r = middle +1;
		int i = 0;
		
		while (l <= middle && r <= right)
		{
			if(n.get(l).get_first().compareTo(n.get(r).get_first()) < 0)
			{
				b.add(n.get(l++));
			}
			else
			{
				b.add(n.get(r++));
			}	
		}
		while ( l <= middle) 
		{
			b.add(n.get(l++));
		}
		while (r <= right)
		{
			b.add(n.get(r++));
		}
		i = left;
		for (int j = 0; j< b.size(); j++)
		{
			n.set(i++, b.get(j));
		}
	}	
	
}





