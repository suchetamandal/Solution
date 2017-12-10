 /*
 There is a length of N flower beds, every day a exactly a flower, given a 1-N permutation, representing the flowering position every day. Assuming that at some point the flowers in i and j are blooming and there is no other bloom between i and j, then there is an empty slot of length ji-1 in the middle (the leftmost flower is considered and the leftmost empty slot, rightmost consideration and empty slot at the right end of the flower bed). Given the permutation P and a specified empty slot size K, which day is the earliest, an empty slot of size K appears in the flowerbars and returns -1 if it never appears. Requires O (N) space, O (NlogN) time.
 */
 
import java.util.TreeSet;

public class FlowerDay {
	public int theEarlyDay(int[] order, int size) {
		int len = order.length;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < len; i++) {
			set.add(order[i]);
			int left = 0, right = 0;
			if (set.lower(order[i]) == null)
				left = order[i] - 1;
			else
				left = order[i] - set.lower(order[i]) - 1;
			if (left == size)
				return i + 1;
			if (set.higher(order[i]) == null)
				right = len - order[i];
			else
				right = set.higher(order[i]) - order[i] - 1;
			if (right == size)
				return i + 1;
		}
		return -1;
	}
}
