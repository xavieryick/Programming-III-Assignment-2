
public class Node<Avenger>{
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
		if (this.equals(null)){
			return "null";
		}
		else {
			return getData().toString();
		}
	}
}
