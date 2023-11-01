import java.util.Comparator;

public class performerCompare implements Comparator<Node<Avenger>>{

		@Override
		/**
		 * Total order:
		 * descending order of performer frequency
		 * in case of tie, in ascending order of heroName length
		 * in case of tie, in ascending alphabetical order of Alias
		 */
		public int compare(Node<Avenger> a, Node<Avenger> b) {
			int diff = a.getData().getActorCount() - b.getData().getActorCount();
			if (diff == 0) {
				diff = a.getData().getName().length() - b.getData().getName().length();
				if (diff == 0)
					return a.getData().getAlias().compareTo(b.getData().getAlias());
			}
			return diff;
		}
	}