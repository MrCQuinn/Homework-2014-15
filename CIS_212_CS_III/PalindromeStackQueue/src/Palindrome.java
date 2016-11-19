import java.util.Scanner;

public class Palindrome {
//All methods were written in 9 lines of code or less, by Charlie Quinn
//Student ID: 951334907
	
public static void main(String[] args) {//main function, receives input, cleans output and runs method isPalindrome to decide on output
	Scanner sc = new Scanner(System.in);
	String input = sc.nextLine();
	input = input.replaceAll("\\s+","");
	if(is_Palindrome(input, new Stack(), new Queue())){
		System.out.println("The string "+input+" is a palindrome");
	}else{
		System.out.println("The string "+input+" is not a palindrome");
	}
}

private static boolean is_Palindrome(String input, Stack stack, Queue queue){// method called by main, parameters are input and empty stack and queue. uses lowercased characters to fill stack and queue, then compares the output for true/false conclusion
	for(int i = 0; i < input.length(); i++){
		char Ch = Character.toLowerCase(input.charAt(i));
		stack.push(Ch);
		queue.enqueue(Ch);
	}
	for(int i = 0; i< input.length(); i++){
		if (stack.pop()!=queue.dequeue()){return false;}
	}
	return true;
}

}