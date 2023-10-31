import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class A2 extends Avenger {

	private int topN = 4;
	public int totalwordCount;
	public Avenger head;
	public Avenger tail;
	// Avenger references
	private Avenger cptAmerica = new Avenger(avengerRoster[0][0], avengerRoster[0][1], avengerRoster[0][2]);
	private Avenger ironMan = new Avenger(avengerRoster[1][0], avengerRoster[1][1], avengerRoster[1][2]);
	private Avenger blackWidow = new Avenger(avengerRoster[2][0], avengerRoster[2][1], avengerRoster[2][2]);
	private Avenger hulk = new Avenger(avengerRoster[3][0], avengerRoster[3][1], avengerRoster[3][2]);
	private Avenger blackPan = new Avenger(avengerRoster[4][0], avengerRoster[4][1], avengerRoster[4][2]);
	private Avenger thor = new Avenger(avengerRoster[5][0], avengerRoster[5][1], avengerRoster[5][2]);
	private Avenger hawkEye = new Avenger(avengerRoster[6][0], avengerRoster[6][1], avengerRoster[6][2]);
	private Avenger warMachine = new Avenger(avengerRoster[7][0], avengerRoster[7][1], avengerRoster[7][2]);
	private Avenger spiderMan = new Avenger(avengerRoster[8][0], avengerRoster[8][1], avengerRoster[8][2]);
	private Avenger winterSoldier = new Avenger(avengerRoster[9][0], avengerRoster[9][1], avengerRoster[9][2]);
	Avenger[] possibleAvengers = { cptAmerica, ironMan, blackWidow, hulk, blackPan, thor, hawkEye, warMachine,
			spiderMan, winterSoldier };
	SLL<Avenger> avengersByMentions = new SLL<>();
	SLL<Avenger> mostPopularAvengers = new SLL<>();
	SLL<Avenger> mostPopularPerformers = new SLL<>();
	SLL<Avenger> alphabeticalOrderList = new SLL<>();

	public static void main(String[] args) {
		A2 manager = new A2();
		manager.run();
	}

	public void run() {
		readInput();
		printResults();
		
	}

	// Constructor
	public A2(String alias, String name, String actor) {
		super(alias, name, actor);
	}

	public A2() {
	}

	public void readInput() {
		// only has totalWordCount, not avenger count, can iterate through avenger SLL
		// to find this
		Scanner input = new Scanner(System.in);
		totalwordCount = 0;
		while (input.hasNext()) {
			String word = input.next();
			word = word.trim().toLowerCase().split("'")[0].replaceAll("[^\\\\sa-zA-Z]", "");
			if (word.length() != 0) {
				totalwordCount++;
			}
		}
		input.close();
	}

	/*
	 * Matching and incrementing each Avenger's counts
	 */
	public void matchIncrement(String word, Avenger[] avenger) {
		for (int i = 0; i < avenger.length; i++) {
			if (word.equals(avenger[i].getAlias())) {
				avenger[i].incrementAliasCount();
				checkListForMentions(avenger[i]);
				return;
			} else if (word.equals(avenger[i].getName())) {
				avenger[i].incrementNameCount();
				checkListForMentions(avenger[i]);
				return;
			} else if (word.equals(avenger[i].getActor())) {
				avenger[i].incrementActorCount();
				checkListForMentions(avenger[i]);
				return;
			}
		}
	}

	/*
	 * Checks if an avenger mentioned is found in the avengersList If not add the
	 * avenger to the avengerList
	 */
	public void checkListForMentions(Avenger a) {
		if(avengersByMentions == null) {
			addHead(a);
		}else if(exist(a) == true){
			return;
		}else {
			addTail(a);
		}
	}
	
	public void printResults() {
		System.out.println("Total number of words: " + totalwordCount);
		System.out.println("Number of Avengers Mentioned: " + avengersByMentions.size());
		System.out.println();
		
		// Print all Avengers ordered by appearance
		System.out.println("All avengers in the order they appeared in the input stream:");
		printList(avengersByMentions);
		System.out.println();
		
		System.out.println("Top " + topN + " most popular avengers:"); // Order by most popular Avengers
		Collections.sort(av, new Comparator<Avenger>() {
			@Override
			public int compare(Avenger a, Avenger b) {
				int totCountDiff = (b.getActorCount() + b.getAliasCount() + b.getNameCount()) // Desc. by total mentions
						- (a.getActorCount() + a.getAliasCount() + a.getNameCount());
				int nameDiff = a.getActor().compareTo(b.getActor()); // Asc. alphabetical order of Actor/Performer
				// Breaking Ties
				if (totCountDiff == 0) {
					return nameDiff;
				} else {
					return totCountDiff;
				}
			}
		});
		printingTopN(av);
		System.out.println();

		
		System.out.println("Top " + topN + " most popular performers:");
		Collections.sort(av, new Comparator<Avenger>() { // Order by most popular performers/actors
			@Override
			public int compare(Avenger a, Avenger b) {
				int actCountdiff = b.getActorCount() - a.getActorCount(); // Descending Actor mentions
				int lengDiff = a.getName().length() - b.getName().length(); // Ascending of name's length
				int aliasDiff = a.getAlias().compareTo(b.getAlias()); // Ascending alphabetical order of Alias
				// Breaking Ties
				if (actCountdiff == 0) {
					if (lengDiff == 0) {
						return aliasDiff;
					} else {
						return lengDiff;
					}
				} else {
					return actCountdiff;
				}
			}
		});
		printingTopN(av);
		System.out.println();
		
		// Print all ordered by alias alphabetically
		System.out.println("All mentioned avengers in alphabetical order:"); 
		alphabeticaListing(avengersByMentions);
		printList(alphabeticalOrderList);
		System.out.println();
	}
	
	/**
	 * 
	 */
	public void alphabeticaListing(SLL<Avenger> list) {
		SLL<Avenger> curr = list;
		SLL<Avenger> curr2 = alphabeticalOrderList;
		for(int i = 0; i < curr.size(); i++) {
			if(curr != null) {
				curr2.addHead(curr.get(i));
			}
		}
	}
	
	/**
	 * 
	 */
	public void printList(SLL<Avenger> linkedList) {
		SLL<Avenger> curr = linkedList;
		for(int i = 0; i < curr.size(); i++) {
			curr.get(i).toString();
		}
	}
	
	/**
	 * Print TopN based on the size of the list of avengers mentioned
	 * @param av List of mentioned Avengers
	 */
	public void printingTopN(SLL<Avenger> av) {
		if (av.size() >= topN) {
			for (int i = 0; i < topN; i++) {
				System.out.println(av.get(i).toString());
			}
		} else {
			for (int i = 0; i < av.size(); i++) {
				System.out.println(av.get(i).toString());
			}
		}
	}
}
