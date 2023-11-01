public class Avenger {

	private String heroName;
	private String heroAlias;
	private String performer;
	private int nameFreq;
	private int aliasFreq;
	private int performerFreq;

	// Constructor
	public Avenger(String alias, String name, String actor) {
		this.heroName = name;
		this.heroAlias = alias;
		this.performer = actor;
		this.nameFreq= 0;
		this.aliasFreq = 0;
		this.performerFreq = 0;
	}

	// Getters
	public String getName() {
		return this.heroName;
	}

	public String getAlias() {
		return this.heroAlias;
	}

	public String getActor() {
		return this.performer;
	}
	public int getNameCount() {
		return this.nameFreq;
	}

	public int getAliasCount() {
		return this.aliasFreq;
	}

	public int getActorCount() {
		return this.performerFreq;
	}
	
	public int getTotalCount() {
		int total = this.getNameCount() + this.getAliasCount() + this.getActorCount();
		return total;
	}
	
	//Incrementing the Counters
	public void incrementNameCount() {
		this.nameFreq++;
	}

	public void incrementAliasCount() {
		this.aliasFreq++;
	}

	public void incrementActorCount() {
		this.performerFreq++;
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

	public int compareTo(Avenger a) {
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
}