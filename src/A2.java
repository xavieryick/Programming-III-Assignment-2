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
		avengersList = readInput(avengersList);
		printResults(totalWordCount, head, avengersList);
	}

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
	
	// change to return list
	public SLL<Avenger> addInOrderTotal(SLL<Avenger> printList, Node<Avenger> av) {
		if (printList.isEmpty() || av.getData().getTotalCount() > printList.getHead().getData().getTotalCount() || 
			       (av.getData().getTotalCount() == printList.getHead().getData().getTotalCount() && 
			        av.getData().getActor().compareTo(printList.getHead().getData().getActor()) <= 0)) {
			printList.addHead(av);
			    } else {
			        Node<Avenger> iterator = printList.getHead();
			        while (iterator.getNext() != null && 
			              (av.getData().getTotalCount() < iterator.getNext().getData().getTotalCount() || 
			               (av.getData().getTotalCount() == iterator.getNext().getData().getTotalCount() && 
			                av.getData().getActor().compareTo(iterator.getNext().getData().getActor()) > 0))) {
			            iterator = iterator.getNext();
			        }
			        av.setNext(iterator.getNext());
			        iterator.setNext(av);
			    }
	    return printList;
	}
	
	//change to return list
	public SLL<Avenger> addInOrderActor(SLL<Avenger> printList, Node<Avenger> av) {
	    if (printList.isEmpty() || av.getData().getActorCount() >= printList.getHead().getData().getActorCount()) {
	        printList.addHead(av);
	    } else {
	        Node<Avenger> iterator = printList.getHead();
	        while (iterator.getNext() != null && av.getData().getActorCount() < iterator.getNext().getData().getActorCount()) {
	            iterator = iterator.getNext();
	        }
	        av.setNext(iterator.getNext());
	        iterator.setNext(av);
	    }
	    return printList;
	}

	//change to return list
	public SLL<Avenger> addInOrderAlphabetical(SLL<Avenger> printList, Node<Avenger> av) {
	    if (printList.isEmpty() || av.getData().getActorCount() >= printList.getHead().getData().getActorCount()) {
	        printList.addHead(av);
	    } else {
	        Node<Avenger> iterator = printList.getHead();
	        while (iterator.getNext() != null && av.getData().getActorCount() < iterator.getNext().getData().getActorCount()) {
	            iterator = iterator.getNext();
	        }
	        av.setNext(iterator.getNext());
	        iterator.setNext(av);
	    }
	    return printList;
	}

	public int compareNextAlias(Node<Avenger> av, Node<Avenger> next) {
		return av.getData().getAlias().compareTo(next.getData().getAlias());
	}
	
	public int compareNextActor(Node<Avenger> av, Node<Avenger> next) {
		return av.getData().getActor().compareTo(next.getData().getActor());
	}
	
	// prints in order
	public void printInOrder(SLL<Avenger> list) {
		 Node<Avenger> iterator = list.getHead();
		 while (iterator != null) {
			 System.out.println(iterator.toString());
			 iterator = iterator.getNext();
		 }
	}
	
	// finds top four, prints
	public void printTopNAvengers(SLL<Avenger> list) {
	    SLL<Avenger> printList = new SLL<Avenger>();
	    Node<Avenger> iterator = list.getHead();
	    
	    while (printList.size() != list.size()) {
	        printList = addInOrderTotal(printList, iterator);
	        iterator = iterator.getNext();
	    }
	    
	    int max = topN;
	    int counter = 0;
	    Node<Avenger> printer = printList.getHead();
	    while (counter < max && printer != null) {
	        System.out.println(printer.getData().toString());
	        printer = printer.getNext();
	        counter++;
	    }
	}
	
	// finds top four, prints
	public void printTopNPerformers(SLL<Avenger> list) {
	    SLL<Avenger> printList = new SLL<Avenger>();
	    Node<Avenger> iterator = list.getHead();
	    
	    while (printList.size() != list.size()) {
	        printList = addInOrderActor(printList, iterator);
	        iterator = iterator.getNext();
	    }
	    
	    int max = topN;
	    int counter = 0;
	    Node<Avenger> printer = printList.getHead();
	    while (counter < max && printer != null) {
	        System.out.println(printer.getData().toString());
	        printer = printer.getNext();
	        counter++;
	    }
	}
	
	// sorts, prints alphabetical
	public void printAlphabetical(SLL<Avenger> list) {
	    SLL<Avenger> printList = new SLL<Avenger>();
	    Node<Avenger> iterator = list.getHead();
	    
	    while (printList.size() != list.size()) {
	        printList = addInOrderActor(printList, iterator);
	        iterator = iterator.getNext();
	    }
	    
	    Node<Avenger> printer = printList.getHead();
	    while (printer != null) {
	        System.out.println(printer.getData().toString());
	        printer = printer.getNext();
	    }
	}

	private void printResults(int totalWordCount, Node<Avenger> head, SLL<Avenger> list) {
		System.out.println("Total number of words: " + totalWordCount);
		System.out.println("Number of Avengers Mentioned: " + list.size());
		System.out.println();
		
		System.out.println("All avengers in the order they appeared in the input stream:");
		printInOrder(list);
		System.out.println();
		
		System.out.println("Top " + topN + " most popular avengers:");
		printTopNAvengers(list);		
		System.out.println();
		
		System.out.println("Top " + topN + " most popular performers:");
		printTopNPerformers(list);
		System.out.println();
		
		System.out.println("All mentioned avengers in alphabetical order:");
		printAlphabetical(list);
		System.out.println();
	}
}
