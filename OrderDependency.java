import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javafx.util.Pair;

public class OrderDependency {

	public static void main(String[] args) {
		ArrayList<Pair<Integer, Integer>> vec = new ArrayList<Pair<Integer, Integer>>();
		vec.add(new Pair<Integer, Integer>(1, 2));
		vec.add(new Pair<Integer, Integer>(0, 2));
		vec.add(new Pair<Integer, Integer>(3, 1));
		vec.add(new Pair<Integer, Integer>(3, 2));

		ArrayList<Integer> ret = findOrder(4, vec);
		for (int i = 0; i < ret.size(); i++) {
			System.out.print(ret.get(i));
			System.out.print(" ");
		}
	}

	public final static ArrayList<Integer> findOrder(int numCourses, ArrayList<Pair<Integer, Integer>> prerequisites) {

		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (prerequisites.size() == 0) {
			for (int i = 0; i < numCourses; i++) {
				ret.add(i);
			}
			return ret;
		}
		TreeMap<Integer, Integer> indegree = new TreeMap<Integer, Integer>();
		for (int i = 0; i < numCourses; i++) {
			indegree.put(i, 0);
		}
		for (int i = 0; i < prerequisites.size(); i++) {
			Pair<Integer, Integer> p = prerequisites.get(i);
			int val = indegree.get(p.getKey());
			indegree.put(p.getKey(), val + 1);
		}

		while (ret.size() != numCourses) {
			boolean hasZero = false;
			for (Map.Entry<Integer, Integer> entryMap : indegree.entrySet()) {
				if (entryMap.getValue() == -1) {
					continue;
				}
				if (entryMap.getValue() != 0) {
					continue;
				}
				hasZero = true;
				ret.add(entryMap.getKey());
				for (int i = 0; i < prerequisites.size(); i++) {
					Pair<Integer, Integer> p = prerequisites.get(i);
					if (p.getValue() == entryMap.getKey()) {
						int val = indegree.get(p.getKey());
						indegree.put(p.getKey(), val - 1);
					}
				}

				entryMap.setValue(-1);
			}

			if (hasZero == false) {
				ArrayList<Integer> empty = new ArrayList<Integer>();
				return empty;
			}
		}

		return ret;

	}
}
