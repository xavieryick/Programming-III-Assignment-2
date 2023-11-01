public class SLL<T> {
	private Node<Avenger> head, tail;
	private totalCompare totalCompare = new totalCompare();
	private performerCompare performerCompare = new performerCompare();

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
	
	public SLL<T> addInOrderTotal(Node<Avenger> av) {
		if (isEmpty()) {
			this.addHead(av);
			return this;
		}
		else if (this.head.getNext() == null) {
			int diff = compareTotal(av, this.getHead(), totalCompare);
			if (diff > 0) {
				av.setNext(head);
				head = av;
			}
			else if (diff < 0) {
				head.setNext(av);
			}
			else {
				//other
			}
			return this;
		}
		else {
			Node<Avenger> iterator = this.head;
			Node<Avenger> previous = null;
			int diff = compareTotal(av, iterator, totalCompare);
			while (diff < 0) {
				previous = iterator;
				iterator = iterator.getNext();
				diff = compareTotal(av, iterator, totalCompare);
			}
			if (diff == 0) {
				//
			}
			if (diff > 0) {
				if (previous != null) {
					previous.setNext(av);
					av.setNext(iterator);
				}
				if (previous == null) {
					av.setNext(iterator);
					head = av;
				}
			}
		}
		return this;
	}

	public SLL<T> addInOrderPerformer(Node<Avenger> av) {
		if (isEmpty()) {
			this.addHead(av);
			return this;
		}
		else if (this.head.getNext() == null) {
			int diff = comparePerformer(av, this.getHead(), performerCompare);
			if (diff > 0) {
				av.setNext(head);
				head = av;
			}
			else if (diff < 0) {
				head.setNext(av);
			}
			else {
				//other
			}
			return this;
		}
		else {
			Node<Avenger> iterator = this.head;
			Node<Avenger> previous = null;
			int diff = comparePerformer(av, iterator, performerCompare);
			while (diff < 0) {
				previous = iterator;
				iterator = iterator.getNext();
				diff = comparePerformer(av, iterator, performerCompare);
			}
			if (diff == 0) {
				//
			}
			if (diff > 0) {
				if (previous != null) {
					previous.setNext(av);
					av.setNext(iterator);
				}
				if (previous == null) {
					av.setNext(iterator);
					head = av;
				}
			}
		}
		return this;
	}
	
	// maybe creating these works?
	public int compareTotal(Node<Avenger> a, Node<Avenger> b, totalCompare comparing) {
		return comparing.compare(a, b);
	}
	
	public int comparePerformer(Node<Avenger> a, Node<Avenger> b, performerCompare comparing) {
		return comparing.compare(a, b);
	}
}