public class RadixTreeTester {
	public static void main(String[] args) {
		RadixTree tree = new RadixTree();

		tree.insert("water");
		tree.insert("watch");
		tree.insert("waste");
		tree.insert("weather");
		tree.insert("weeds");
		

		//tree.delete("waste");
		//tree.delete("watch");
		tree.delete("weather");
		//tree.delete("waste");
		tree.delete("weeds");
		//tree.delete("water");
		tree.delete("waste");

		System.out.println(tree);
		System.out.println(tree.nodePrint());
		//System.out.println(tree.contains("waste"));
	}
}