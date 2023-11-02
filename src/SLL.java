public class SLL<T> {
	private Node<Avenger> head, tail;
	private totalCompare totalCompare = new totalCompare();
	private performerCompare performerCompare = new performerCompare();

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
	
	public Node<Avenger> addInOrderTotal(Node<Avenger> head, Node<Avenger> av) {
	    if (head == null || totalCompare.compare(av, head) >= 0) {
	        av.setNext(head);
	        return av;
	    } else {
	        Node<Avenger> current = head;
	        while (current.getNext() != null && totalCompare.compare(av, head) < 0) {
	            current = current.getNext();
	        }
	        av.setNext(current.getNext());
	        current.setNext(av);
	        return head;
	    }
	}

	public Node<Avenger> addInOrderPerformer(Node<Avenger> head, Node<Avenger> av) {
	    if (head == null || performerCompare.compare(av, head) >= 0) {
	        av.setNext(head);
	        return av;
	    } else {
	        Node<Avenger> current = head;
	        while (current.getNext() != null && performerCompare.compare(av, head) < 0) {
	            current = current.getNext();
	        }
	        av.setNext(current.getNext());
	        current.setNext(av);
	        return head;
	    }
	}
	
	public Node<Avenger> addInOrderAlphabetical(Node<Avenger> head, Node<Avenger> av) {
	    if (head == null || av.getData().getAlias().compareTo(head.getData().getAlias()) <= 0) {
	        av.setNext(head);
	        return av;
	    } else {
	        Node<Avenger> current = head;
	        while (current.getNext() != null && av.getData().getAlias().compareTo(current.getNext().getData().getAlias()) > 0) {
	            current = current.getNext();
	        }
	        av.setNext(current.getNext());
	        current.setNext(av);
	        return head;
	    }
	}

	
	public int compare(Node<Avenger> a, Node<Avenger> b, totalCompare comparing) {
		return comparing.compare(a, b);
	}
	
	public int compare(Node<Avenger> a, Node<Avenger> b, performerCompare comparing) {
		return comparing.compare(a, b);
	}
}