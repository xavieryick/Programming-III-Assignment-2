/**
 * This class represents a singly linked list (SLL) of Avenger nodes
 *
 * @param <T> The type of data stored in the Avenger nodes (e.g., Avenger objects)
 */
public class SLL<T> {
	private Node<Avenger> head, tail;
	private ComparatorAvenger totalCompare = new ComparatorAvenger();
	private ComparatorPerformer performerCompare = new ComparatorPerformer();

	/**
     * Constructs an empty singly linked list.
     */
	public SLL() {
		head = null;
		tail = null;
	}

	/**
     * Checks if the singly linked list is empty
     *
     * @return True if the list is empty, false otherwise
     */
	public boolean isEmpty() {
		if (head == null) {
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
			head = av;
			tail = av;
		}
		else {
			av.setNext(head);
			head = av;
		}
	}
	
	/**
     * Adds an Avenger node to the end of the singly linked list
     *
     * @param av The Avenger node to add to the list
     */
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
	
	/**
     * Gets the head node of the singly linked list
     *
     * @return The head node of the list
     */
	public Node<Avenger> getHead() {
		return head;
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
		return tail;
	}

	 /**
     * Checks if the singly linked list contains a specific Avenger node
     *
     * @param a The Avenger node to search for in the list
     * @return True if the node is found, false otherwise
     */
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
	
	/**
     * Gets the number of nodes in the singly linked list
     *
     * @return The size of the list (number of nodes)
     */
	public int size() {
		Node<Avenger> counter = head;
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
	public Node<Avenger> addInOrderTotal(Node<Avenger> head, Node<Avenger> av) {
	    if (head == null || av.getData().getTotalCount() - (head.getData().getTotalCount()) >= 0) {
	        av.setNext(head);
	        return av;
	    } else {
	        Node<Avenger> current = head;
	        while (current.getNext() != null && av.getData().getTotalCount() - (current.getNext().getData().getTotalCount()) < 0) {
	            current = current.getNext();
	        }
	        av.setNext(current.getNext());
	        current.setNext(av);
	        return head;
	    }
	}

	/**
     * Adds an Avenger node to the singly linked list in order of their performer counts
     *
     * @param av The Avenger node to add to the list
     * @return The modified singly linked list
     */
	public Node<Avenger> addInOrderPerformer(Node<Avenger> head, Node<Avenger> av) {
	    if (head == null || av.getData().getActorCount() - (head.getData().getActorCount()) >= 0) {
	        av.setNext(head);
	        return av;
	    } else {
	        Node<Avenger> current = head;
	        while (current.getNext() != null && av.getData().getActorCount() - (current.getNext().getData().getActorCount()) < 0) {
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

	
	/**
     * Compares two Avenger nodes based on their total counts
     *
     * @param a The first Avenger node for comparison
     * @param b The second Avenger node for comparison
     * @param comparing The comparator for total counts
     * @return The result of the comparison (negative if a is less than b, positive if a is greater than b, zero if equal)
     */
	public int compare(Node<Avenger> a, Node<Avenger> b, totalCompare comparing) {
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
	public int compare(Node<Avenger> a, Node<Avenger> b, performerCompare comparing) {
		return comparing.compare(a, b);
	}
}