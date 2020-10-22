import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Triplets {

	public static void main(String[] args) {
		ArrayList<Long> al = new ArrayList<Long>();
		al.add(1L);
		al.add(5L);
		al.add(5L);
		al.add(25L);
		al.add(125L);
		
		System.out.println(countTriplets(al, 5));
	}
	
    static <K, V> void printMap(Map<K,V> map) {
    	Set<K> keys = map.keySet();
    	
    	for (K k : keys) {
    		System.out.println("<" + k + ", " + map.get(k) + ">");
    	}
    }

    static long countTriplets(List<Long> arr, long r) {
        long total = 0;
        
        Map<Long, Long> map = new HashMap<>();
        Map<Long, Long> store = new HashMap<>();
        
        for (long n : arr) {
        	System.out.println("Number is: " + n);
            if (n % r == 0) {
            	System.out.println(n + " % " + r + " == 0");
                
            	long pre = n / r;
                System.out.println(n + " / " + r + " = " + pre);
                
                Long cnt2 = store.get(pre);
                System.out.println(pre + " is stored as " + cnt2);
                
                if (cnt2 != null) {
                	total += cnt2;
                	System.out.println("total is " + total);
                }
                
                Long cnt1 = map.get(pre);
                System.out.println(pre + " is mapped to " + cnt1);
                
                if (cnt1 != null) {
                	store.put(n, store.getOrDefault(n, 0L) + cnt1);
                	System.out.println(cnt1 + " stored as " + store.get(n));
                }
            }
            map.put(n, map.getOrDefault(n, 0L) + 1);
            System.out.println(n + " mapped to " + map.get(n));
            System.out.println("map:");
            printMap(map);
            System.out.println("store:");
            printMap(store); 
            
            System.out.println();
        }
        return total;
    }
}
