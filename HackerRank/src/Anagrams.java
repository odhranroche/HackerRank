import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Anagrams {

	public static void main(String[] args) {
		String word1 = "ifailuhkqq";
		String word2 = "kkkk";
		String word3 = "cdcd";

		System.out.println(sherlockAndAnagrams(word1));
	}
	
	static ArrayList<String> getSubtrings(String str) {
		ArrayList<String> al = new ArrayList<String>();

		// for each length of substring, 1,2,3 ...
		for (int len = 1; len <= str.length(); len++) {
			// cut out part of the string
			for (int i = 0; i <= str.length() - len; i++) {

				int j = i + len - 1;

				String temp = "";
				for (int k = i; k <= j; k++) {
					temp += str.charAt(k);
				}

				al.add(temp);
			}
		}
		return al;
	}
	
	static String sortString(String s){
		char[] letters = s.toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}

    static <K, V> void printMap(HashMap<K,V> map) {
    	Set<K> keys = map.keySet();
    	
    	for (K k : keys) {
    		System.out.println("<" + k + ", " + map.get(k) + ">");
    	}
    }
    
    static int sherlockAndAnagrams(String s) {
    	HashMap<String, Integer> numAnagrams = new HashMap<String, Integer>();
    	
    	ArrayList<String> substrings = getSubtrings(s);
    	for (String wordPart : substrings) {
    		String sortedWordPart = sortString(wordPart);
    		
    		if (numAnagrams.get(sortedWordPart) == null) {
    			numAnagrams.put(sortedWordPart, 0);
    		} else {
    			numAnagrams.put(sortedWordPart, numAnagrams.get(sortedWordPart) + 1);
    		}
    	}
    	
    	int total = 0;
    	for (Integer i : numAnagrams.values()) {
    		
    		int calculatedValue = i;
    		for (int j = 0; j < i; j++) {
    			calculatedValue += j;
    		}
    		
    		total += calculatedValue;
    	}
    	
		return total;
    }
}