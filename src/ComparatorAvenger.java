import java.util.Comparator;

public class ComparatorAvenger implements Comparator <Node<Avenger>>{

	
	/**
	 * Compares two Avenger objects based on their total counts.
	 * 
	 * @param a1 The first Avenger 
	 * @param a2 The second Avenger
	 * @return A negative, zero, or positive if the total count of a1
	 *         is less than, equal to, or greater than the total count of a2.
	 *         If the total counts are equal it compares based on the performers name.
	 */
	@Override
	public int compare(Node<Avenger> a1, Node<Avenger> a2) {
		int diff = a2.getData().getTotalCount() - a1.getData().getTotalCount();
		if (diff == 0) return a1.getData().getActor().compareTo(a2.getData().getActor());
		return diff;
	}
}

