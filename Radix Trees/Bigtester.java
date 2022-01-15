import java.util.*;
import java.io.*;

public class Bigtester {
	public static void main(String[] args) {
		RadixTree dict = new RadixTree();
		try {
			
			File mydict = new File("dictionary.txt");
			Scanner scan = new Scanner(mydict);
		
			
			for (int i = 0; i < 1000; i++){
				String ins = format(scan.nextLine());
				dict.insert(ins);
			}
			System.out.println("before delete:\n" + dict + " - end\n\n");
		    //System.out.println(dict.nodePrint());
			scan = new Scanner(mydict);
			for (int i = 0; i < 1000; i++){
				String ins = format(scan.nextLine());
				//System.out.println("Deleting: " + ins);
				
				//System.out.println("About to delete " + ins + ", list is: \n" + dict);
				// if (ins.equals("a")){
				//  	System.out.println("About to delete " + ins + ", list is: \n" + dict);
				//  	System.out.println(dict.nodePrint());
				//  	System.out.println(dict.root + ", " + dict.root.getNode('a'));
				//  }
				dict.delete(ins);
				// if (ins.equals("a")){
				//  	//System.out.println("About to delete " + ins + ", list is: \n" + dict);
				//  	System.out.println(dict.nodePrint());
				// }
			}
			
		} catch (FileNotFoundException e){
			System.out.println("An error occurred.");
      		e.printStackTrace();
		}

		System.out.println("\n\nafter delete:\n" + dict + " - end\n\n");
		System.out.println(dict.nodePrint());

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