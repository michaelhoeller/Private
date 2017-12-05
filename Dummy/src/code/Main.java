package code;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

	// Main Methode
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Started");
		Utils utils = new Utils();

		PrintWriter out = new PrintWriter(utils.getOutPutLoc());

		Utils.printHeaderToFile(out, utils.getDummyAmount());
		for (int i = 0; i < utils.getDummyAmount(); i++) {
			Dummy temp = new Dummy(utils);
			Utils.printDummyToFile(out, temp);
			// if ((utils.getDummyAmount() / 100) % (i + 1) == 0) {
			// System.out.print(".");
			// }
		}
		System.out.println();
		Utils.printEndingToFile(out);
		out.close();
		System.out.println("Finished");
	}

}
