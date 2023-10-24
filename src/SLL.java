
public class SLL<T extends Comparable<T>>{
	private T data;
	private SLL<T> next;

	public SLL(T d) {
		data = d;
		next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T o) {
		data = o;
	}

	public SLL<T> getNext() {
		return next;
	}

	public void setNext(SLL<T> n) {
		next = n;
	}

	public String toString() {
		return "Node: " + getData().toString();
	}
}
