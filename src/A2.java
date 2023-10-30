import java.util.ArrayList;
import java.util.Scanner;

public class A2 extends SLL {

	public Node<Avenger> head;
	public Node<Avenger> tail;
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
	
	SLL<Avenger> avengersList = new SLL<>();
	int totalWordCount = 0;
	int topN = 4;
	
	public static void main(String[] args) {
		A2 manager = new A2();
		manager.run();
	}

	public void run() {
		readInput(avengersList);
		printResults(totalWordCount, avengersList);
	}

	public void readInput(SLL<Avenger> avengersList) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String word = input.next();
			word = word.trim().toLowerCase().split("'")[0].replaceAll("[^\\\\sa-zA-Z]", "");
			if (word.length() != 0) {
				totalWordCount++;
				matchIncrement(word, avengersList, possibleAvengers);
			}
		}
		input.close();
	}

	/*
	 * Matching and incrementing each Avenger's counts
	 */
	
	// I THINK THERES SOMETHING WRONG WITH THIS ONE
	/*
	 * implement something along the lines of 
	 * if name == alias/name/actor
	 * 		checkList(avenger) {check if exists}
	 * 		incrememntCount {adds to appropriate counter}
	 * check this for every avenger?
	 */
	public void matchIncrement(String word, SLL<Avenger> list, Avenger[] avs) {	
		Node<Avenger> iterator = list.getHead();
		if (iterator == null) {
			checkList(list, iterator);
		}
		else {
			while (iterator != null) {
				if (word.equals(iterator.getData().getAlias())) {
					iterator.getData().incrementAliasCount();
					checkList(list, iterator);
				}
				else if (word.equals(iterator.getData().getName())) {
					iterator.getData().incrementNameCount();
					checkList(list, iterator);
				}
				else if (word.equals(iterator.getData().getActor())) {
					iterator.getData().incrementActorCount();
					checkList(list, iterator);
				}
				iterator = iterator.getNext();
			}
		}
	}

	// adds to given list if given avenger isnt in it
	public void checkList(SLL<Avenger> list, Node<Avenger> av) {
		if (!list.contains(av)) {
			list.addTail(av);
		}
	}
	
	public void addInOrderTotal(SLL<Avenger> list, Node<Avenger> av) {
		// check if 0
		if (list.getHead() == null) {
			list.addHead(av);
		}
		// check if 1
		else if (list.getHead().getNext() == null) {
			int headTotal = list.getHead().getData().getTotalCount();
			int avTotal = av.getData().getTotalCount();
			
			// av count > head count
			if (avTotal > headTotal) {
				addHead(av);
			}
			// av count < head count
			else if (avTotal < headTotal) {
				addTail(av);
			}
			// av count == head count
			else {
				// if avActor > headActor
				if (av.getData().compareTo(head.getData()) > 0) {
					addHead(av);
				}
				// if avActor < headActor
				else if (av.getData().compareTo(head.getData()) < 0) {
					addTail(av);
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
	
	public void addInOrderActor(SLL<Avenger> list, Node<Avenger> av) {
		// check if 0
		if (list.getHead() == null) {
			list.addHead(av);
		}
		// check if 1
		else if (list.getHead().getNext() == null) {
			int headActor = list.getHead().getData().getActorCount();
			int avActor = av.getData().getActorCount();
			
			// av count > head count
			if (avActor > headActor) {
				addHead(av);
			}
			// av count < head count
			else if (avActor < headActor) {
				addTail(av);
			}
			// av count == head count
			else {
				// if avActor > headActor
				if (av.getData().compareTo(head.getData()) > 0) {
					addHead(av);
				}
				// if avActor < headActor
				else if (av.getData().compareTo(head.getData()) < 0) {
					addTail(av);
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

	public void addInOrderAlphabetical(SLL<Avenger> list, Node<Avenger> av) {
		// check if 0
		if (list.getHead() == null) {
			list.addHead(av);
		}
		// check if 1
		else if (list.getHead().getNext() == null) {
			// av > head
			if (av.getData().getAlias().compareTo(list.getHead().getData().getActor()) > 0) {
				addHead(av);
			}
			// av < head
			else if (av.getData().getAlias().compareTo(list.getHead().getData().getActor()) < 0) {
				addTail(av);
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
	public void printInOrder(SLL<Avenger> totalList) {
		 Node<Avenger> iterator = totalList.getHead();
		 
		 if (iterator == null ) {
			 System.out.println("Error");
		 }
		 else {
			 while (iterator.getNext() != null) {
				 System.out.println(iterator.toString());
				 iterator = iterator.getNext();
			 }
		 }
	}
	
	// finds top four, prints
	public void printTopNAvengers(SLL<Avenger> totalList) {
		Node<Avenger> iterator = totalList.getHead();
		SLL<Avenger> list = new SLL<>();
		// iterates through totalList, adds everything to list in order
		while (iterator.getNext() != null) {
			addInOrderTotal(list, iterator);
			iterator = iterator.getNext();
		}
		
		Node<Avenger> printer = head;
		// one
		if (printer.getNext() == null) {
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
	
	// finds top four, prints
	public void printTopNPerformers(SLL<Avenger> totalList) {
		Node<Avenger> iterator = totalList.getHead();
		SLL<Avenger> list = new SLL<>();
		// iterates through totalList, adds everything to list in order
		while (iterator.getNext() != null) {
			addInOrderActor(list, iterator);
			iterator = iterator.getNext();
		}
		
		Node<Avenger> printer = head;
		// one
		if (printer.getNext() == null) {
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
	
	// sorts, prints alphabetical
	public void printAlphabetical(SLL<Avenger> totalList) {
		Node<Avenger> iterator = totalList.getHead();
		SLL<Avenger> list = new SLL<>();
		// iterates through totalList, adds everything to list in order
		while (iterator.getNext() != null) {
			addInOrderActor(list, iterator);
			iterator = iterator.getNext();
		}
		while (iterator.getNext() != null) {
			System.out.println(iterator.toString());
		}
	}

	private void printResults(int totalWordCount, SLL<Avenger> list) {
		System.out.println(totalWordCount);
		printInOrder(list);
//		printTopNAvengers(list);
//		printTopNPerformers(list);
//		printAlphabetical(list);
	}
}
