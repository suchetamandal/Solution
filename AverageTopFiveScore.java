import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

public class AverageTopFiveScore {

	public static void main(String[] args) {

	}

	@Test
	public void testAboveCode() {
		assertEquals(Collections.singletonMap(1, 76.00),
				scoresAverage(Arrays.asList(new TestResult(1, 100), new TestResult(1, 80), new TestResult(1, 90),
						new TestResult(1, 70), new TestResult(1, 40), new TestResult(1, 20))));
	}

	public static Map<Integer, Double> scoresAverage(List<TestResult> results) {
		Map<Integer, PriorityQueue<Integer>> scoresMap = new HashMap<Integer, PriorityQueue<Integer>>();
		Map<Integer, Double> avgResult = new HashMap<Integer, Double>();
		if (results == null || results.size() == 0) {
			return avgResult;
		}
		for (TestResult res : results) {
			if (scoresMap.containsKey(res.studentId)) {
				PriorityQueue<Integer> pq = scoresMap.get(res.studentId);
				pq.add(res.testScore);
				scoresMap.put(res.studentId, pq);
			} else {
				PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
				pq.add(res.testScore);
				scoresMap.put(res.studentId, pq);
			}
		}

		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : scoresMap.entrySet()) {
			PriorityQueue<Integer> pq = entry.getValue();
			double avg = getAverage(pq, 5);
			avgResult.put(entry.getKey(), avg);
		}
		return avgResult;
	}

	public static double getAverage(PriorityQueue<Integer> pq, int count) {
		double avg = 0.0;
		int num = count;
		while (count > 0 && !pq.isEmpty()) {
			avg = avg + pq.remove();
			count--;
		}
		return (avg / num);
	}

}
