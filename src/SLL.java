
public class SLL<Avenger extends Comparable<Avenger>>{
	private Node<Avenger> head, tail;

	public SLL() {
		this.head = null;
		this.tail = null;
	}

	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addHead(Node<Avenger> av) {
		if (isEmpty()) {
			this.head = av;
			this.tail = av;
		}
		else {
			av.setNext(this.head);
			this.head = av;
		}
	}
	
	public void addTail(Node<Avenger> av) {
		if (isEmpty()) {
			this.head = av;
			this.tail = av;
		}
		else {
			this.tail.setNext(av);
			this.tail = av;
		}
	}
	
	public Node<Avenger> getHead() {
		return this.head;
	}
	
	public Node<Avenger> getTail() {
		return this.tail;
	}

	public boolean contains(Node<Avenger> a) {
		boolean status;
		Node<Avenger> iterator = this.head;
		if (isEmpty()) {
			status = false;
			return status; 
		}
		else {
			while (iterator != null) {
				if (iterator.equals(a)) {
					status = true;
					return status;
				}
				else {
					iterator = iterator.getNext();
				}
			}
			if (iterator == null ) {
				status = false;
				return status;
			}
			status = false;
			return status;
		}
	}

	public int compareTo(String a) {
		int diff = this.compareTo(a);
		return diff;
	}
	
	
	public int size() {
		Node<Avenger> counter = this.head;
		int count = 0;
		while (counter != null) {
			count ++;
			counter = counter.getNext();
		}
		return count;
	}
}