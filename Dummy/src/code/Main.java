package code;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

	// Main Methode
	public static void main(String[] args) throws FileNotFoundException {
		Utils utils = new Utils();

		PrintWriter out = new PrintWriter("C://Users/Administrator/Desktop/TestFile.txt");

		for (int i = 0; i < utils.getDummyAmount(); i++) {
			Dummy temp = new Dummy();

			System.out.println(temp.getSureName() + " " + temp.getLastName());
			System.out.println(temp.getBirthday());
			Utils.printDummyToFile(out, temp);
		}
		out.close();

	}

}
