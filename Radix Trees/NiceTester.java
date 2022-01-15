public class NiceTester {
	public static void main(String[] args) {
		RadixTree test = new RadixTree();
		System.out.println("-------------------------------");
		System.out.println("Starting test");
		System.out.println("\nInserting: \"bagel\"");
		test.insert("bagel");
		System.out.println("Contains \"bagel\": " + test.contains("bagel"));
		System.out.println("Should be: true");
		System.out.println("-------------------------------");
		System.out.println("Inserting list of items:\n\"cream\", \"cheese\", \"biscuit\", \"beluga\", \"checkers\"\n\"burritos\", \"jester\", \"joker\"");
		test.insert("cream");
		test.insert("cheese");
		test.insert("biscuit");
		test.insert("beluga");
		test.insert("checkers");
		test.insert("burritos");
		test.insert("jester");
		test.insert("joker");
		System.out.println("\nToString of tree:\n" + test);
		System.out.println("-------------------------------");
		System.out.println("Contains \"biscuit\": " + test.contains("biscuit"));
		System.out.println("Should be: true");
		System.out.println("Contains \"hollaback\": " + test.contains("hollaback"));
		System.out.println("Should be: false");
		System.out.println("Contains \"cheese\": " + test.contains("cheese"));
		System.out.println("Should be: true");
		System.out.println("-------------------------------");
		System.out.println("Deleting: \"cheese\", \"bagel\", \"cream\", \"jester\", \"checkers\"\n");
		test.delete("cheese");
		test.delete("bagel");
		test.delete("cream");
		test.delete("jester");
		test.delete("checkers");
		System.out.println("ToString of tree:\n" + test);
		System.out.println("ToString of all the stored nodes for fun:\n" + test.nodePrint());
		System.out.println("-------------------------------");
		System.out.println("Contains \"cheese\": " + test.contains("cheese"));
		System.out.println("Should be: false");
		System.out.println("-------------------------------");
		System.out.println("Deleting rest of items: \"beluga\", \"biscuit\", \"burritos\", \"joker\"");
		test.delete("beluga");
		test.delete("biscuit");
		test.delete("burritos");
		test.delete("joker");
		System.out.println("ToString of tree:\n" + test);
		System.out.println("Should be empty");
		System.out.println("NodePrint should be empty, is:\n" + test.nodePrint());
		
	}
}