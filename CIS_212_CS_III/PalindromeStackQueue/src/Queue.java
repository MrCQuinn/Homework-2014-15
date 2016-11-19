public class Queue {
Node front, rear;
public Queue(){
	front = null;
	rear = null;
}

public void enqueue(char c){
	Node a = new Node(c,null);
	if(isEmpty()){
		front = a;
	}else{
		rear.next = a;
	}
	rear = a;
}

public char dequeue(){
	char returnValue = front.data;
	front = front.next;
	return returnValue;
}

public boolean isEmpty(){
	if(front==null){
		return true;
	}else{
		return false;
	}
}
}