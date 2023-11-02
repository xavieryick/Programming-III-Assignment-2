import java.util.Scanner;

public class A2 extends SLL<Avenger> {
 
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
	SLL<Avenger> avengersList2 = new SLL<>();
	SLL<Avenger> avengersList3 = new SLL<>();
	SLL<Avenger> avengersList4 = new SLL<>();
	private Node<Avenger> head; 
	private Node<Avenger> tail;
	
	int totalWordCount = 0;
	int topN = 4;
	
	public static void main(String[] args) {
		A2 manager = new A2();
		manager.run();		
	}

	public void run() {		
		head = avengersList.getHead();
		tail = avengersList.getTail();
		avengersList = readInput();
		printResults(totalWordCount, avengersList);
	}

	public SLL<Avenger> readInput() {
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

	/*
	 * Matching and incrementing each Avenger's counts
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

	// adds to given list if given avenger isnt in it
	public SLL<Avenger> checkList(SLL<Avenger> list, Node<Avenger> av) {	
		if (list.contains(av)) {
			return list;
		}
		else {
			list.addTail(av);
			return list;
		}
	}
	
	// good
	public void printInOrder(SLL<Avenger> list) {
		 Node<Avenger> iterator = list.getHead();
		 while (iterator != null) {
			 System.out.println(iterator.toString());
			 iterator = iterator.getNext();
		 }
	}
	
	//
	public Node<Avenger> printTopNAvengers(Node<Avenger> head) {
	    Node<Avenger> sortedList = null;
	    Node<Avenger> iterator = head;

	    while (iterator != null) {
	        Node<Avenger> current = iterator;
	        iterator = iterator.getNext();
	        current.setNext(null);  // Disconnect the current node from the rest of the list
	        sortedList = addInOrderTotal(sortedList, current);
	    }

	    // Print the avengers in alphabetical order
	    int printCounter = 0;
	    Node<Avenger> totalIterator = sortedList;
	    while (totalIterator != null && printCounter < topN) {
	        System.out.println(totalIterator.toString());
	        totalIterator = totalIterator.getNext();
	        printCounter ++;
	    }

	    return sortedList;  // Return the sorted list
	}
	
	// 
	public Node<Avenger> printTopNPerformers(Node<Avenger> head) {
	    Node<Avenger> sortedList = null;
	    Node<Avenger> iterator = head;

	    while (iterator != null) {
	        Node<Avenger> current = iterator;
	        iterator = iterator.getNext();
	        current.setNext(null);  // Disconnect the current node from the rest of the list
	        sortedList = addInOrderPerformer(sortedList, current);
	    }

	    // Print the avengers in alphabetical order
	    int printCounter = 0;
	    Node<Avenger> performerIterator = sortedList;
	    while (performerIterator != null && printCounter < topN) {
	        System.out.println(performerIterator.toString());
	        performerIterator = performerIterator.getNext();
	        printCounter ++;
	    }

	    return sortedList;  // Return the sorted list
	}
	
	// good
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

	private SLL<Avenger> copy(SLL<Avenger> list) {
		SLL<Avenger> copiedList = new SLL<Avenger>();
		Node<Avenger> current = list.getHead();
		
		while (current != null) {
			Node<Avenger> nodeToAdd = new Node<Avenger>(current.getData());
			copiedList.addTail(nodeToAdd);
			current = current.getNext();
		}
		return copiedList;
	}
	
	private void printResults(int totalWordCount, SLL<Avenger> list) {
		SLL<Avenger> list2 = copy(list);
		SLL<Avenger> list3 = copy(list);
		SLL<Avenger> list4 = copy(list);
		
		System.out.println("Total number of words: " + totalWordCount);
		System.out.println("Number of Avengers Mentioned: " + list.size());
		System.out.println();
		
		System.out.println("All avengers in the order they appeared in the input stream:");
		printInOrder(list);
		System.out.println();
		
		System.out.println("Top " + topN + " most popular avengers:");
		printTopNAvengers(list2.getHead());
		System.out.println();

		System.out.println("Top " + topN + " most popular performers:");
		printTopNPerformers(list3.getHead());
		System.out.println();
		
		System.out.println("All mentioned avengers in alphabetical order:");
		printAlphabetical(list4.getHead());
		System.out.println();
	}
}
