public class SLL<T> {
	private Node<Avenger> head, tail;
	private totalCompare totalCompare;
	private performerCompare performerCompare;

	public SLL() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		else {
			return false;
		}
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
			head = av;
			tail = av;
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
		boolean status;
		Node<Avenger> iterator = head;
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
		int diff = compareTo(a);
		return diff;
	}
	
	
	public int size() {
		Node<Avenger> counter = head;
		int count = 0;
		while (counter != null) {
			count ++;
			counter = counter.getNext();
		}
		return count;
	}
	
	//something bout this one fr
	public void addInOrderTotal(Node<Avenger> av) {
		if (contains(av)) {
			return;
		}
		if (isEmpty()) {
			addHead(av);
		} 
		else {
			if (compare(av, head, totalCompare) >= 0)
				addHead(av);
			else {
				Node<Avenger> currentNode = head;
				while (currentNode.getNext() != null && compare(av, head, totalCompare) < 0) {
					currentNode = currentNode.getNext();
				}
				if (currentNode.getNext() == null) {
					addTail(av);
				} else {
					av.setNext(currentNode.getNext());
					currentNode.setNext(av);
				}
			}
		}
	}

	public void addInOrderPerformer(Node<Avenger> av) {
		if (contains(av)) {
			return;
		}
		if (isEmpty()) {
			addHead(av);
		} 
		else {
			if (compare(av, head, performerCompare) >= 0)
				addHead(av);
			else {
				Node<Avenger> currentNode = head;
				while (currentNode.getNext() != null && compare(av, head, performerCompare) < 0) {
					currentNode = currentNode.getNext();
				}
				if (currentNode.getNext() == null) {
					addTail(av);
				} else {
					av.setNext(currentNode.getNext());
					currentNode.setNext(av);
				}
			}
		}
	}
	
	public void addInOrderAlphabetical(Node<Avenger> av) {
		if (isEmpty()) {
			addHead(av);
		} else {
			if (av.getData().getAlias().compareTo(head.getData().getAlias()) >= 0)
				addHead(av);
			else {
				Node<Avenger> currentNode = head;
				while (currentNode.getNext() != null && av.getData().getAlias().compareTo(currentNode.getNext().getData().getAlias()) < 0) {
					currentNode = currentNode.getNext();
				}
				if (currentNode.getNext() == null) {
					addTail(av);
				} else {
					av.setNext(currentNode.getNext());
					currentNode.setNext(av);
				}
			}
		}
	}
	
	public int compare(Node<Avenger> a, Node<Avenger> b, totalCompare comparing) {
		return comparing.compare(a, b);
	}
	
	public int compare(Node<Avenger> a, Node<Avenger> b, performerCompare comparing) {
		return comparing.compare(a, b);
	}
}