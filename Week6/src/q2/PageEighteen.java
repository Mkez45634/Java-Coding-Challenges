package q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

import q1.BirdDetails;

public class PageEighteen {
	public static void main(String args[]) {
		//1. ArrayList of Strings e.g
		System.out.println(birdNames());

		//2. a TreeSet of Strings e.g.
		System.out.println(sortedBirdNames());

		//3. a TreeMap of Strings and BirdDetails Object
		for (String i : birdTreeMap().keySet()) {
			System.out.println("key: " + i + " latin name: " + birdTreeMap().get(i).getLatinName() + " average lifespan: " + birdTreeMap().get(i).getAvgLifespan());
		}
		
		//4. as above but in an order
		TreeMap<String, BirdDetails> bhmReverse = new TreeMap<String, BirdDetails>(Collections.reverseOrder());
		bhmReverse.putAll(birdTreeMap());
		
		System.out.println("\nIn an order:");
		
		for (String i : bhmReverse.keySet()) {
			System.out.println("key: " + i + " latin name: " + bhmReverse.get(i).getLatinName() + " average lifespan: " + bhmReverse.get(i).getAvgLifespan());
		}
	}
	public static ArrayList<String> birdNames() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("bluetit");
		al.add("bluetit");
		al.add("robin");
		al.add("blackbird");
		al.add("robin");	
		al.add("bluetit");
		return al;
	}
	public static TreeSet<String> sortedBirdNames(){
		TreeSet<String> sortedSet = new TreeSet<String>();
		sortedSet.add("bluetit");
		sortedSet.add("bluetit");
		sortedSet.add("robin");
		sortedSet.add("blackbird");
		sortedSet.add("robin");	
		sortedSet.add("bluetit");
		sortedSet.add("thrush");
		return sortedSet;
	}

	public static TreeMap<String, BirdDetails> birdTreeMap() {
		TreeMap<String, BirdDetails> bhm = new TreeMap<String, BirdDetails>();
		bhm.put("bluetit", new BirdDetails("Cyanistes caeruleus", "3"));
		bhm.put("bluetit", new BirdDetails("Cyanistes caeruleus", "3"));
		bhm.put("robin", new BirdDetails("Erithacus rubecula", "2"));
		bhm.put("blackbird", new BirdDetails("Turdus merula", "2.4"));
		bhm.put("robin", new BirdDetails("Erithacus rubecula", "2"));	
		bhm.put("bluetit", new BirdDetails("Cyanistes caeruleus", "3"));
		//bhm.put("thrush"); Thrush isn't a bird, it's a family of birds
		return bhm;

	}
}
