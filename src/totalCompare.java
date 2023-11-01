import java.util.Comparator;

public class totalCompare implements Comparator<Node<Avenger>>{

		@Override
		/**
		 * Total order:
		 * descending order of total frequency 
		 * in case of tie, in ascending alphabetical order of performer's last name
		 */
		public int compare(Node<Avenger>  a, Node<Avenger> b) {
			int diff = a.getData().getTotalCount() - b.getData().getTotalCount();
			if (diff == 0) {
				return a.getData().getActor().compareTo(b.getData().getActor());
			}
			return diff;
		}
	}