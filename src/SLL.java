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
				if (iterator.getData().getAlias().equals(a.getData().getAlias())) {
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
	
	//something bout this one fr
	public SLL<T> addInOrderTotal(Node<Avenger> av) {
//		if (this.contains(av)) { System.out.println(94);
//			return this;
//		}
// 		if (this.size() == 0) { System.out.println(97);
//			this.addHead(av);
//			return this;
//		}
//		else if (this.size() == 1) { System.out.println(101);
//			int diff = compareTotal(av, this.getHead(), totalCompare);
//			if (diff > 0) { System.out.println(103);
//				av.setNext(head);
//				head = av;
//			}
//			else if (diff < 0) { System.out.println(107);
//				head.setNext(av);
//			}
//			else { System.out.println(110);
//				//other
//			}
//			return this;
//		}
//		else { // 2+
//			Node<Avenger> iterator = this.head; 
//			Node<Avenger> previous = null;
//			int diff = compareTotal(av, iterator, totalCompare);
//			if (diff > 0) { System.out.println(119);
//				av.setNext(this.head);
//				this.head = av;
//			}
//
//			else if (diff < 0) { System.out.println(124);
//				while (diff < 0) { System.out.println(125);
//					previous = iterator;
//					iterator = iterator.getNext();
//					diff = compareTotal(av, iterator, totalCompare);
//				}
//				if (diff > 0) { System.out.println(130);
//					previous.setNext(av);
//					av.setNext(iterator);
//				}
//			}
//			
//			else if (diff == 0) { System.out.println(136);
//				// other
//			}
//			
//			if (iterator == null) { System.out.println(140);
//				previous.setNext(av);
//				av.setNext(iterator);
//			}
//			return this;
//		}
		if (head == null) { //empty
			addHead(av);
			return this;
			}
		else if (av.getData().compareTo(head.getData()) > 0) { // n less than head
			addHead(av);
			return this;
		}
		else {
			Node<Avenger> iterator = this.head;
			int resultIterator;
			int resultNext;
			do {
				resultIterator = compareCurrent(av,iterator);
				resultNext = compareCurrentNext(av,iterator);
				iterator = iterator.getNext();
			} while ((resultIterator <= 0 && resultNext >= 0) ||
				     (resultIterator <= 0 && resultNext <= 0) ||
				     (resultIterator >= 0 && resultNext >= 0));
			av.setNext(iterator.getNext());
			iterator.setNext(av);
		}
		return this;
	}

	private int compareCurrent(Node<Avenger> av, Node<Avenger> currentNode) {
		return compareTotal(av, currentNode, totalCompare);
	}
	
	private int compareCurrentNext(Node<Avenger> av, Node<Avenger> currentNode) {
		return compareTotal(av, currentNode, totalCompare);
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