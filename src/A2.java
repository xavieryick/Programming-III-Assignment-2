import java.util.Scanner;

public class A2 {

	public Avenger head;
	public Avenger tail;
	
	public static void main(String[] args) {
		A2 manager = new A2();
		manager.run();
	}
	
	public void run() {
//		readInput();
//		printResults(avengersList);
	}
	
	public void readInput() {
		// only has totalWordCount, not avenger count, can iterate through avenger SLL to find this
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
	
   private void addHead(Avenger n) 
   {
	   if (emptyList()) {
		   head = n;
		   tail = n;
	   }
	   else {
		   n.setNext(head);
		   head = n;
	   }
   }
	
   private void addTail(Avenger n) 
   {
	   if (emptyList()) {
		   head = n;
		   tail = n;
	   }
	   else {
		   tail.setNext(n);
		   tail = n;
	   }
   }
	
   public boolean emptyList()
   {
       if (head == null) return true;
       return false;
   }  
}
