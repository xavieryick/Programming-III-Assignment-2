import java.util.Scanner;

public class A2 extends SLL {
 
	public String[][] avengerRoster = { { "captainamerica", "rogers", "evans" }, { "ironman", "stark", "downey" },
			{ "blackwidow", "romanoff", "johansson" }, { "hulk", "banner", "ruffalo" },
			{ "blackpanther", "tchalla", "boseman" }, { "thor", "odinson", "hemsworth" },
			{ "hawkeye", "barton", "renner" }, { "warmachine", "rhodes", "cheadle" },
			{ "spiderman", "parker", "holland" }, { "wintersoldier", "barnes", "stan" } };
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
	
	// Avenger objects
	private Node<Avenger> captainAmericaNode = new Node<Avenger>(cptAmerica);
	private Node<Avenger> ironManNode = new Node<Avenger>(ironMan);
	private Node<Avenger> blackWidowNode = new Node<Avenger>(blackWidow);
	private Node<Avenger> hulkNode = new Node<Avenger>(hulk);
	private Node<Avenger> blackPanNode = new Node<Avenger>(blackPan);
	private Node<Avenger> thorNode = new Node<Avenger>(thor);
	private Node<Avenger> hawkEyeNode = new Node<Avenger>(hawkEye);
	private Node<Avenger> warMachineNode = new Node<Avenger>(warMachine);
	private Node<Avenger> spiderManNode = new Node<Avenger>(spiderMan);
	private Node<Avenger> winterSoldierNode = new Node<Avenger>(winterSoldier);

	SLL<Avenger> avengersList = new SLL<>();
	private Node<Avenger> head; 
	private Node<Avenger> tail;
	
	int totalWordCount = 0;
	int topN = 4;
	
	/**
	 * Creates an instance of the A2 class and starts processing of input text
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		A2 manager = new A2();
		manager.run();		
	}

	/**
	 * Runs the programs processing the input text and printing the results
	 * 
	 */
	public void run() {		
		head = avengersList.getHead();
		tail = avengersList.getTail();
		avengersList = readInput(avengersList);
		printResults2(totalWordCount, head, avengersList);
	}
	
	/**
	 * read the input of the text file and cleans each word
	 * 
	 * @param avengersList
	 * @return
	 */
	public SLL<Avenger> readInput(SLL<Avenger> avengersList) {
	    Scanner input = new Scanner(System.in);
	    while (input.hasNext()) {
	        String word = input.next();
	        word = word.trim().toLowerCase().split("'")[0].replaceAll("[^\\\\sa-zA-Z]", "");
	        if (word.length() != 0) {
	            totalWordCount++;
	            avengersList = matchIncrement(word, avengersList);
	        }
	    }
	    input.close();
	    return avengersList;
	}

	/**
	 * matches and increments each Avenger's counts
	 * 
	 * @param word
	 * @param list
	 * @return
	 */
	public SLL<Avenger> matchIncrement(String word, SLL<Avenger> list) {	
		if (word.equals(avengerRoster[0][0]) || word.equals(avengerRoster[0][1]) || word.equals(avengerRoster[0][2])) {
			list = checkList(list, captainAmericaNode);
			if (avengerRoster[0][0].equals(word)) {
				captainAmericaNode.getData().incrementAliasCount();
			}
			else if (avengerRoster[0][1].equals(word)) {
				captainAmericaNode.getData().incrementNameCount();
			}
			else {
				captainAmericaNode.getData().incrementActorCount();
			}
		}
		else if (word.equals(avengerRoster[1][0]) || word.equals(avengerRoster[1][1]) || word.equals(avengerRoster[1][2])) {
			list = checkList(list, ironManNode);
			if (avengerRoster[1][0].equals(word)) {
				ironManNode.getData().incrementAliasCount();
			}
			else if (avengerRoster[1][1].equals(word)) {
				ironManNode.getData().incrementNameCount();
			}
			else {
				ironManNode.getData().incrementActorCount();
			}
		}
		else if (word.equals(avengerRoster[2][0]) || word.equals(avengerRoster[2][1]) || word.equals(avengerRoster[2][2])) {
			list = checkList(list, blackWidowNode);
			if (avengerRoster[2][0].equals(word)) {
				blackWidowNode.getData().incrementAliasCount();
			}
			else if (avengerRoster[2][1].equals(word)) {
				blackWidowNode.getData().incrementNameCount();
			}
			else {
				blackWidowNode.getData().incrementActorCount();
			}
		}
		else if (word.equals(avengerRoster[3][0]) || word.equals(avengerRoster[3][1]) || word.equals(avengerRoster[3][2])) {
			list = checkList(list, hulkNode);
			if (avengerRoster[3][0].equals(word)) {
				hulkNode.getData().incrementAliasCount();
			}
			else if (avengerRoster[3][1].equals(word)) {
				hulkNode.getData().incrementNameCount();
			}
			else {
				hulkNode.getData().incrementActorCount();
			}
		}
		else if (word.equals(avengerRoster[4][0]) || word.equals(avengerRoster[4][1]) || word.equals(avengerRoster[4][2])) {
			list = checkList(list, blackPanNode);
			if (avengerRoster[4][0].equals(word)) {
				blackPanNode.getData().incrementAliasCount();
			}
			else if (avengerRoster[4][1].equals(word)) {
				blackPanNode.getData().incrementNameCount();
			}
			else {
				blackPanNode.getData().incrementActorCount();
			}
		}
		else if (word.equals(avengerRoster[5][0]) || word.equals(avengerRoster[5][1]) || word.equals(avengerRoster[5][2])) {
			list = checkList(list, thorNode);
			if (avengerRoster[5][0].equals(word)) {
				thorNode.getData().incrementAliasCount();
			}
			else if (avengerRoster[5][1].equals(word)) {
				thorNode.getData().incrementNameCount();
			}
			else {
				thorNode.getData().incrementActorCount();
			}
		}
		else if (word.equals(avengerRoster[6][0]) || word.equals(avengerRoster[6][1]) || word.equals(avengerRoster[6][2])) {
			list = checkList(list, hawkEyeNode);
			if (avengerRoster[6][0].equals(word)) {
				hawkEyeNode.getData().incrementAliasCount();
			}
			else if (avengerRoster[6][1].equals(word)) {
				hawkEyeNode.getData().incrementNameCount();
			}
			else {
				hawkEyeNode.getData().incrementActorCount();
			}
		}
		else if (word.equals(avengerRoster[7][0]) || word.equals(avengerRoster[7][1]) || word.equals(avengerRoster[7][2])) {
			list = checkList(list, warMachineNode);
			if (avengerRoster[7][0].equals(word)) {
				warMachineNode.getData().incrementAliasCount();
			}
			else if (avengerRoster[7][1].equals(word)) {
				warMachineNode.getData().incrementNameCount();
			}
			else {
				warMachineNode.getData().incrementActorCount();
			}
		}
		else if (word.equals(avengerRoster[8][0]) || word.equals(avengerRoster[8][1]) || word.equals(avengerRoster[8][2])) {
			list = checkList(list, spiderManNode);
			if (avengerRoster[8][0].equals(word)) {
				spiderManNode.getData().incrementAliasCount();
			}
			else if (avengerRoster[8][1].equals(word)) {
				spiderManNode.getData().incrementNameCount();
			}
			else {
				spiderManNode.getData().incrementActorCount();
			}
		}
		else if (word.equals(avengerRoster[9][0]) || word.equals(avengerRoster[9][1]) || word.equals(avengerRoster[9][2])) {
			list = checkList(list, winterSoldierNode);
			if (avengerRoster[9][0].equals(word)) {
				winterSoldierNode.getData().incrementAliasCount();
			}
			else if (avengerRoster[9][1].equals(word)) {
				winterSoldierNode.getData().incrementNameCount();
			}
			else {
				winterSoldierNode.getData().incrementActorCount();
			}
		}
		else {
			return list;
		}
		return list;
	}


	/**
	 * Checks if a given Avenger node is present in the linked list and adds it to the list if not found.
	 *
	 * @param list The linked list of Avengers to check
	 * @param av The Avenger node to be checked and added
	 * @return The modified linked list with the Avenger node added if wasn't present
	 */
	public SLL<Avenger> checkList(SLL<Avenger> list, Node<Avenger> av) {	
		if (list.contains(av)) {
			return list;
		}
		else {
			list.addTail(av);
			return list;
		}
	}
	
	/**
	 * Prints the results of the avengers list by the order appeared, most popular avengers,
	 * most popular performers, and alphabetical mentions
	 * 
	 * @param totalWordCount
	 * @param head
	 * @param list
	 */
	private void printResults2(int totalWordCount, Node<Avenger> head, SLL<Avenger> list) {
	    System.out.println("Total number of words: " + totalWordCount);
	    System.out.println("Number of Avengers Mentioned: " + list.size());
	    System.out.println();

	    System.out.println("All avengers in the order they appeared in the input stream:");
	    Node<Avenger> iterator = list.getHead();
	    while (iterator != null) {
	        System.out.println(iterator.toString());
	        iterator = iterator.getNext();
	    }
	    System.out.println();

	    System.out.println("Top 4 most popular avengers:");
	    printTopNAvengers(list);
	    System.out.println();

	    System.out.println("Top 4 most popular performers:");
	    printTopNPerformers(list);
	    System.out.println();

	    System.out.println("All mentioned avengers in alphabetical order:");
	    printAlphabetical(list.getHead()); // Print alphabetical list
	    System.out.println();
	}

	/**
	 * Inserts an Avenger node into a linked list of Avengers, ordered by their actor count
	 *
	 * @param list The linked list of Avengers where the node should be inserted
	 * @param av The Avenger node to be inserted into the list
	 * @return The modified linked list with the Avenger node added in the correct position
	 */
	public SLL<Avenger> addInOrderActorCount(SLL<Avenger> list, Node<Avenger> av) {
	    Node<Avenger> current = list.getHead();
	    Node<Avenger> previous = null;

	    while (current != null && av.getData().getActorCount() <= current.getData().getActorCount()) {
	        previous = current;
	        current = current.getNext();
	    }

	    if (previous == null) {
	        av.setNext(list.getHead());
	        list.setHead(av);
	    } else {
	        previous.setNext(av);
	        av.setNext(current);
	    }

	    return list;
	}
	
	/**
	 * Sorts a linked list of Avengers by their actor count in ascending order
	 *
	 * @param list The linked list of Avengers to be sorted
	 * @return A new linked list with Avengers sorted by actor count in ascending order
	 */
	public SLL<Avenger> sortAvengersByActorCount(SLL<Avenger> list) {
	    SLL<Avenger> sortedList = new SLL<>();
	    Node<Avenger> iterator = list.getHead();

	    while (iterator != null) {
	        Node<Avenger> current = iterator;
	        iterator = iterator.getNext();
	        current.setNext(null);  // Disconnect the current node from the rest of the list
	        sortedList = addInOrderActorCount(sortedList, current);
	    }

	    return sortedList;  // Return the sorted list
	}

	/**
	 * Inserts an Avenger node into a linked list of Avengers in alphabetical order of their aliases
	 *
	 * @param head The head of the linked list where the node should be inserted
	 * @param av The Avenger node to be inserted into the list
	 * @return The modified linked list with the Avenger node added in the correct alphabetical position
	 */
	public Node<Avenger> addInOrderAlphabetical(Node<Avenger> head, Node<Avenger> av) {
	    if (head == null || av.getData().getAlias().compareTo(head.getData().getAlias()) <= 0) {
	        av.setNext(head);
	        return av;
	    } else {
	        Node<Avenger> current = head;
	        while (current.getNext() != null && av.getData().getAlias().compareTo(current.getNext().getData().getAlias()) > 0) {
	            current = current.getNext();
	        }
	        av.setNext(current.getNext());
	        current.setNext(av);
	        return head;
	    }
	}

	/**
	 * Prints the topN most popular Avengers based on the order they appear in the list
	 *
	 * @param list The linked list of Avengers to be printed
	 */
	public void printTopNAvengers(SLL<Avenger> list) {
	    Node<Avenger> iterator = list.getHead();
	    int printCount = 0;

	    while (iterator != null && printCount < topN) {
	        System.out.println(iterator.toString());
	        iterator = iterator.getNext();
	        printCount++;
	    }
	}

	/**
	 * Prints the topN most popular Avengers based on the actor count in ascending order
	 *
	 * @param list The linked list of Avengers to be printed
	 */
	public void printTopNPerformers(SLL<Avenger> list) {
	    SLL<Avenger> sortedList = sortAvengersByActorCount(list);
	    
	    Node<Avenger> iterator = sortedList.getHead();
	    int printCount = 0;

	    while (iterator != null && printCount < topN) {
	        System.out.println(iterator.toString());
	        iterator = iterator.getNext();
	        printCount++;
	    }
	}

	/**
	 * Prints all the Avengers in the linked list in alphabetical order of their aliases
	 *
	 * @param head The head of the linked list to be printed alphabetically
	 * @return The head of the linked list after printing
	 */
	public Node<Avenger> printAlphabetical(Node<Avenger> head) {
	    Node<Avenger> sortedList = null;
	    Node<Avenger> iterator = head;

	    while (iterator != null) {
	        Node<Avenger> current = iterator;
	        iterator = iterator.getNext();
	        current.setNext(null);  // Disconnect the current node from the rest of the list
	        sortedList = addInOrderAlphabetical(sortedList, current);
	    }

	    // Print the avengers in alphabetical order
	    Node<Avenger> alphabeticalIterator = sortedList;
	    while (alphabeticalIterator != null) {
	        System.out.println(alphabeticalIterator.toString());
	        alphabeticalIterator = alphabeticalIterator.getNext();
	    }

	    return sortedList;  // Return the sorted list
	}

}