import java.util.ArrayList;
import java.util.Scanner;

public class A2 extends Avenger {

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

	public static void main(String[] args) {
		A2 manager = new A2();
		manager.run();
	}

	public void run() {
//		readInput();
//		printResults(avengersList);
		// Avenger objects
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
		int totalWordCount = 0;
		while (input.hasNext()) {
			String word = input.next();
			word = word.trim().toLowerCase().split("'")[0].replaceAll("[^\\\\sa-zA-Z]", "");
			if (word.length() != 0) {
				totalWordCount++;
			}
		}
		input.close();
	}

	/*
	 * Matching and incrementing each Avenger's counts
	 */
	public void matchIncrement(String word, ArrayList<Avenger> avenger) {
		for (int i = 0; i < avenger.size(); i++) {
			if (word.equals(avenger.get(i).getAlias())) {
				avenger.get(i).incrementAliasCount();
				checkList(avenger.get(i));
				return;
			} else if (word.equals(avenger.get(i).getName())) {
				avenger.get(i).incrementNameCount();
				checkList(avenger.get(i));
				return;
			} else if (word.equals(avenger.get(i).getActor())) {
				avenger.get(i).incrementActorCount();
				checkList(avenger.get(i));
				return;
			}
		}
	}

	/*
	 * Checks if an avenger mentioned is found in the avengersList If not add the
	 * avenger to the avengerList
	 */
	public void checkList(Avenger a) {
		Node<Avenger> newNode = new Node<>(a);

	}
}
