/**
 * The Node class represents a node in a singly linked list containing Avenger data types
 *
 * @param <T> The data type held by the node (Avenger)
 */
public class Node<T>{
	private Avenger data;
	private Node<Avenger> next;

	/**
     * Constructs a Node object with the provided data and initializes the next node reference to null
     *
     * @param d The Avenger data to be stored in the node.
     */
	public Node(Avenger d) {
		data = d;
		next = null;
	}

	/**
     * Gets the data stored in the node
     *
     * @return The Avenger data.
     */
	public Avenger getData() {
		return data;
	}

	/**
     * Sets the data for the node
     *
     * @param o The Avenger data to be set
     */
	public void setData(Avenger o) {
		data = o;
	}

	/**
     * Gets the reference to the next node in the linked list
     *
     * @return The reference to the next node
     */
	public Node<Avenger> getNext() {
		return next;
	}

	/**
     * Sets the reference to the next node in the linked list
     *
     * @param n The next node to be linked
     */
	public void setNext(Node<Avenger> n) {
		next = n;
	}

	/**
     * Returns a string representation of the Node object. If the node is null, it returns null
     * 
     *
     * @return A string representation of the `Node` or "null" if the node is null.
     */
	public String toString() {
		if (this.equals(null)){
			return "null";
		}
		else {
			return getData().toString();
		}
	}
}
