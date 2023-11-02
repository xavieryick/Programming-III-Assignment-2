/**
 * The Avenger class represents Avengers
 * contains information about the Avenger hero name, alias, performer (actor), and frequency counts
 * for their mentions
 */
public class Avenger {
    private String heroName;
    private String heroAlias;
    private String performer;
    private int nameFreq;
    private int aliasFreq;
    private int performerFreq;

    /**
     * Constructs an Avenger object with the provided alias, name, and actor information
     * Initializes the frequency counters to zero.
     *
     * @param alias     The hero's alias or code name
     * @param name      The hero's real or hero name
     * @param actor     The actor who portrayed the hero
     */
    public Avenger(String alias, String name, String actor) {
        this.heroName = name;
        this.heroAlias = alias;
        this.performer = actor;
        this.nameFreq = 0;
        this.aliasFreq = 0;
        this.performerFreq = 0;
    }

    /**
     * Gets the hero's real or hero name
     *
     * @return The hero's name
     */
    public String getName() {
        return this.heroName;
    }

    /**
     * Gets the hero's alias or code name
     *
     * @return The hero's alias
     */
    public String getAlias() {
        return this.heroAlias;
    }

    /**
     * Gets the actor who portrayed the hero
     *
     * @return The actor's name
     */
    public String getActor() {
        return this.performer;
    }

    /**
     * Gets the frequency count of the hero's name mentions
     *
     * @return The name frequency count
     */
    public int getNameCount() {
        return this.nameFreq;
    }

    /**
     * Gets the frequency count of the hero's alias mentions
     *
     * @return The alias frequency count
     */
    public int getAliasCount() {
        return this.aliasFreq;
    }

    /**
     * Gets the frequency count of the hero's performer (actor) mentions
     *
     * @return The performer frequency count
     */
    public int getActorCount() {
        return this.performerFreq;
    }

    /**
     * Calculates and returns the total frequency count of all mentions (name, alias, and actor) for the hero
     *
     * @return The total mention frequency count
     */
    public int getTotalCount() {
        int total = this.getNameCount() + this.getAliasCount() + this.getActorCount();
        return total;
    }

    /**
     * Increments the frequency counter for the hero's name mentions
     */
    public void incrementNameCount() {
        this.nameFreq++;
    }

    /**
     * Increments the frequency counter for the hero's alias mentions
     */
    public void incrementAliasCount() {
        this.aliasFreq++;
    }

    /**
     * Increments the frequency counter for the hero's performer (actor) mentions
     */
    public void incrementActorCount() {
        this.performerFreq++;
    }

    /**
     * Checks if this Avenger object is equal to another object. Two `Avenger` objects are considered equal
     * if their hero aliases are the same
     *
     * @param obj The object to compare with this Avenger
     * @return True if the objects are equal (hero aliases match), false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Avenger av = (Avenger) obj;
        return this.heroAlias.equals(av.getAlias());
    }

    /**
     * Compares this Avenger object to another Avenger object based on their hero aliases, ordering them
     * alphabetically
     *
     * @param a The Avenger object to compare with this Avenger
     * @return A negative value if this `Avenger` comes before the other, a positive value if it comes after,
     * or zero if they have the same hero alias.
     */
    public int compareTo(Avenger a) {
        return this.heroAlias.compareTo(a.getAlias());
    }

    /**
     * Returns a string representation of this Avenger object
     *
     * @return A  string representation of the Avenger object
     */
    @Override
    public String toString() {
        return heroAlias + " aka " + heroName
                + " performed by " + performer
                + " mentioned "
                + "(n: " + nameFreq
                + " + a: " + aliasFreq
                + " + p: " + performerFreq
                + ")" + " time(s)";
    }
}
