public class MinSlidingWindow{

public int[] minSlidingWindow(int[] nums, int k) {
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
			while (!window.isEmpty() && nums[window.peekLast()] > nums[i]) {
				window.pollLast();
			}
			window.offer(i);
			if (i >= k - 1) {
				min[index++] = nums[window.peek()];
			}
		}
		return min;
	}
}
