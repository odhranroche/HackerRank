import java.util.HashMap;
import java.util.Set;

public class RansomNote {

	public static void main(String[] args) {
		String magazine[] = {"give", "me", "me", "grand", "today", "night"};
		String note[]     = {"give", "one", "grand", "today"};
		
		
		checkMagazine(magazine, note);
	}
	
    static void printArray(int[] arr) {
		for (int i = 0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
    }
    
    static <K, V> void printMap(HashMap<K,V> map) {
    	Set<K> keys = map.keySet();
    	
    	for (K k : keys) {
    		System.out.println("<" + k + ", " + map.get(k) + ">");
    	}
    }

    static HashMap<String, Integer> getWords(String[] magazine) {
    	HashMap<String, Integer> words = new HashMap<String, Integer>();
    	for (String s : magazine) {
    		int wordCount = words.get(s) != null ? words.get(s) : 0;
    		words.put(s, wordCount + 1);
    	}
    	
    	return words;
    }
    
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	HashMap<String, Integer> words = getWords(magazine);

    	for (String noteWord : note) {
    		if (words.get(noteWord) != null) {
    			words.put(noteWord, words.get(noteWord) - 1);
    		}

    		if (words.get(noteWord) == null || words.get(noteWord) < 0) {
    			System.out.println("No");
    			return;
    		}
    	}
    	System.out.println("Yes");
    }
}
