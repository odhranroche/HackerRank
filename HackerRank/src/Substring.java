import java.util.HashMap;

public class Substring {
	public static void main(String[] args) {
		String part = "hello";
		String full = "wd";

		System.out.println(twoStrings(part, full));
	}

	static HashMap<Character, Boolean> partBreakdown(String part) {
		HashMap<Character, Boolean> letters = new HashMap<Character, Boolean>();

		for (int i = 0; i < part.length(); i++) {
			letters.put(part.charAt(i), true);
		}

		return letters;
	}

	static String twoStrings(String s1, String s2) {
		HashMap<Character, Boolean> letters = partBreakdown(s1);

		for (int i = 0; i < s2.length(); i++) {
			if (letters.containsKey(s2.charAt(i))) {
				return "YES";
			}
		}

		return "NO";
	}
}