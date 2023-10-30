
public class SLL<Avenger extends Comparable<Avenger>>{
	private Node<Avenger> head, tail;
	private int size;

	public SLL() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		if (size == 0) return true;
		else return false;
	}
	
	public void addHead(Node<Avenger> av) {
		if (isEmpty()) {
			head = av;
			tail = av;
		}
		else {
			av.setNext(head);
			head = av;
		}
	}
	
	public void addTail(Node<Avenger> av) {
		if (isEmpty()) {
			addHead(av);
		}
		else {
			tail.setNext(av);
			tail = av;
		}
	}
	
	public Node<Avenger> getHead() {
		return head;
	}
	
	public Node<Avenger> getTail() {
		return tail;
	}

	public boolean contains(Node<Avenger> a) {
		if (isEmpty()) {
			return false;
		}
		else {
			if (this.contains(a)) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	public int compareTo(String a) {
		int diff = this.compareTo(a);
		return diff;
	}
	
}