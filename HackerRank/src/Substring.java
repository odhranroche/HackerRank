public class Substring {
	public static void main(String[] args) {
		String part = "hello";
		String full = "world2";


		System.out.println(twoStrings(part, full));
	}

	static String[] partBreakdown(String part) {
		String[] parts = new String[part.length()]; 

		for (int i = 0; i < part.length(); i++) {
			parts[i] = part.substring(0, i+1);
		}

		return parts;
	}

	static String twoStrings(String s1, String s2) {
		String[] parts = partBreakdown(s1);

		for (String subPart : parts) {
			System.out.println("does " + s2 + " contain " + subPart);
			if (s2.contains(subPart))
				return "Yes";
		}

		return "No";
	}
}