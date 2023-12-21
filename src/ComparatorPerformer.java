import java.util.Comparator;

public class ComparatorPerformer implements Comparator <Node<Avenger>>{

	
    /**
     * Compares two Avenger objects based on performer frequency
     * 
     * @param a1 The first Avenger
     * @param a2 The second Avenger
     * @return A negative, zero, or a positive if the performer frequency of a1
     *         is less than, equal to, or greater than the performer frequency of a2
     *         If the performer frequencies are equal, it compares based on heroName length,
     *         and in case of another tie, it uses ascending alphabetical order of Alias.
     */
	@Override
	public int compare(Node<Avenger> a1, Node<Avenger> a2) {
		int diff = a2.getData().getActorCount() - a1.getData().getActorCount();
		if (diff == 0) {
			diff = a1.getData().getName().length() - a2.getData().getName().length();
			if (diff == 0) return a1.getData().getAlias().compareTo(a2.getData().getAlias());
		}
		return diff;
	}
}

