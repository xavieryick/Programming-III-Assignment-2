
/**
 * This class represents a singly linked list (SLL) of Avenger nodes
 *
 * @param <T> The type of data stored in the Avenger nodes (e.g., Avenger objects)
 */
public class SLL<T> {
	private Node<Avenger> head, tail;
	private totalCompare totalCompare = new totalCompare();
	private performerCompare performerCompare = new performerCompare();

    /**
     * Constructs an empty singly linked list.
     */
	public SLL() {
		this.head = null;
		this.tail = null;
	}

    /**
     * Checks if the singly linked list is empty
     *
     * @return True if the list is empty, false otherwise
     */
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
    /**
     * Adds an Avenger node to the beginning of the singly linked list
     *
     * @param av The Avenger node to add to the list
     */
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
	
    /**
     * Adds an Avenger node to the end of the singly linked list
     *
     * @param av The Avenger node to add to the list
     */
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
	
    /**
     * Gets the head node of the singly linked list
     *
     * @return The head node of the list
     */
	public Node<Avenger> getHead() {
		return this.head;
	}
	
	/**
     * Sets the head node of the singly linked list
     *
     * @param head The node to set as the new head of the list
     */
    public void setHead(Node<Avenger> head) {
        this.head = head;
    }
	
    /**
     * Gets the tail node of the singly linked list
     *
     * @return The tail node of the list
     */
	public Node<Avenger> getTail() {
		return this.tail;
	}

    /**
     * Checks if the singly linked list contains a specific Avenger node
     *
     * @param a The Avenger node to search for in the list
     * @return True if the node is found, false otherwise
     */
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
	
    /**
     * Gets the number of nodes in the singly linked list
     *
     * @return The size of the list (number of nodes)
     */
	public int size() {
		Node<Avenger> counter = this.head;
		int count = 0;
		while (counter != null) {
			count ++;
			counter = counter.getNext();
		}
		return count;
	}
	
    /**
     * Adds an Avenger node to the singly linked list in order of their total counts
     *
     * @param av The Avenger node to add to the list
     * @return The modified singly linked list
     */
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

    /**
     * Adds an Avenger node to the singly linked list in order of their performer counts
     *
     * @param av The Avenger node to add to the list
     * @return The modified singly linked list
     */
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
	
    /**
     * Compares two Avenger nodes based on their total counts
     *
     * @param a The first Avenger node for comparison
     * @param b The second Avenger node for comparison
     * @param comparing The comparator for total counts
     * @return The result of the comparison (negative if a is less than b, positive if a is greater than b, zero if equal)
     */
	public int compareTotal(Node<Avenger> a, Node<Avenger> b, totalCompare comparing) {
		return comparing.compare(a, b);
	}
	
    /**
     * Compares two Avenger nodes based on their performer counts
     *
     * @param a The first Avenger node for comparison
     * @param b The second Avenger node for comparison
     * @param comparing The comparator for performer counts
     * @return The result of the comparison (negative if a is less than b, positive if a is greater than b, zero if equal)
     */
	public int comparePerformer(Node<Avenger> a, Node<Avenger> b, performerCompare comparing) {
		return comparing.compare(a, b);
	}
}