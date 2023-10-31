import java.util.ArrayList;
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
	public void addInOrderTotal(Node<Avenger> head, Node<Avenger> av) {
		// check if 0
		if (head == null) {
			head = av;
		}
		// check if 1
		else if (head.getNext() == null) {
			int headTotal = head.getData().getTotalCount();
			int avTotal = av.getData().getTotalCount();
			
			// av count > head count
			if (avTotal > headTotal) {
				head = av;
			}
			// av count < head count
			else if (avTotal < headTotal) {
				tail = av;
			}
			// av count == head count
			else {
				// if avActor > headActor
				if (av.getData().compareTo(head.getData()) > 0) {
					head = av;
				}
				// if avActor < headActor
				else if (av.getData().compareTo(head.getData()) < 0) {
					tail = av;
				}
			}
		}
		else {
			Node<Avenger> iterator = head;
			Node<Avenger> next = iterator.getNext();
			Node<Avenger> nextNext = iterator.getNext().getNext();
			int resultNext = iterator.getData().getTotalCount() - next.getData().getTotalCount();
			int resultNextNext = iterator.getData().getTotalCount() - nextNext.getData().getTotalCount();
			
			while ((resultNext > 0 && resultNextNext > 0) || (resultNext < 0 && resultNextNext < 0) || (resultNext < 0 && resultNextNext > 0)) {
				iterator = iterator.getNext();
				next = next.getNext();
				nextNext = nextNext.getNext();
				resultNext = iterator.getData().getTotalCount() - next.getData().getTotalCount();
				resultNextNext = iterator.getData().getTotalCount() - nextNext.getData().getTotalCount();
			}
			next.setNext(iterator);
			iterator.setNext(nextNext);
		}
	}
	
	//change to return list
	public void addInOrderActor(Node<Avenger> head, Node<Avenger> av) {
		// check if 0
		if (head == null) {
			head = av;
		}
		// check if 1
		else if (head.getNext() == null) {
			int headActor = head.getData().getActorCount();
			int avActor = av.getData().getActorCount();
			
			// av count > head count
			if (avActor > headActor) {
				head = av;
			}
			// av count < head count
			else if (avActor < headActor) {
				tail = av;
			}
			// av count == head count
			else {
				// if avActor > headActor
				if (av.getData().compareTo(head.getData()) > 0) {
					head = av;
				}
				// if avActor < headActor
				else if (av.getData().compareTo(head.getData()) < 0) {
					tail = av;
				}
			}
		}
		else {
			Node<Avenger> iterator = head;
			Node<Avenger> next = iterator.getNext();
			Node<Avenger> nextNext = iterator.getNext().getNext();
			int resultNext = compareNextActor(iterator, next);
			int resultNextNext = compareNextActor(iterator, nextNext);
			
			while ((resultNext > 0 && resultNextNext > 0) || (resultNext < 0 && resultNextNext < 0) || (resultNext < 0 && resultNextNext > 0)) {
				iterator = iterator.getNext();
				next = next.getNext();
				nextNext = nextNext.getNext();
				resultNext = compareNextActor(iterator, next);
				resultNextNext = compareNextActor(iterator, nextNext);
			}
			next.setNext(iterator);
			iterator.setNext(nextNext);
		}
	}

	//change to return list
	public void addInOrderAlphabetical(Node<Avenger> head, Node<Avenger> av) {
		// check if 0
		if (head == null) {
			head = av;
		}
		// check if 1
		else if (head.getNext() == null) {
			// av > head
			if (av.getData().getAlias().compareTo(head.getData().getActor()) > 0) {
				head = av;
			}
			// av < head
			else if (av.getData().getAlias().compareTo(head.getData().getActor()) < 0) {
				tail = av;
			}
		}
		else {
			Node<Avenger> iterator = head;
			Node<Avenger> next = iterator.getNext();
			Node<Avenger> nextNext = iterator.getNext().getNext();
			int resultNext = compareNextAlias(iterator, next);
			int resultNextNext = compareNextAlias(iterator, nextNext);
			
			while ((resultNext > 0 && resultNextNext > 0) || (resultNext < 0 && resultNextNext < 0) || (resultNext < 0 && resultNextNext > 0)) {
				iterator = iterator.getNext();
				next = next.getNext();
				nextNext = nextNext.getNext();
				resultNext = compareNextAlias(iterator, next);
				resultNextNext = compareNextAlias(iterator, nextNext);
			}
			next.setNext(iterator);
			iterator.setNext(nextNext);
		}
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
		 
		 // ok current code doesnt trigger this!
		 if (iterator == null) {
			 System.out.println("Error");
		 }
		 else {
			 while (iterator != null) {
				 System.out.println(iterator.toString());
				 iterator = iterator.getNext();
			 }
		 }
	}
	
	// finds top four, prints
	public void printTopNAvengers(SLL<Avenger> list) {
		Node<Avenger> iterator = list.getHead();
//		SLL<Avenger> list2 = new SLL<>();
		// iterates through totalList, adds everything to list in order
		if (iterator == null ) {
			System.out.println("Error");
		}
		else {
			while (iterator.getNext() != null) {
				addInOrderTotal(head, iterator);
				iterator = iterator.getNext();
			}
			
			Node<Avenger> printer = head;
			// zero
			if (printer == null ) {
				System.out.println("List is empty");
			}
			// one
			else if (printer.getNext() == null) {
				System.out.println(printer.toString());
			}
			// two
			else if (printer.getNext().getNext() == null) {
				for (int counter = 0; counter < 2; counter++) {
					System.out.println(printer.toString());
					printer = printer.getNext();
				}
			}
			// three
			else if (printer.getNext().getNext().getNext() == null) {
				for (int counter = 0; counter < 3; counter++) {
					System.out.println(printer.toString());
					printer = printer.getNext();
				}
			}
			// four+
			else {
				for (int counter = 0; counter < topN; counter++) {
					System.out.println(printer.toString());
					printer = printer.getNext();
				}
			}
		}
	}
	
	// finds top four, prints
	public void printTopNPerformers(Node<Avenger> head) {
		Node<Avenger> iterator = head;
		SLL<Avenger> list = new SLL<>();
		// iterates through totalList, adds everything to list in order
		 if (iterator == null ) {
			 System.out.println("Error");
		 }
		 else {
			while (iterator.getNext() != null) {
				addInOrderActor(head, iterator);
				iterator = iterator.getNext();
			}
			
			Node<Avenger> printer = head;
			// zero
			if (printer == null ) {
				System.out.println("List is empty");
			}
			// one
			else if (printer.getNext() == null) {
				System.out.println(printer.toString());
			}
			// two
			else if (printer.getNext().getNext() == null) {
				for (int counter = 0; counter < 2; counter++) {
					System.out.println(printer.toString());
					printer = printer.getNext();
				}
			}
			// three
			else if (printer.getNext().getNext().getNext() == null) {
				for (int counter = 0; counter < 3; counter++) {
					System.out.println(printer.toString());
					printer = printer.getNext();
				}
			}
			// four+
			else {
				for (int counter = 0; counter < topN; counter++) {
					System.out.println(printer.toString());
					printer = printer.getNext();
				}
			}
		}
	}
	
	// sorts, prints alphabetical
	public void printAlphabetical(Node<Avenger> head) {
		Node<Avenger> iterator = head;
		SLL<Avenger> list = new SLL<>();
		// iterates through totalList, adds everything to list in order
		 if (iterator == null ) {
			 System.out.println("Error");
		 }
		 else {
			while (iterator.getNext() != null) {
				addInOrderActor(head, iterator);
				iterator = iterator.getNext();
			}
			while (iterator.getNext() != null) {
				System.out.println(iterator.toString());
			}
		 }
	}

	private void printResults(int totalWordCount, Node<Avenger> head, SLL<Avenger> list) {
		System.out.println(totalWordCount);
		System.out.println(list.size());
		printInOrder(list);
//		printTopNAvengers(list);
//		printTopNPerformers(head);
//		printAlphabetical(head);
	}
}
