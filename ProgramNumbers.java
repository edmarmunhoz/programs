import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramNumbers {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String a;
		String b;
		StringBuilder c = new StringBuilder();
		
		System.out.println("Informe o número A: ");
		a = read.readLine();
		System.out.println("Informe o número B: ");
		b = read.readLine();
		
		int size = returnSizeOfNumbers(a,b);
		int count = 0;
		
		while (isEligible(size, count)) {
			if (hasCharacter(a, count))
				c.append(appendCharacter(a, count));
			if (hasCharacter(b, count))
				c.append(appendCharacter(b, count));
			count++;
		}
		
		printResult(c);		
	}

	private static String appendCharacter(String a, int count) {
		return a.substring(count, count+1);
	}

	private static boolean isEligible(int size, int count) {
		return count < (size);
	}

	private static void printResult(StringBuilder c) {
		if (Integer.valueOf(c.toString()) > 1000000)		
			System.out.println("-1");
		else
			System.out.println(c);
	}

	private static boolean hasCharacter(String a, int count) {
		return a.length() > count;
	}

	private static int returnSizeOfNumbers(String a, String b) {
		int size = a.length();
		if (hasCharacter(b, size))
			size = b.length();
		return size;
	}
	
}
