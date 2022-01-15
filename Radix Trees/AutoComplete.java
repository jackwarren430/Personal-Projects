import java.util.*;
import java.io.*;

public class AutoComplete {
	public static void main(String[] args) {
		RadixTree dict = new RadixTree();
		try {
			
			File mydict = new File("advanceddict.txt");
			Scanner scan = new Scanner(mydict);
			
			while (scan.hasNextLine()){
				String ins = format(scan.nextLine());
			 	dict.insert(ins);
			}
		} catch (FileNotFoundException e){
			System.out.println("An error occurred.");
      		e.printStackTrace();
		}

		// System.out.println("after delete: " + dict + " - end");
		// System.out.println(dict.nodePrint());


		Scanner key = new Scanner(System.in);
		System.out.println("Type a prefix and press enter to autocomplete!");
		String input = key.nextLine();
		String auto = dict.getAutoComplete(input);
		System.out.println(input + " -> ");
		System.out.println(auto);

	}


	public static String format(String data){
		String toReturn = "";
		for (char c : data.toCharArray()){
			char a = Character.toLowerCase(c);
			if (a - 'a' >= 0 && a - 'a' < 26){
				toReturn += a;
			}
		}
		return toReturn;
	}
}