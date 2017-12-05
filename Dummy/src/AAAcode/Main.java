package AAAcode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

	// Main Methode
	public static void main(String[] args) throws FileNotFoundException {

		Utils utils = new Utils();

		PrintWriter out = new PrintWriter(utils.getOutPutLoc());

		Utils.printHeaderToFile(out, utils.getDummyAmount());
		System.out.println("Generating " + utils.getDummyAmount() + " Dummys @ " + utils.getOutPutLoc());
		for (int i = 0; i < utils.getDummyAmount(); i++) {
			Dummy temp = new Dummy(utils);
			Utils.printDummyToFile(out, temp);
		}

		Utils.printEndingToFile(out);
		out.close();
		System.out.println("Finished");
	}

}