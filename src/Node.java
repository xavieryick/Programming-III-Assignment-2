
public class Node<Avenger extends Comparable<Avenger>>{
	private Avenger data;
	private Node<Avenger> next;

	public Node(Avenger d) {
		data = d;
		next = null;
	}

	public Avenger getData() {
		return data;
	}

	public void setData(Avenger o) {
		data = o;
	}

	public Node<Avenger> getNext() {
		return next;
	}

	public void setNext(Node<Avenger> n) {
		next = n;
	}

	public String toString() {
		return "Node: " + getData().toString();
	}
}
