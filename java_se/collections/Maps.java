package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Maps are used to store Key-Value pairs <K,V>, where each key must be unique
 * (allows for a single null key), but values can have duplicates (allows for
 * nulls).
 * 
 * Maps: HashMap, LinkedHashMap, TreeMap.
 */
public class Maps {

	// Most common Map implementations coincide with Set implementations.
	
	public static void hashMap() {
		Map<String, Integer> ids = new HashMap<>(); 
		/*
		 * Utilizes a Hash algo to store (key=value) in storage.
		 * 
		 * HashMap does not maintain the order of the elements added.
		 * 
		 * Retrieval of values = O(1).
		 */
		
		ids.put("John", 16739);
		ids.put("Amanda", 38849);
		ids.put("Brian", 00321);
		ids.put("Joe", 84844);
		
		ids.get("John");
		
		System.out.println("HashMap: " + ids);
	}

	public static void linkedHashMap() {
		Map<String, Integer> ids = new LinkedHashMap<>(); 
		/*
		 * LinkedHashSet maintains the order of the elements added.
		 */
		
		ids.put("John", 16739);
		ids.put("Amanda", 38849);
		ids.put("Brian", 00321);
		ids.put("Joe", 84844);
				
		System.out.println("HashMap: " + ids);
	}

	public static void treeMap() {
		Map<String, Integer> ids = new TreeMap<>(); 
		/*
		 * TreeMap uses a balanced tree to store a sorted Set.
		 */
		
		ids.put("John", 16739);
		ids.put("Amanda", 38849);
		ids.put("Brian", 00321);
		ids.put("Joe", 84844);
				
		System.out.println("HashMap: " + ids);
	}
	
	public static void main(String[] args) {
		hashMap();
		linkedHashMap();
		treeMap();
	}

}
