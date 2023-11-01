public class Avenger extends SLL<Avenger> implements Comparable<Avenger> {

	private String heroName;
	private String heroAlias;
	private String performer;
	private int nameFreq;
	private int aliasFreq;
	private int performerFreq;
	public String[][] avengerRoster = { { "captainamerica", "rogers", "evans" }, { "ironman", "stark", "downey" },
			{ "blackwidow", "romanoff", "johansson" }, { "hulk", "banner", "ruffalo" },
			{ "blackpanther", "tchalla", "boseman" }, { "thor", "odinson", "hemsworth" },
			{ "hawkeye", "barton", "renner" }, { "warmachine", "rhodes", "cheadle" },
			{ "spiderman", "parker", "holland" }, { "wintersoldier", "barnes", "stan" } };

	// Constructor
	public Avenger(String alias, String name, String actor) {
		this.heroName = name;
		this.heroAlias = alias;
		this.performer = actor;
		nameFreq = 0;
		aliasFreq = 0;
		performerFreq = 0;
	}

	// Default Constructor
	public Avenger() {
	}

	// Getters
	public String getName() {
		return heroName;
	}

	public String getAlias() {
		return heroAlias;
	}

	public String getActor() {
		return performer;
	}

	public int getNameCount() {
		return nameFreq;
	}

	public int getAliasCount() {
		return aliasFreq;
	}

	public int getActorCount() {
		return performerFreq;
	}

	// Incrementing the Counters
	public void incrementNameCount() {
		nameFreq++;
	}

	public void incrementAliasCount() {
		aliasFreq++;
	}

	public void incrementActorCount() {
		performerFreq++;
	}

	@Override
	public boolean equals(Object obj) { // Matching compareTo to order Alias alphabetically
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		Avenger av = (Avenger) obj;
		if (this.heroAlias.compareTo(av.getAlias()) == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Avenger a) { // Order Alias alphabetically
		int orderAlphAlias = this.heroAlias.compareTo(a.getAlias());
		return orderAlphAlias;
	}

	@Override
	public String toString() {
		return heroAlias + " aka " + heroName + " performed by " + performer + " mentioned " + "(n: " + nameFreq
				+ " + a: " + aliasFreq + " + p: " + performerFreq + ")" + " time(s)";
	}

//	public void addInOrder(SLL<Avenger> original, SLL<Avenger> target) {
//		addInOrderAlphabActor(original, target);
//	}

//	public void addInOrderAlphabActor(SLL<Avenger> original, SLL<Avenger> target) {
//	    Node<Avenger> currentNode = original.getHead();
//
//	    while (currentNode != null) {
//	        Node<Avenger> nextNode = currentNode.getNext();
//	        
//	        if (target.Empty() || target.getHead().compareTo(currentNode) >= 0) {
//	            // If the target list is empty or the original element should be inserted at the beginning
//	            currentNode.setNext(target.getHead());
//	            target.setHead(currentNode);
//	        } else {
//	            Node<Avenger> currentTargetNode = target.getHead();
//	            Node<Avenger> prevTargetNode = null;
//
//	            while (currentTargetNode != null && currentTargetNode.compareTo(currentNode) < 0) {
//	                prevTargetNode = currentTargetNode;
//	                currentTargetNode = currentTargetNode.getNext();
//	            }
//
//	            prevTargetNode.setNext(currentNode);
//	            currentNode.setNext(currentTargetNode);
//	        }
//	        
//	        original.setHead(nextNode); // Move to the next node in the original list
//	    }
//	}

	public int comparing(Node<String> n1, Node<String> n2) {
		if (n1 == null || n2 == null) {
			return 0;
		} else {
			return n1.getData().compareTo(n2.getData());
		}
	}
}
