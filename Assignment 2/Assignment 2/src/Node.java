class Node<T> 
{
	private T data; // data portion
	private Node<T> next; // link to next node

	Node(T dataPortion) {
		data = dataPortion;
		next = null;
	} // end constructor

	Node(T dataPortion, Node<T> nextNode) {
		data = dataPortion;
		next = nextNode;
	} // end constructor
	
	void setNext(Node<T> nextNode) {
		next = nextNode;
	}
	
	Node<T> getNext() {
		return next;
	}
	
	void setData(T dataPortion) {
		data = dataPortion;
	}
	
	T getData() {
		return data;
	}
} // end Node