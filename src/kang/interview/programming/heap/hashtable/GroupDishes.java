package kang.interview.programming.heap.hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import kang.interview.programming.util.DataPrinter;

/**
 * You have a list of dishes. Each dish is associated with a list of ingredients used to prepare it. 
 * You want to group the dishes by ingredients, so that for each ingredient you'll be able to find 
 * all the dishes that contain it (if there are at least 2 such dishes).
 * 
 * Return an array where each element is a list with the first element equal to the name of the 
 * ingredient and all of the other elements equal to the names of dishes that contain this ingredient. 
 * The dishes inside each list should be sorted lexicographically. The result array should be sorted 
 * lexicographically by the names of the ingredients in its elements.

	Example
	
	For
	  dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
	            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
	            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
	            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
	the output should be
	  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
	                            ["Salad", "Salad", "Sandwich"],
	                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
	                            ["Tomato", "Pizza", "Salad", "Sandwich"]]
	For
	  dishes = [["Pasta", "Tomato Sauce", "Onions", "Garlic"],
	            ["Chicken Curry", "Chicken", "Curry Sauce"],
	            ["Fried Rice", "Rice", "Onions", "Nuts"],
	            ["Salad", "Spinach", "Nuts"],
	            ["Sandwich", "Cheese", "Bread"],
	            ["Quesadilla", "Chicken", "Cheese"]]
	the output should be
	  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
	                            ["Chicken", "Chicken Curry", "Quesadilla"],
	                            ["Nuts", "Fried Rice", "Salad"],
	                            ["Onions", "Fried Rice", "Pasta"]]
                            
 * @author Yan Kang
 *
 */
public class GroupDishes {
	
	/**
	 * 
	 * @param dishes
	 * @return
	 */
	String[][] groupingDishes(String[][] dishes) {
		
		SortedMap<String, SortedSet<String>> map = new TreeMap<>();
		int recNum = 0;
		for (String[] dish : dishes) {
			for (int i = 1; i < dish.length; i++) {	
				SortedSet<String> set = map.get(dish[i]);
				if(set == null) {
					set = new TreeSet<>();
					map.put(dish[i], set);
				}
				set.add(dish[0]);
				// Point: When the size of the dishes for a particular
				// ingredient reaches two, we are going to record this
				// ingredient with its dish.
				if (set.size() == 2) recNum++;
			    
			}
		}
		
		String[][] ins = new String[recNum][];
		int i = 0;
		for (String key : map.keySet()) {
			SortedSet<String> sortedD = map.get(key);
			if (sortedD.size() > 1) {
				ins[i] = new String[sortedD.size() + 1];
				ins[i][0] = key;
				int j = 1;
				for (String d : sortedD) ins[i][j++] = d;
				i++;
			}
		}
		return ins;
	}

	/**
	 * From CodeFights: This algorithm follows the same idea as the one above.
	 * The difference is that it does not use TreeSet and TreeMap and using sort
	 * algorithm to do the task, which I think is less efficient.
	 * 
	 * @param dishes
	 * @return
	 */
	String[][] groupingDishes_(String[][] dishes) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (String[] ingred : dishes) {
			for (int i = 1; i < ingred.length; i++) {
				if (map.containsKey(ingred[i])) {
					ArrayList<String> foods = map.get(ingred[i]);
					foods.add(ingred[0]);
					map.put(ingred[i], foods);
				} else {
					ArrayList<String> foods = new ArrayList<>();
					foods.add(ingred[0]);
					map.put(ingred[i], foods);
				}
			}
		}

		ArrayList<String[]> list = new ArrayList<>();
		for (String ingred : map.keySet()) {
			ArrayList<String> foods = map.get(ingred);
			if (foods.size() > 1) {
				Collections.sort(foods);
				String[] fin = new String[foods.size() + 1];
				fin[0] = ingred;
				for (int i = 0; i < foods.size(); i++)
					fin[i + 1] = foods.get(i);
				list.add(fin);
			}
		}

		// Using Java 8.0 comparator function interface
		Collections.sort(list, (a, b) -> a[0].compareTo(b[0]));
		return list.toArray(new String[0][]);
	}
	
	public static void main(String[] args) {
		String[][] dishes = { 
				{ "Salad", "Tomato", "Cucumber", "Salad", "Sauce" },
				{ "Pizza", "Tomato", "Sausage", "Sauce", "Dough" }, 
				{ "Quesadilla", "Chicken", "Cheese", "Sauce" },
				{ "Sandwich", "Salad", "Bread", "Tomato", "Cheese" } 
				};
		GroupDishes d = new GroupDishes();
		String[][] res = d.groupingDishes(dishes);
		DataPrinter.print2DArray(res);
	}
}
