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
		nameFreq= 0;
		aliasFreq = 0;
		performerFreq = 0;
	}
	//Default Constructor
	public Avenger() {}

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
	//Incrementing the Counters
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
	public boolean equals(Object obj) {		//Matching compareTo to order Alias alphabetically
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
	public int compareTo(Avenger a) {		//Order Alias alphabetically
		int orderAlphAlias = this.heroAlias.compareTo(a.getAlias());
		return orderAlphAlias;
	}
	@Override
	public String toString() {
		return  heroAlias + " aka " + heroName
				+ " performed by " + performer
				+ " mentioned "
				+ "(n: " + nameFreq
				+ " + a: " + aliasFreq
				+ " + p: " + performerFreq
				+ ")" + " time(s)";
	}
	public void addToOrder(SLL<Avenger> list) {
		addInOrder(list);
	}

	private void addInOrder(SLL<Avenger> list) {
		// implement addInOrde
		n.setNext(null);
		if (Empty() || compareTo(n, list.getHead()) <= 0) {
			addHead(n);
		} else if (comparing(n, tail) >= 0) {
			addTail(n);
		} else if (comparing(n, head) > 0) {
			Node<String> curr = head;
			while (curr.getNext() != null && comparing(n, curr.getNext()) > 0) {
				curr = curr.getNext();
			}
			n.setNext(curr.getNext());
			curr.setNext(n);
			;
		}
	}
}