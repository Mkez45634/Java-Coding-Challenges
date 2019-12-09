package q1;

import java.util.*;
public class SetExample {
	//see comments at the bottom
	public static void main(String args[]) {
		System.out.println(myHashSet());
		System.out.println(mySortedSet(myHashSet()));
	}

	public static Set<String> myHashSet() {
		Set<String> set = new HashSet<String>();
		set.add("Bernadine");
		set.add("Elizabeth");
		set.add("Gene");
		set.add("Elizabeth");
		set.add("Clara");	
		return set;
	}
	public static Set<String> mySortedSet(Set<String> s) {
		Set<String> sortedSet = new TreeSet<String>(s);
		return sortedSet;
	}
}

/* 
  
 Sets are a collection of unsorted objects with no duplicates, 
 A HashSet is an implementation of set.
 On the other hand, a SortedSet(aka TreeSet) is a sorted implementation of set and thus has more overheads.

 */