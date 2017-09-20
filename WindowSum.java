public class WindowSum{
public static int[] sumSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
		int length = nums.length;
		int[] min = new int[length - k + 1];
		int index = 0;
		Deque<Integer> window = new ArrayDeque<>();
		for (int i = 0; i < length; i++) {
			while (!window.isEmpty() && (window.peek() < (i - k + 1))) {
				window.poll();
			}
			window.offer(i);
			if (i >= k - 1) {
				int sum = 0;
				for (Integer idx : window) {
					   sum = sum + nums[idx];
			    }
				min[index++] = sum;
				window.pollFirst();
			}
		}
		return min;
	}
}
