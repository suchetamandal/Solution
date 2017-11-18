import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FindTwoSumK {

	@Test
	public void testMultiplyException() {
		FindTwoSumK tester = new FindTwoSumK();
		int arr[] = new int[] { -1,0,-1,0,2,1 };
		assertEquals(4, tester.getPairsCount(arr, 1));
	}

	int getPairsCount(int[] arr, int k) {
		HashMap<Integer, Integer> rest = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		for (int a : arr) {
			rest.put(a, (k - a));
			freq.put(a, freq.getOrDefault(a, 0) + 1);
		}

		int count = 0;
		for (Map.Entry<Integer, Integer> r : rest.entrySet()) {
			if (freq.containsKey(r.getKey()) && freq.containsKey(r.getValue())) {
				count = count + (freq.get(r.getKey()))*(freq.get(r.getValue()));
			}
		}
		return count/2;
	}

}
