public class Stack {
	Node top;

	public Stack(){
		top = null;
	}

	public void push(char c){
		if(isEmpty()){
			top = new Node(c,null);
		}else{
			Node t = new Node(c, top);
			top = t;
		}
	}

	public char pop(){
		char returnValue = top.data;
		top = top.next;
		return returnValue;
	}

	public boolean isEmpty(){
		if(top==null){
			return true;
		}else{
			return false;
		}
	}

}
