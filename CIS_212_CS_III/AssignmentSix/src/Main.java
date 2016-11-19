import java.util.ArrayList;
//Assignment 6 Written by Charlie Quinn Student ID: 951334907

public class Main {
	public static void main(String[] args) {
		
		OccurranceSet<Integer> intSet = new OccurranceSet<Integer>();
		
		if(intSet.isEmpty())
		{
			System.out.println("This should print because the set is empty");
		}
		
		intSet.add(8);
		intSet.add(7);
		intSet.add(6);
		intSet.add(8);
		intSet.add(30);
		intSet.add(8);
		intSet.add(3);
		intSet.add(6);
		intSet.add(4);
		intSet.add(32);
		intSet.add(15);
		intSet.add(17);
		intSet.add(21);
		
		System.out.println(intSet);
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i = 1; i < 10; i++)
		{
			a.add(i*2);
		}
		
		intSet.addAll(a);
		System.out.println(intSet);
		
		OccurranceSet<Integer> duplicate = new OccurranceSet<Integer>();
		
		for (Integer el : intSet)
		{
			duplicate.add(el);
		}
		
		//works
		//intSet.clear();
		
		System.out.println(intSet.contains(12));
		System.out.println(intSet.contains(5));
		
		System.out.println(intSet.containsAll(a));
		a.add(5);
		System.out.println(intSet.containsAll(a));
		System.out.println(intSet.contains(32));
		intSet.remove(32);
		System.out.println(intSet.contains(32));
		intSet.removeAll(a);
		System.out.println(intSet);
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(15);
		b.add(17);
		b.add(21);
		intSet.retainAll(b);
		System.out.println("one:"+intSet);
		
		System.out.println("other: "+duplicate);
		intSet.addAll(duplicate);
		System.out.println("both: "+intSet);
		
		
		
		OccurranceSet<String> wordSet = new OccurranceSet<String>();
		
		wordSet.add("Dog");
		wordSet.add("Dog");
		wordSet.add("Dog");
		wordSet.add("Dog");
		wordSet.add("Dog");
		wordSet.add("Cat");
		wordSet.add("Fish");
		wordSet.add("Rock");
		wordSet.add("Rock");
		wordSet.add("Rock");
		wordSet.add("Rock");
		wordSet.add("Platypus");
		wordSet.add("Idea");
		wordSet.add("Idea");
		wordSet.add("Idea");
		wordSet.add("Else");
		
		System.out.println(wordSet.size());
		System.out.println(wordSet.contains("Dog"));
		
		Object[] c = wordSet.toArray();

		for(int i = 0; i< c.length; i++)
		{
			if((i+1)<c.length)
			{
			System.out.print(c[i] + ", ");
			}
			else{
				System.out.print(c[i]);
			}
		}
		System.out.println();
		System.out.println(wordSet);
		
	}


}
