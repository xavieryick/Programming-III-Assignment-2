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
		}
		else if (this.getHead().getNext() == null) {
			int diff = compareTotal(av, this.getHead(), totalCompare);
			if (diff > 0) {
				av.setNext(this.head);
				this.addHead(av);
			}
			else if (diff < 0) {
				this.head.setNext(av);
			}
			else {
				// compare else
			}
		}
		else {
			Node<Avenger> iterator = this.head;
			Node<Avenger> previous = null;
			while (iterator != null) {
				int diff = compareTotal(av, iterator, totalCompare);
				if (diff > 0) {
					previous.setNext(av);
					av.setNext(iterator);
				}
				else if (diff < 0) {
					previous = iterator;
					iterator = iterator.getNext();
				}
				else {
					//compare else
				}
			}
		}
		return this;
	}

	public SLL<T> addInOrderPerformer(Node<Avenger> av) {
		if (isEmpty()) {
			this.addHead(av);
		}
		else if (this.getHead().getNext() == null) {
			int diff = comparePerformer(av, this.getHead(), performerCompare);
			if (diff > 0) {
				av.setNext(this.head);
				this.addHead(av);
			}
			else if (diff < 0) {
				this.head.setNext(av);
			}
			else {
				// compare else
			}
		}
		else {
			Node<Avenger> iterator = this.head;
			Node<Avenger> previous = null;
			while (iterator != null) {
				int diff = comparePerformer(av, iterator, performerCompare);
				if (diff > 0) {
					previous.setNext(av);
					av.setNext(iterator);
				}
				else if (diff < 0) {
					previous = iterator;
					iterator = iterator.getNext();
				}
				else {
					//compare else
				}
			}
		}
		return this;
	}
	
	// maybe creating these works?
	public int compareTotal(Node<Avenger> a, Node<Avenger> b, totalCompare comparing) {
		int result = comparing.compare(a, b);
		return result;
	}
	
	public int comparePerformer(Node<Avenger> a, Node<Avenger> b, performerCompare comparing) {
		return comparing.compare(a, b);
	}
}