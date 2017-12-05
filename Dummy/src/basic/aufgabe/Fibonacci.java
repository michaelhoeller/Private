package basic.aufgabe;

public class Fibonacci {

	public static void main(String args[]) {
		int endValue = 10000;
		long fib1 = 0;
		long fib2 = 1;

		System.out.println(fib1);
		while (fib2 <= endValue) {
			System.out.println(fib2);
			long newFib = fib1 + fib2;
			fib1 = fib2;
			fib2 = newFib;
		}

	}
}
